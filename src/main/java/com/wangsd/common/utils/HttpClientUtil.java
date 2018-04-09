package com.wangsd.common.utils;

import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import net.sf.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {

    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * get请求传输数据
     * @param url
     * @return
     * @throws IOException
     */
    public static String doGet(String url) throws IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-type", "application/json");
        // 通过请求对象获取响应对象
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();
        log.info(result);
        return result;
    }

    /**
     * post请求传输map数据
     *
     * @param url
     * @param map
     * @return
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> map) throws IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        // 装填参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Entry<String, String> entry : map.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        // 设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();
        log.info(result);
        return result;
    }

    /**
     * post请求传输json数据
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String doPost(String url, String json) throws ClientProtocolException, IOException {
        String result = "";

        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        // 设置参数到请求对象中
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都数正常)
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        // 释放链接
        response.close();
        log.info(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
//        String requestUrl = StaticVar.wechat_access_token_url;
//        requestUrl = requestUrl.replace("APPID", "wxcfab4f09fe94c406");
//        requestUrl = requestUrl.replace("APPSECRET", "adeb7e6a2142933188dc905e098af149");
//        String str = doGet(requestUrl);
//        JSONObject obj = JSONObject.fromObject(str);
//        WeixinOauth2Token aa = (WeixinOauth2Token)JSONObject.toBean(obj, WeixinOauth2Token.class);
//        System.out.println(obj);

//        Map<String, String> map = new HashMap();
//        map.put("request_content", "12");
//        map.put("authen_info", "56");
//        doPost("http://www.zaozaojiaoyu.com/wechat/whchatPayReturn", JSONObject.fromObject(map));

        Map<String, String> map = new HashMap();
        map.put("app_id", "hn0rlYQhJ6qYKMgwkZ");
        map.put("app_secret", "D19RvzxWbrlA5I8klOmN2nXpa7AkMYE8");
        String str = doPost("https://api.haina.com/access/getToken", JSONObject.fromObject(map));
        System.out.println(str);
    }
}
