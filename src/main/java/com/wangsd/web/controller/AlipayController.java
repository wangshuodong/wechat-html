package com.wangsd.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @RequestMapping("/test")
    @ResponseBody
    public String queryAlipayBill(String appid) {
        return "wangsd";
    }
}
