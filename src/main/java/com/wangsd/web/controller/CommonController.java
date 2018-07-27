package com.wangsd.web.controller;

import com.wangsd.common.base.RestResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommonController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public RestResult login(String username, String password) {
        return null;
    }

    /**
     * 查询楼栋
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("queryBuilding")
    public RestResult queryBuilding(String username, String password) {
        return null;
    }
}
