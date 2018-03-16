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
    @Column(name = "appId")
    private String appid;

    /**
     * 微信appSecret
     */
    @Column(name = "appSecret")
    private String appsecret;

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
    public String getAppid() {
        return appid;
    }

    /**
     * 设置公众号appId
     *
     * @param appid 公众号appId
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * 获取微信appSecret
     *
     * @return appSecret - 微信appSecret
     */
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * 设置微信appSecret
     *
     * @param appsecret 微信appSecret
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }
}