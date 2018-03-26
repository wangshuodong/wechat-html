package com.wangsd.web.utils;

import com.wangsd.common.utils.HttpClientUtil;
import com.wangsd.common.utils.StaticVar;
import com.wangsd.web.pojo.wechat.WechatUserInfo;
import com.wangsd.web.pojo.wechat.WeixinOauth2Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 网页授权凭证工具类
 * 
 * 
 * @author：WangYuanJun
 * @date：2018年1月24日 下午3:19:44
 */
public class WeixinUtil {

    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    /**
     * 获取网页授权凭证
     * 
     * @param appId
     *            公众账号的唯一标识
     * @param appSecret
     *            公众账号的密钥
     * @param code
     * @return WeixinAouth2Token
     */
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) throws IOException {
        WeixinOauth2Token wat = null;
        // 拼接请求地址
        String requestUrl = StaticVar.wechat_web_access_token;
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        // 获取网页授权凭证
        String str = HttpClientUtil.doGet(requestUrl);
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(str);
        wat = (WeixinOauth2Token) net.sf.json.JSONObject.toBean(obj, WeixinOauth2Token.class);
        return wat;
    }

    /**
     * 通过网页授权获取用户信息
     * 
     * @param accessToken
     *            网页授权接口调用凭证
     * @param openId
     *            用户标识
     * @return SNSUserInfo
     */
    @SuppressWarnings({ "deprecation", "unchecked" })
    public static WechatUserInfo getWechatUserInfo(String accessToken, String openId) throws IOException {
        WechatUserInfo wechatUserInfo = null;
        // 拼接请求地址
        String requestUrl = StaticVar.wechat_web_userinfo;
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        String str = HttpClientUtil.doGet(requestUrl);
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(str);
        wechatUserInfo = (WechatUserInfo) net.sf.json.JSONObject.toBean(obj, WechatUserInfo.class);

        return wechatUserInfo;
    }

}
