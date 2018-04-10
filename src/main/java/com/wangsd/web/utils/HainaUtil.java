package com.wangsd.web.utils;

import com.wangsd.common.utils.HttpClientUtil;
import com.wangsd.common.utils.StaticVar;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class HainaUtil {

    private static Logger log = LoggerFactory.getLogger(HainaUtil.class);

    @Cacheable(value = "twoHour")
    public String getAccessToken(){
        // 获取网页授权凭证
        Map<String, String> map = new HashMap();
        map.put("app_id", StaticVar.haina_app_id);
        map.put("app_secret", StaticVar.haina_app_secret);
        String str = null;
        try {
            str = HttpClientUtil.doPost(StaticVar.haina_get_access_token, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = JSONObject.parseObject(str);
        return obj.getString("access_token");
    }

    public String getUserInfoByOpen_code(String open_code) {
        String requestUrl = StaticVar.haina_getResident;
        requestUrl = requestUrl.replace("{access_token}", getAccessToken());
        requestUrl = requestUrl.replace("{agent_id}", "");
        Map<String, String> map = new HashMap();
        map.put("open_code", open_code);
        String str = null;
        try {
            str = HttpClientUtil.doPost(StaticVar.haina_getResident, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getUserInfoByResident_code(String resident_code) {
        Map<String, String> map = new HashMap();
        map.put("resident_code", resident_code);
        String str = null;
        try {
            str = HttpClientUtil.doPost(StaticVar.haina_get_access_token, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
