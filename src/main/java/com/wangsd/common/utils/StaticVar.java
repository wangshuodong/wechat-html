package com.wangsd.common.utils;

public class StaticVar {

    /**
     * 获取公众号access_token
     */
    public final static String wechat_access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 通过code换取网页授权access_token
     */
    public final static String wechat_web_access_token = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 网页授权后获取微信用户信息
     */
    public final static String wechat_web_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";

    /**
     * 创建菜单
     */
    public final static String wechat_menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 公众号物业缴费菜单链接
     */
    public final static String wechat_wyjiaofei = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcfab4f09fe94c406&redirect_uri=http%3A%2F%2Fwww.yhwpay.com%2Fwechat%2Findex&response_type=code&scope=snsapi_userinfo&state=wxcfab4f09fe94c406#wechat_redirect";
}
