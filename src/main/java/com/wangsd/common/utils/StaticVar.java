package com.wangsd.common.utils;

public class StaticVar {
    /**
     * 易联云颁发给开发者的应用ID 非空值
     */
    public static final String yly_CLIENT_ID = "1098732779";

    /**
     * 易联云颁发给开发者的应用secret 非空值
     */
    public static final String yly_CLIENT_SECRET = "689f949d6396a7445024a096e85de317";

    /**
     * token
     */
    public static final String yly_token = "0ddaa50957df430bbc193dcf7f84bd5f";
    /**
     * 支付宝请求地址
     */
    public static final String alipay_serverUrl = "https://openapi.alipay.com/gateway.do";

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

    /**
     * 海纳套件的appid
     */
    public final static String haina_app_id = "hnqk1XmsEv6eb4axr4";

    /**
     * 海纳套件的app_secret
     */
    public final static String haina_app_secret = "J6E4d7p2brPGLua3m7BLG5VRYleZ35jP";

    /**
     * 海纳套件内应用ID
     */
    public final static String haina_agent_id = "agLjxxmhNVADW5gGj2";

    /**
     * 获取access_token
     */
    public final static String haina_get_access_token = "https://api.haina.com/access/getToken";

    /**
     * 根据resident_code换取注册业主信息
     */
    public final static String haina_getResident = "https://api.haina.com/access/getResident?access_token={access_token}&agent_id={agent_id}";

    /**
     * 根据open_code换取未注册业主信息
     */
    public final static String haina_getOpenCode = "https://api.haina.com/access/getOpenCode?access_token={access_token}&agent_id={agent_id}";

    /**
     * 获取楼栋结构列表,一个小区下可能有多种楼栋结构，每一种楼栋结构对应一个确定的层级关系。
     */
    public final static String haina_getCommunit = "https://api.haina.com/resources/getCommunityList?access_token={access_token}&agent_id={agent_id}";


    /**
     * 将业主及业主楼栋信息基于业主手机号唯一的前提下写入/覆盖海纳的业主信息数据，暂不提供删除权限。
     */
    public final static String haina_import_info = "https://api.haina.com/import/resident_info?access_token={access_token}&agent_id={agent_id}";

    /**
     * 将业主及业主楼栋信息基于业主手机号唯一的前提下写入/覆盖海纳的业主信息数据，暂不提供删除权限。
     */
    public final static String haina_smsSend = "https://api.haina.com/ability/smsSend?access_token={access_token}&agent_id={agent_id}";

    /**
     * PC端临时票据获取用户基本信息
     */
    public final static String haina_getUser = "https://api.haina.com/access/getUser?access_token={access_token}&agent_id={agent_id}";


}
