package com.wangsd.web.pojo.wechat;

import java.util.Date;

/**
 * 网页授权信息
 * 
 * 
 * @author：WangYuanJun
 * @date：2018年1月24日 下午3:10:03
 */
public class WeixinOauth2Token {

    // 网页授权接口调用凭证
    private String access_token;

    // 凭证有效时长
    private int expires_in;

    // 用于刷新凭证
    private String refresh_token;

    // 用户标识
    private String openid;

    // 用户授权作用域
    private String scope;

    private Date create_time;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
