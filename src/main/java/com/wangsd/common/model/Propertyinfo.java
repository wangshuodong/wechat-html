package com.wangsd.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "propertyinfo")
public class Propertyinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    @Column(name = "contact_people")
    private String contactPeople;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_address")
    private String contactAddress;

    /**
     * 税号
     */
    @Column(name = "salerTaxNum")
    private String salertaxnum;

    /**
     * 上级物业id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 商户账号
     */
    @Column(name = "alipay_login_id")
    private String alipayLoginId;

    /**
     * 商户PID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 授权TOKEN
     */
    private String token;

    /**
     * 支付宝代扣协议编号
     */
    @Column(name = "alipay_debit_num")
    private String alipayDebitNum;

    /**
     * 微信代扣协议编号
     */
    @Column(name = "weixin_debit_num")
    private String weixinDebitNum;

    /**
     * 微信子商户
     */
    @Column(name = "weixin_children_num")
    private String weixinChildrenNum;

    /**
     * API
     */
    private String api;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户申请的appkey
     */
    @Column(name = "nuonuo_appkey")
    private String nuonuoAppkey;

    /**
     * 用户Oauth登录后得到的令牌access token
     */
    @Column(name = "nuonuo_accessToken")
    private String nuonuoAccesstoken;

    /**
     * APP Secre
     */
    @Column(name = "nuonuo_secret")
    private String nuonuoSecret;

    /**
     * 销方银行账号和开户行地址
     */
    @Column(name = "salerAccount")
    private String saleraccount;

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
    public String getContactPeople() {
        return contactPeople;
    }

    /**
     * @param contactPeople
     */
    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople == null ? null : contactPeople.trim();
    }

    /**
     * @return contact_phone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * @return contact_address
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * @param contactAddress
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    /**
     * 获取税号
     *
     * @return salerTaxNum - 税号
     */
    public String getSalertaxnum() {
        return salertaxnum;
    }

    /**
     * 设置税号
     *
     * @param salertaxnum 税号
     */
    public void setSalertaxnum(String salertaxnum) {
        this.salertaxnum = salertaxnum == null ? null : salertaxnum.trim();
    }

    /**
     * 获取上级物业id
     *
     * @return parent_id - 上级物业id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级物业id
     *
     * @param parentId 上级物业id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取商户账号
     *
     * @return alipay_login_id - 商户账号
     */
    public String getAlipayLoginId() {
        return alipayLoginId;
    }

    /**
     * 设置商户账号
     *
     * @param alipayLoginId 商户账号
     */
    public void setAlipayLoginId(String alipayLoginId) {
        this.alipayLoginId = alipayLoginId == null ? null : alipayLoginId.trim();
    }

    /**
     * 获取商户PID
     *
     * @return app_id - 商户PID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置商户PID
     *
     * @param appId 商户PID
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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
    public String getAlipayDebitNum() {
        return alipayDebitNum;
    }

    /**
     * 设置支付宝代扣协议编号
     *
     * @param alipayDebitNum 支付宝代扣协议编号
     */
    public void setAlipayDebitNum(String alipayDebitNum) {
        this.alipayDebitNum = alipayDebitNum == null ? null : alipayDebitNum.trim();
    }

    /**
     * 获取微信代扣协议编号
     *
     * @return weixin_debit_num - 微信代扣协议编号
     */
    public String getWeixinDebitNum() {
        return weixinDebitNum;
    }

    /**
     * 设置微信代扣协议编号
     *
     * @param weixinDebitNum 微信代扣协议编号
     */
    public void setWeixinDebitNum(String weixinDebitNum) {
        this.weixinDebitNum = weixinDebitNum == null ? null : weixinDebitNum.trim();
    }

    /**
     * 获取微信子商户
     *
     * @return weixin_children_num - 微信子商户
     */
    public String getWeixinChildrenNum() {
        return weixinChildrenNum;
    }

    /**
     * 设置微信子商户
     *
     * @param weixinChildrenNum 微信子商户
     */
    public void setWeixinChildrenNum(String weixinChildrenNum) {
        this.weixinChildrenNum = weixinChildrenNum == null ? null : weixinChildrenNum.trim();
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户申请的appkey
     *
     * @return nuonuo_appkey - 用户申请的appkey
     */
    public String getNuonuoAppkey() {
        return nuonuoAppkey;
    }

    /**
     * 设置用户申请的appkey
     *
     * @param nuonuoAppkey 用户申请的appkey
     */
    public void setNuonuoAppkey(String nuonuoAppkey) {
        this.nuonuoAppkey = nuonuoAppkey == null ? null : nuonuoAppkey.trim();
    }

    /**
     * 获取用户Oauth登录后得到的令牌access token
     *
     * @return nuonuo_accessToken - 用户Oauth登录后得到的令牌access token
     */
    public String getNuonuoAccesstoken() {
        return nuonuoAccesstoken;
    }

    /**
     * 设置用户Oauth登录后得到的令牌access token
     *
     * @param nuonuoAccesstoken 用户Oauth登录后得到的令牌access token
     */
    public void setNuonuoAccesstoken(String nuonuoAccesstoken) {
        this.nuonuoAccesstoken = nuonuoAccesstoken == null ? null : nuonuoAccesstoken.trim();
    }

    /**
     * 获取APP Secre
     *
     * @return nuonuo_secret - APP Secre
     */
    public String getNuonuoSecret() {
        return nuonuoSecret;
    }

    /**
     * 设置APP Secre
     *
     * @param nuonuoSecret APP Secre
     */
    public void setNuonuoSecret(String nuonuoSecret) {
        this.nuonuoSecret = nuonuoSecret == null ? null : nuonuoSecret.trim();
    }

    /**
     * 获取销方银行账号和开户行地址
     *
     * @return salerAccount - 销方银行账号和开户行地址
     */
    public String getSaleraccount() {
        return saleraccount;
    }

    /**
     * 设置销方银行账号和开户行地址
     *
     * @param saleraccount 销方银行账号和开户行地址
     */
    public void setSaleraccount(String saleraccount) {
        this.saleraccount = saleraccount == null ? null : saleraccount.trim();
    }
}