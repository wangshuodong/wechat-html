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

    /**
     * 获取access_token
     * @return
     */
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

    /**
     * 根据open_code获取用户信息
     * @param open_code
     * @return
     */
    public String getUserInfoByOpen_code(String open_code) {
        String requestUrl = StaticVar.haina_getOpenCode;
        requestUrl = requestUrl.replace("{access_token}", getAccessToken());
        requestUrl = requestUrl.replace("{agent_id}", StaticVar.haina_agent_id);
        Map<String, String> map = new HashMap();
        map.put("open_code", open_code);
        String str = null;
        try {
            str = HttpClientUtil.doPost(requestUrl, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 根据resident_code获取用户信息
     * @param resident_code
     * @return
     */
    public String getUserInfoByResident_code(String resident_code) {
        String requestUrl = StaticVar.haina_getResident;
        requestUrl = requestUrl.replace("{access_token}", getAccessToken());
        requestUrl = requestUrl.replace("{agent_id}", StaticVar.haina_agent_id);
        Map<String, String> map = new HashMap();
        map.put("resident_code", resident_code);
        String str = null;
        try {
            str = HttpClientUtil.doPost(requestUrl, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getCommunit(String property_id) {
        String requestUrl = StaticVar.haina_getCommunit;
        requestUrl = requestUrl.replace("{access_token}", getAccessToken());
        requestUrl = requestUrl.replace("{agent_id}", StaticVar.haina_agent_id);
        Map<String, String> map = new HashMap();
        map.put("property_id", property_id);
        String str = null;
        try {
            str = HttpClientUtil.doPost(requestUrl, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        HainaUtil hainaUtil = new HainaUtil();
//        System.out.println(hainaUtil.getAccessToken());
//        System.out.println(hainaUtil.getUserInfoByOpen_code("gZz6zvAok"));
        System.out.println(hainaUtil.getUserInfoByResident_code("k8EDqBZ8r"));
//        System.out.println(hainaUtil.getCommunit("ff7ca3e8f7f0f8c3be664aa01e4cd99f"));

        String requestUrl = StaticVar.haina_import_info;
        requestUrl = requestUrl.replace("{access_token}", "bXNkc2hYYzB2aWF1VWVsK3VRbHFGek55YXBERUFSaVdNTEZtZitFSzN4dUZiNHZuQXM2Y3BCUlFWT1BNL2xucwd1c5f8df06ce353fe110437dd0e39bdfcceb25836c0fdada0884eea052e5c31e");
        requestUrl = requestUrl.replace("{agent_id}", StaticVar.haina_agent_id);

        String str = "{" +
                "     \"property_id\":\"ff7ca3e8f7f0f8c3be664aa01e4cd99f\" ," +
                "     \"name\":\"王杏仁\"," +
                "     \"sex\":\"1\"," +
                "     \"mobile\":\"17784495260\"," +
                "     \"open_id\":\"oEa9Lwa4kghRxeDHTSGlxYlz1XcI\"," +
                "     \"houses\":" +
                "      {" +
                "        \"community_id\":\"303f196bdb10f4d759c34474cc8cb50e\"," +
                "        \"address\":\"1栋/1单元/1102\"," +
                "        \"user_type\":\"0\"," +
                "        \"is_default\":1" +
                "      }" +
                "  }";

//        System.out.println(HttpClientUtil.doPostJson(requestUrl, str));
    }
}
