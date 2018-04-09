package com.wangsd.web.controller;

import com.wangsd.common.utils.DateUtils;
import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import com.wangsd.web.utils.HainaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/haina")
public class HainaController {

    private static Logger log = LoggerFactory.getLogger(HainaUtil.class);

    @Autowired
    HainaUtil hainaUtil;

    @RequestMapping("/test")
    @ResponseBody
    public void test1() {
        try {
            WeixinOauth2Token token = hainaUtil.getAccessToken();
            log.debug(token.getAccess_token());
            log.debug(DateUtils.formatDatetime(token.getCreate_time()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
