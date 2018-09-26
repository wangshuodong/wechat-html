package com.wangsd.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wangsd.common.base.MyController;
import com.wangsd.common.utils.Charsets;
import com.wangsd.common.utils.DecimalFormatUtils;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.common.utils.URLUtils;
import com.wangsd.web.model.Housinginfo;
import com.wangsd.web.model.Propertyinfo;
import com.wangsd.web.model.Roominfo;
import com.wangsd.web.model.Weixinuser;
import com.wangsd.web.pojo.BillaccountCustom;
import com.wangsd.web.pojo.RoomCustom;
import com.wangsd.web.service.*;
import com.wangsd.web.utils.HainaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/haina")
public class HainaController extends MyController {

    @Autowired
    HainaUtil hainaUtil;
    @Autowired
    IWeixinuserService weixinuserService;
    @Autowired
    IPropertyinfoService propertyinfoService;
    @Autowired
    IHousinginfoService housinginfoService;
    @Autowired
    IRoominfoService roominfoService;
    @Autowired
    IBillaccountService billaccountService;

    @RequestMapping("/pcIndex")
    public String pcIndex() {
        String ret = "haina/index";
        String user_code = request.getParameter("user_code");
        logger.debug("user_code=" + user_code);
        String str = hainaUtil.getUserByUserCode(user_code);
        logger.debug(str);
        JSONObject obj = JSONObject.parseObject(str);
        if (obj.getIntValue("retcode") == 0) {
            String property_id = obj.getJSONObject("data").getString("property_id");
            Propertyinfo pquery = new Propertyinfo();
            pquery.setWeixin_children_num(property_id);
            Propertyinfo propertyinfo = propertyinfoService.selectOne(pquery);
            if (propertyinfo != null) {
                try {
                    response.sendRedirect("https://www.alipayjf.com/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        String callback_url = URLUtils.encodeURL("http://www.cqzykj.top/wechat/haina/index", Charsets.UTF_8);
        String resident_code = request.getParameter("resident_code");
        String open_id = request.getParameter("open_id");
        String open_code = request.getParameter("open_code");
        String register_url = request.getParameter("register_url");
        logger.debug("resident_code=" + resident_code);
        logger.debug("open_id=" + open_id);
        logger.debug("open_code=" + open_code);
        logger.debug("register_url=" + register_url);
        String str;
        //已在腾讯海纳注册的用户
        if (resident_code != null) {
            str = hainaUtil.getUserInfoByResident_code(resident_code);
            logger.debug(str);
            JSONObject obj = JSONObject.parseObject(str);
            String property_id = obj.getJSONObject("data").getString("property_id");

            request.getSession().setAttribute("property_id", property_id);
            request.getSession().setAttribute("open_id", open_id);

            //获取用户绑定的小区信息
            JSONArray houses = obj.getJSONObject("data").getJSONArray("houses");
            logger.debug("houses=" + houses);
//            List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(open_id);

            model.addAttribute("list", houses);
            return "haina/myHousing";
        } else { //如果没有注册 open_code 肯定有值
            try {
                response.sendRedirect(register_url + "?callback_url=" + callback_url + "&agent_id=" + StaticVar.haina_agent_id);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            str = hainaUtil.getUserInfoByOpen_code(open_code);
//            logger.debug(str);
            return null;
        }

    }

    /**
     * 打开新增房间页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/openHousing")
    public String openHousing(Model model) {
        String appId = (String) request.getSession().getAttribute("property_id");

        //查询对应物业下的所有小区
        Propertyinfo query2 = new Propertyinfo();
        query2.setWeixin_children_num(appId);
        Propertyinfo propertyinfo = propertyinfoService.selectOne(query2);
        Example example = new Example(Housinginfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", propertyinfo.getId()).andEqualTo("deleteStatus", false);
        List<Housinginfo> list = housinginfoService.selectByExample(example);

        List<Map<String, String>> retList = new ArrayList<>();
        if (list != null) {
            for (Housinginfo info : list) {
                Map map = new HashMap();
                map.put("title", info.getName());
                map.put("value", info.getId());
                retList.add(map);
            }
        }
        model.addAttribute("list", JSONArray.toJSON(retList));
        return "haina/housing";
    }

    /**
     * 绑定房间
     *
     * @param weixinuser
     * @param model
     * @return
     */
    @RequestMapping("/bindingRoom")
    public String bindingRoom(Weixinuser weixinuser, Model model) {
        String openid = (String) request.getSession().getAttribute("open_id");
        weixinuser.setOpenid(openid);
        weixinuserService.bingRoom(weixinuser);
        List<RoomCustom> roomlist = weixinuserService.queryRoomBunding(openid);

        model.addAttribute("list", JSONArray.toJSON(roomlist));
        return "haina/myHousing";
    }

    /**
     * 打开账单页面
     *
     * @param communityName
     * @param roomName
     * @param model
     * @return
     */
    @RequestMapping("/openBill")
    public String openBill(String communityName, String roomName, Model model) {
        logger.debug("communityName=" + communityName);
        logger.debug("roomName=" + roomName);
        roomName = roomName.replaceAll("\\/", "");
        Housinginfo hquery = new Housinginfo();
        hquery.setDeleteStatus(false);
        hquery.setName(communityName);
        Housinginfo housinginfo = housinginfoService.selectOne(hquery);
        if (housinginfo != null) {
            Roominfo rquery = new Roominfo();
            rquery.setDeleteStatus(false);
            rquery.setParent_id(housinginfo.getId());
            rquery.setAddress(roomName);
            Roominfo roominfo = roominfoService.selectOne(rquery);
            List<BillaccountCustom> list = billaccountService.queryBillByRoomId(roominfo.getId());
            double sumAmount = 0;
            StringBuffer id = new StringBuffer();
            for (BillaccountCustom bill : list) {
                sumAmount += bill.getBill_entry_amount();
                id.append(bill.getId());
                id.append(",");
            }
            id.substring(0,id.length()-1);
            model.addAttribute("housinginfo", housinginfo);
            model.addAttribute("sumAmount", DecimalFormatUtils.format(sumAmount));
            model.addAttribute("list", list);
            model.addAttribute("id",id.toString());
            return "wechat/billaccount";
        } else {
            return "haina/success";
        }

    }
}
