package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "propertyinfo")
public class Propertyinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String contact_people;

    private String contact_phone;

    private String contact_address;

    /**
     * 税号
     */
    private String salerTaxNum;

    /**
     * 上级物业id
     */
    private Integer parent_id;

    /**
     * 商户账号
     */
    private String alipay_login_id;

    /**
     * 商户PID
     */
    private String app_id;

    /**
     * 授权TOKEN
     */
    private String token;

    /**
     * 支付宝代扣协议编号
     */
    private String alipay_debit_num;

    /**
     * 微信代扣协议编号
     */
    private String weixin_debit_num;

    /**
     * 微信子商户
     */
    private String weixin_children_num;

    /**
     * API
     */
    private String api;

    private Date create_time;

    /**
     * 用户申请的appkey
     */
    private String nuonuo_appkey;

    /**
     * 用户Oauth登录后得到的令牌access token
     */
    private String nuonuo_accessToken;

    /**
     * APP Secre
     */
    private String nuonuo_secret;

    /**
     * 销方银行账号和开户行地址
     */
    private String salerAccount;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return contact_people
     */
    public String getContact_people() {
        return contact_people;
    }

    /**
     * @param contact_people
     */
    public void setContact_people(String contact_people) {
        this.contact_people = contact_people == null ? null : contact_people.trim();
    }

    /**
     * @return contact_phone
     */
    public String getContact_phone() {
        return contact_phone;
    }

    /**
     * @param contact_phone
     */
    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone == null ? null : contact_phone.trim();
    }

    /**
     * @return contact_address
     */
    public String getContact_address() {
        return contact_address;
    }

    /**
     * @param contact_address
     */
    public void setContact_address(String contact_address) {
        this.contact_address = contact_address == null ? null : contact_address.trim();
    }

    /**
     * 获取税号
     *
     * @return salerTaxNum - 税号
     */
    public String getSalerTaxNum() {
        return salerTaxNum;
    }

    /**
     * 设置税号
     *
     * @param salerTaxNum 税号
     */
    public void setSalerTaxNum(String salerTaxNum) {
        this.salerTaxNum = salerTaxNum == null ? null : salerTaxNum.trim();
    }

    /**
     * 获取上级物业id
     *
     * @return parent_id - 上级物业id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置上级物业id
     *
     * @param parent_id 上级物业id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取商户账号
     *
     * @return alipay_login_id - 商户账号
     */
    public String getAlipay_login_id() {
        return alipay_login_id;
    }

    /**
     * 设置商户账号
     *
     * @param alipay_login_id 商户账号
     */
    public void setAlipay_login_id(String alipay_login_id) {
        this.alipay_login_id = alipay_login_id == null ? null : alipay_login_id.trim();
    }

    /**
     * 获取商户PID
     *
     * @return app_id - 商户PID
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * 设置商户PID
     *
     * @param app_id 商户PID
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * 获取授权TOKEN
     *
     * @return token - 授权TOKEN
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置授权TOKEN
     *
     * @param token 授权TOKEN
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取支付宝代扣协议编号
     *
     * @return alipay_debit_num - 支付宝代扣协议编号
     */
    public String getAlipay_debit_num() {
        return alipay_debit_num;
    }

    /**
     * 设置支付宝代扣协议编号
     *
     * @param alipay_debit_num 支付宝代扣协议编号
     */
    public void setAlipay_debit_num(String alipay_debit_num) {
        this.alipay_debit_num = alipay_debit_num == null ? null : alipay_debit_num.trim();
    }

    /**
     * 获取微信代扣协议编号
     *
     * @return weixin_debit_num - 微信代扣协议编号
     */
    public String getWeixin_debit_num() {
        return weixin_debit_num;
    }

    /**
     * 设置微信代扣协议编号
     *
     * @param weixin_debit_num 微信代扣协议编号
     */
    public void setWeixin_debit_num(String weixin_debit_num) {
        this.weixin_debit_num = weixin_debit_num == null ? null : weixin_debit_num.trim();
    }

    /**
     * 获取微信子商户
     *
     * @return weixin_children_num - 微信子商户
     */
    public String getWeixin_children_num() {
        return weixin_children_num;
    }

    /**
     * 设置微信子商户
     *
     * @param weixin_children_num 微信子商户
     */
    public void setWeixin_children_num(String weixin_children_num) {
        this.weixin_children_num = weixin_children_num == null ? null : weixin_children_num.trim();
    }

    /**
     * 获取API
     *
     * @return api - API
     */
    public String getApi() {
        return api;
    }

    /**
     * 设置API
     *
     * @param api API
     */
    public void setApi(String api) {
        this.api = api == null ? null : api.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * @param create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取用户申请的appkey
     *
     * @return nuonuo_appkey - 用户申请的appkey
     */
    public String getNuonuo_appkey() {
        return nuonuo_appkey;
    }

    /**
     * 设置用户申请的appkey
     *
     * @param nuonuo_appkey 用户申请的appkey
     */
    public void setNuonuo_appkey(String nuonuo_appkey) {
        this.nuonuo_appkey = nuonuo_appkey == null ? null : nuonuo_appkey.trim();
    }

    /**
     * 获取用户Oauth登录后得到的令牌access token
     *
     * @return nuonuo_accessToken - 用户Oauth登录后得到的令牌access token
     */
    public String getNuonuo_accessToken() {
        return nuonuo_accessToken;
    }

    /**
     * 设置用户Oauth登录后得到的令牌access token
     *
     * @param nuonuo_accessToken 用户Oauth登录后得到的令牌access token
     */
    public void setNuonuo_accessToken(String nuonuo_accessToken) {
        this.nuonuo_accessToken = nuonuo_accessToken == null ? null : nuonuo_accessToken.trim();
    }

    /**
     * 获取APP Secre
     *
     * @return nuonuo_secret - APP Secre
     */
    public String getNuonuo_secret() {
        return nuonuo_secret;
    }

    /**
     * 设置APP Secre
     *
     * @param nuonuo_secret APP Secre
     */
    public void setNuonuo_secret(String nuonuo_secret) {
        this.nuonuo_secret = nuonuo_secret == null ? null : nuonuo_secret.trim();
    }

    /**
     * 获取销方银行账号和开户行地址
     *
     * @return salerAccount - 销方银行账号和开户行地址
     */
    public String getSalerAccount() {
        return salerAccount;
    }

    /**
     * 设置销方银行账号和开户行地址
     *
     * @param salerAccount 销方银行账号和开户行地址
     */
    public void setSalerAccount(String salerAccount) {
        this.salerAccount = salerAccount == null ? null : salerAccount.trim();
    }
}