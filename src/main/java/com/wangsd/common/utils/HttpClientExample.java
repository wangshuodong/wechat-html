package com.wangsd.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientExample {

    private HttpClient client = HttpClientBuilder.create().build();

    public static void main(String[] args) throws Exception {

        String url = "https://api.haina.com/import/resident_info?access_token=bXNkc2hYYzB2aWF1VWVsK3VRbHFGek55YXBERUFSaVdNTEZtZitFSzN4c3E1QmtPTDRQR0ZkWWYyc1BxU2xrRQd1c5f8df06ce353fe110437dd0e39bdfcceb25836c0fdada0884eea052e5c31e&agent_id=agyBn9XCWMGv5KPEZY";
        HttpClientExample http = new HttpClientExample();
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("property_id", "ff7ca3e8f7f0f8c3be664aa01e4cd99f1"));
        urlParameters.add(new BasicNameValuePair("name", "杏仁"));
        urlParameters.add(new BasicNameValuePair("sex", "1"));
        urlParameters.add(new BasicNameValuePair("mobile", "13900000000"));
        urlParameters.add(new BasicNameValuePair("open_id", "oEa9Lwa4kghRxeDHTSGlxYlz1XcI"));
        String result = http.sendPost(url, urlParameters);
        System.out.println(result);

        System.out.println("Done");
    }

    private String sendPost(String url, List<NameValuePair> postParams)
            throws Exception {

        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        post.setEntity(new UrlEncodedFormEntity(postParams));
        HttpResponse response = client.execute(post);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        // System.out.println(result.toString());
        return result.toString();
    }

}
