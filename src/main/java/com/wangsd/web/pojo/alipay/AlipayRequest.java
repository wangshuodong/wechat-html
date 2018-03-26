package com.wangsd.web.pojo.alipay;

import com.wangsd.common.utils.StaticVar;

/**
 * 封装支付宝公共请求参数
 */
public class AlipayRequest {

    public AlipayRequest(){
        this.serverUrl = StaticVar.alipay_serverUrl;
    }

    /**
     * 请求地址
     */
    private String serverUrl;
    /**
     * 支付宝分配给开发者的应用ID
     */
    private String appId;
    /**
     * 用户私钥
     */
    private String privateKey;
    /**
     * 仅支持JSON
     */
    private String format;
    /**
     * 请求使用的编码格式，如utf-8,gbk,gb2312等
     */
    private String charset;
    /**
     * 支付宝公钥
     */
    private String alipayPulicKey;
    /**
     * 商户生成签名字符串所使用的签名算法类型
     */
    private String signType;
    /**
     * 应用授权令牌
     */
    private String app_auth_token;
    /**
     * 请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递
     */
    private String biz_content;

    public String getBiz_content() {
        return biz_content;
    }

    public void setBiz_content(String biz_content) {
        this.biz_content = biz_content;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getAlipayPulicKey() {
        return alipayPulicKey;
    }

    public void setAlipayPulicKey(String alipayPulicKey) {
        this.alipayPulicKey = alipayPulicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getApp_auth_token() {
        return app_auth_token;
    }

    public void setApp_auth_token(String app_auth_token) {
        this.app_auth_token = app_auth_token;
    }
}
