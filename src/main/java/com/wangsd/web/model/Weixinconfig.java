package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "weixinconfig")
public class Weixinconfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公众号appId
     */
    private String appId;

    /**
     * 微信appSecret
     */
    private String appSecret;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公众号appId
     *
     * @return appId - 公众号appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置公众号appId
     *
     * @param appId 公众号appId
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取微信appSecret
     *
     * @return appSecret - 微信appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置微信appSecret
     *
     * @param appSecret 微信appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }
}