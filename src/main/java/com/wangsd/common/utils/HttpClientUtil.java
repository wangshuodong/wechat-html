package com.wangsd.common.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    /**
     * 发送get请求
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static final String doGet(String url) throws IOException, URISyntaxException {
        return doGet(url, null);
    }

    /**
     * 发送get请求
     *
     * @param url
     * @param param
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static final String doGet(String url, Map<String, String> param) throws IOException, URISyntaxException {
        return doGet(url, null, null);
    }

    /**
     * 发送get请求
     *
     * @param url
     * @param param
     * @param headers
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static final String doGet(String url, Map<String, String> param, Map<String, Object> headers) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = null;
        CloseableHttpResponse response = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (param != null) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            setHeaders(httpGet, headers);
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultString;
    }

    /**
     * 发送POST请求
     *
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static final String doPostJson(String url, String json) throws IOException {
        return doPostJson(url, json, null);
    }


    /**
     * 发送POST请求
     *
     * @param url
     * @param json
     * @param headers
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static final String doPostJson(String url, String json, Map<String, Object> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-Type", "application/json");
            setHeaders(httpPost, headers);
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultString;
    }

    /**
     * 以表单的方式提交post
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static final String doPost(String url) throws IOException {
        return doPost(url, null);
    }

    /**
     * 以表单的方式提交post
     *
     * @param url
     * @param param
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static final String doPost(String url, Map<String, String> param) throws IOException {
        return doPost(url, param, null);
    }


    /**
     * 以表单的方式提交Post请求
     *
     * @param url
     * @param param
     * @param headers
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static final String doPost(String url, Map<String, String> param, Map<String, Object> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (param != null) {
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "utf-8");
                httpPost.setEntity(urlEncodedFormEntity);
            }
            setHeaders(httpPost, headers);
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultString;
    }

    private static final void setHeaders(HttpUriRequest uriRequest, Map<String, Object> headers) {
        if (headers == null) {
            if (headers != null) {
                for (Map.Entry<String, Object> entry : headers.entrySet()) {
                    uriRequest.addHeader(entry.getKey(), entry.getValue().toString());
                }
            }
        }

    }
}
