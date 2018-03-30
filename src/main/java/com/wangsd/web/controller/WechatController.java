package com.wangsd.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.wangsd.common.base.MyController;
import com.wangsd.web.pojo.Report;
import com.wangsd.web.pojo.RoomCustom;
import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import com.wangsd.web.utils.WeixinUtil;
import com.wangsd.web.model.*;
import com.wangsd.web.pojo.BillaccountCustom;
import com.wangsd.web.service.*;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wechat")
public class WechatController extends MyController {

    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    @Autowired
    IWeixinconfigService weixinconfigService;
    @Autowired
    IPropertyinfoService propertyinfoService;
    @Autowired
    IHousinginfoService housinginfoService;
    @Autowired
    IRoominfoService roominfoService;
    @Autowired
    IWeixinuserService weixinuserService;
    @Autowired
    IBillaccountService billaccountService;

    /**
     * 公众号物业缴费入口
     * @param code
     * @param state
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/index")
    public String index(String code, String state, Model model) throws IOException {
        String appId = state;
        String openid = (String)request.getSession().getAttribute("openid");
        log.debug("用户openid:" + openid);
        if (openid == null) {
            openid = getOpenId(appId, code);
        }

//      String openid = "oEa9Lwa4kghRxeDHTSGlxYlz1XcI";

        List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(openid);

        model.addAttribute("list", JSONArray.fromObject(roomlist));
        return "wechat/myHousing";
    }

    /**
     * 打开新增房间页面
     * @param model
     * @return
     */
    @RequestMapping("/openHousing")
    public String openHousing(Model model) {
        String appId = (String)request.getSession().getAttribute("appId");
        List<Housinginfo> list = housinginfoService.queryHousingByAppId(appId);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Housinginfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getName());
                map.put("value", info.getId());
                retList.add(map);
            }
        }
        model.addAttribute("list", JSONArray.fromObject(retList));
        return "wechat/housing";
    }

    /**
     * 查询楼栋
     * @param roominfo
     * @return
     */
    @RequestMapping("/queryBuilding")
    @ResponseBody
    public List<Map<String, String>> queryBuilding(Roominfo roominfo) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("building");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", roominfo.getParent_id());
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getBuilding());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 查询单元
     * @param parentId
     * @param building
     * @return
     */
    @RequestMapping("/queryUnit")
    @ResponseBody
    public List<Map<String, String>> queryUnit(Integer parentId, String building) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("unit");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", parentId).andEqualTo("building", building);
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getUnit());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 查询房间
     * @param parentId
     * @param building
     * @param unit
     * @return
     */
    @RequestMapping("/queryRoom")
    @ResponseBody
    public List<Map<String, String>> queryRoom(Integer parentId, String building, String unit) {
        Example example = new Example(Roominfo.class);
        example.selectProperties("id", "room");
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", parentId)
                .andEqualTo("building", building)
                .andEqualTo("unit", unit);
        List<Roominfo> list = roominfoService.selectByExample(example);
        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Roominfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getRoom());
                map.put("value", info.getId());
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 绑定房间
     * @param weixinuser
     * @param model
     * @return
     */
    @RequestMapping("/bindingRoom")
    public String bindingRoom(Weixinuser weixinuser, Model model) {
        String openid = (String)request.getSession().getAttribute("openid");
        weixinuser.setOpenid(openid);
        weixinuserService.bingRoom(weixinuser);
        List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(openid);

        model.addAttribute("list", JSONArray.fromObject(roomlist));
        return "wechat/myHousing";
    }

    /**
     * 打开账单页面
     * @param roomid
     * @param model
     * @return
     */
    @RequestMapping("/openBill")
    public String openBill(Integer roomid, Model model) {

        Roominfo roominfo = roominfoService.selectByKey(roomid);
        Housinginfo housinginfo = housinginfoService.selectByKey(roominfo.getParent_id());

        List<BillaccountCustom> list = billaccountService.queryBillByRoomId(roomid);
        double sumAmount = 0;
        for (BillaccountCustom bill : list) {
            sumAmount += bill.getBill_entry_amount();
        }

        model.addAttribute("shopId", housinginfo.getOut_shop_id());
        model.addAttribute("sumAmount", sumAmount);
        model.addAttribute("list", list);
        return "wechat/billaccount";
    }

    /**
     * 删除绑定的房间
     * @param id
     */
    @RequestMapping("/deleteBingRoom")
    @ResponseBody
    public String deleteBingRoom(Integer id){
        weixinuserService.delete(id);
        return "success";
    }

    /**
     * 微信云支付交易完成回调
     */
    @RequestMapping("/whchatPayReturn")
    public void whchatPayReturn(@RequestBody Object request_content, Object authen_info) {
        log.debug("request_content==" + JSONObject.toJSONString(request_content));
        log.debug("authen_info==" + JSONObject.toJSONString(authen_info));
    }

    /**
     * 支付完成页
     */
    @RequestMapping("/whchatPaySuccess")
    public String whchatPaySuccess() {
        return "wechat/success";
    }

    /**
     * 打开报事报修页面
     * @return
     */
    @RequestMapping("/openReport")
    public String openReport(String code, String state, Model model) {
        String appId = "wxcfab4f09fe94c406";
        List<Housinginfo> list = housinginfoService.queryHousingByAppId(appId);
        model.addAttribute("list", list);
        return "wechat/report";
    }

    /**
     * 推送报事报修信息到打印机
     * @return
     */
    @RequestMapping("/sendReport")
    @ResponseBody
    public String sendReport(Report report) {
        log.debug(report.toString());

        return "提交成功";
    }

    public String getOpenId(String appId, String code) {
        Weixinconfig query = new Weixinconfig();
        query.setAppId(appId);
        Weixinconfig weixinconfig = weixinconfigService.selectOne(query);
        //获取网页授权access_token
        WeixinOauth2Token weixinOauth2Token = null;
        try {
            weixinOauth2Token = WeixinUtil.getOauth2AccessToken(weixinconfig.getAppId(), weixinconfig.getAppSecret(), code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 网页授权接口访问凭证
        String access_token = weixinOauth2Token.getAccess_token();
        // 用户标识
        String openid = weixinOauth2Token.getOpenid();
        // 获取用户信息
        //WechatUserInfo snsUserInfo = WeixinUtil.getWechatUserInfo(access_token, openid);
        request.getSession().setAttribute("appId", appId);
        request.getSession().setAttribute("openid", openid);
        return openid;
    }
}
