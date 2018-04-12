package com.wangsd.web.controller;

import com.wangsd.common.base.MyController;
import com.wangsd.common.utils.Charsets;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.common.utils.URLUtils;
import com.wangsd.web.utils.HainaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Controller
@RequestMapping("/haina")
public class HainaController extends MyController {

    @Autowired
    HainaUtil hainaUtil;

    @RequestMapping("/test")
    @ResponseBody
    public void test1() {
        String open_code = request.getParameter("open_code");
    }

    @RequestMapping("/index")
    public String index() {
        String callback_url = URLUtils.encodeURL("http://www.zaozaojiaoyu.com/haina/index", Charsets.UTF_8);
        String resident_code = request.getParameter("resident_code");
        String open_id = request.getParameter("open_id");
        String open_code = request.getParameter("open_code");
        String register_url = request.getParameter("register_url");
        logger.debug("resident_code=" + resident_code);
        logger.debug("open_id=" + open_id);
        logger.debug("open_code=" + open_code);
        logger.debug("register_url=" + register_url);
        //已在腾讯海纳注册的用户
        if (resident_code != null) {
            String str = hainaUtil.getUserInfoByResident_code(resident_code);
            logger.debug(str);
        } else { //如果没有注册 open_code 肯定有值
            try {
                response.sendRedirect(register_url + "?callback_url=" + callback_url + "&agent_id=" + StaticVar.haina_agent_id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "haina/index";
    }

    @RequestMapping("/index2")
    public String index2() {
        logger.debug("----------------index2-----------------");
        return "haina/index2";
    }
}
