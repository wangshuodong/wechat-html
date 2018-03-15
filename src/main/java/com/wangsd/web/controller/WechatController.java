package com.wangsd.web.controller;

import com.wangsd.common.utils.WeixinUtil;
import com.wangsd.web.pojo.WechatUserInfo;
import com.wangsd.web.pojo.WeixinOauth2Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    @RequestMapping("/index")
    public String index(String code, String state, Model model) throws IOException {
        // 获取网页授权access_token
        WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken("wxcfab4f09fe94c406", "adeb7e6a2142933188dc905e098af149", code);
        // 网页授权接口访问凭证
        String access_token = weixinOauth2Token.getAccess_token();
        // 用户标识
        String openid = weixinOauth2Token.getOpenid();

        log.info("openid=" + openid);
        // 获取用户信息
        //WechatUserInfo snsUserInfo = WeixinUtil.getWechatUserInfo(access_token, openid);
        return "wechat/index";
    }
}
