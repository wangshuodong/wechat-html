package com.wangsd.web.controller;

import com.wangsd.common.utils.WeixinUtil;
import com.wangsd.web.model.*;
import com.wangsd.web.pojo.BillaccountCustom;
import com.wangsd.web.pojo.WeixinOauth2Token;
import com.wangsd.web.service.*;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class WechatController {

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

    @RequestMapping("/index")
    public String index(String code, String state, Model model) throws IOException {
        String appId = state;
//        Weixinconfig query = new Weixinconfig();
//        query.setAppId(appId);
//        Weixinconfig weixinconfig = weixinconfigService.selectOne(query);
//        //获取网页授权access_token
//        WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(weixinconfig.getAppId(), weixinconfig.getAppSecret(), code);
//        // 网页授权接口访问凭证
//        String access_token = weixinOauth2Token.getAccess_token();
//        // 用户标识
//        String openid = weixinOauth2Token.getOpenid();
//        log.info("openid=" + openid);
        // 获取用户信息
        //WechatUserInfo snsUserInfo = WeixinUtil.getWechatUserInfo(access_token, openid);

        String openid = "oEa9Lwa4kghRxeDHTSGlxYlz1XcI";

        Weixinuser query3 = new Weixinuser();
        query3.setOpenid(openid);
        Weixinuser weixinuser = weixinuserService.selectOne(query3);
        if (weixinuser != null) {
            //直接跳转到账单界面
            List<BillaccountCustom> list = billaccountService.queryBillByRoomId(weixinuser.getRoominfoid());
            model.addAttribute("list", list);
            return "wechat/billaccount";
        } else {
            List<Housinginfo> list;
            if ("wxcfab4f09fe94c406".equals(appId)) {
                //查询所有小区
                list = housinginfoService.selectAll();
                model.addAttribute("list", list);
            }else {
                //查询对应物业下的所有小区
                Propertyinfo query2 = new Propertyinfo();
                query2.setWeixin_debit_num(appId);
                Propertyinfo propertyinfo = propertyinfoService.selectOne(query2);
                Example example = new Example(Housinginfo.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("parentId", propertyinfo.getId());
                list = housinginfoService.selectByExample(example);
            }
            List<Map<String, String>> retList = new ArrayList<>();
            if (list != null) {
                for (Housinginfo info : list) {
                    Map map = new HashMap();
                    map.put("title", info.getName());
                    map.put("value", info.getId());
                    retList.add(map);
                }
            }
            model.addAttribute("openid", openid);
            model.addAttribute("list", JSONArray.fromObject(retList));
            return "wechat/housing";
        }

    }

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

    @RequestMapping("/bindingRoom")
    public String bindingRoom(Weixinuser weixinuser, Model model) {
        weixinuserService.save(weixinuser);
        List<BillaccountCustom> list = billaccountService.queryBillByRoomId(weixinuser.getRoominfoid());
        model.addAttribute("list", list);
        return "wechat/billaccount";
    }
}
