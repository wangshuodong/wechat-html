package com.wangsd.web.utils;

import com.wangsd.common.utils.HttpClientUtil;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import net.sf.json.JSONObject;
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
    public WeixinOauth2Token getAccessToken() throws IOException {
        WeixinOauth2Token wat = null;
        // 获取网页授权凭证
        Map<String, String> map = new HashMap();
        map.put("app_id", StaticVar.haina_app_id);
        map.put("app_secret", StaticVar.haina_app_secret);
        String str = HttpClientUtil.doPost(StaticVar.haina_get_access_token, JSONObject.fromObject(map));
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(str);
        wat = (WeixinOauth2Token) net.sf.json.JSONObject.toBean(obj, WeixinOauth2Token.class);
        return wat;
    }
}
