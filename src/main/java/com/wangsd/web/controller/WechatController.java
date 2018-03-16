package com.wangsd.web.controller;

import com.wangsd.common.utils.WeixinUtil;
import com.wangsd.web.model.*;
import com.wangsd.web.pojo.WeixinOauth2Token;
import com.wangsd.web.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.List;

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
        Weixinconfig query = new Weixinconfig();
        query.setAppid(appId);
        Weixinconfig weixinconfig = weixinconfigService.selectOne(query);
        // 获取网页授权access_token
        WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(weixinconfig.getAppid(), weixinconfig.getAppsecret(), code);
        // 网页授权接口访问凭证
        String access_token = weixinOauth2Token.getAccess_token();
        // 用户标识
        String openid = weixinOauth2Token.getOpenid();
        log.info("openid=" + openid);
        // 获取用户信息
        //WechatUserInfo snsUserInfo = WeixinUtil.getWechatUserInfo(access_token, openid);

        Weixinuser query3 = new Weixinuser();
        query3.setOpenid(appId);
        Weixinuser weixinuser = weixinuserService.selectOne(query3);
        if (weixinuser != null) {
            //直接跳转到账单界面
            Example example = new Example(Propertyinfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("roominfoId", weixinuser.getRoominfoid());
            List<Billaccount> list = billaccountService.selectByExample(example);
            model.addAttribute("list", list);
            return "wechat/housing";
        } else {
            List<Housinginfo> list;
            if ("wxcfab4f09fe94c406".equals(appId)) {
                //查询所有小区
                list = housinginfoService.selectAll();
                model.addAttribute("list", list);
            }else {
                //查询对应物业下的所有小区
                Propertyinfo query2 = new Propertyinfo();
                query2.setWeixinDebitNum(appId);
                Propertyinfo propertyinfo = propertyinfoService.selectOne(query2);
                Example example = new Example(Propertyinfo.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("parentId", propertyinfo.getId());
                list = housinginfoService.selectByExample(example);
            }
            model.addAttribute("list", list);
            return "wechat/housing";
        }

    }
}
