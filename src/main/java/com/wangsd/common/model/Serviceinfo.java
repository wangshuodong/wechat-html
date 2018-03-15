package com.wangsd.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "serviceinfo")
public class Serviceinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    /**
     * 区域
     */
    private String region;

    /**
     * 联系人
     */
    @Column(name = "contact_people")
    private String contactPeople;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 联系地址
     */
    @Column(name = "contact_address")
    private String contactAddress;

    /**
     * 上级服务商id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 应用ID,您的APPID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 商户私钥
     */
    @Column(name = "merchant_private_key")
    private String merchantPrivateKey;

    /**
     * 支付宝公钥
     */
    @Column(name = "alipay_public_key")
    private String alipayPublicKey;

    @Column(name = "return_url")
    private String returnUrl;

    @Column(name = "create_time")
    private Date createTime;

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
     * 获取区域
     *
     * @return region - 区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置区域
     *
     * @param region 区域
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 获取联系人
     *
     * @return contact_people - 联系人
     */
    public String getContactPeople() {
        return contactPeople;
    }

    /**
     * 设置联系人
     *
     * @param contactPeople 联系人
     */
    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople == null ? null : contactPeople.trim();
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取联系地址
     *
     * @return contact_address - 联系地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置联系地址
     *
     * @param contactAddress 联系地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    /**
     * 获取上级服务商id
     *
     * @return parent_id - 上级服务商id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级服务商id
     *
     * @param parentId 上级服务商id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取应用ID,您的APPID
     *
     * @return app_id - 应用ID,您的APPID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID,您的APPID
     *
     * @param appId 应用ID,您的APPID
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取商户私钥
     *
     * @return merchant_private_key - 商户私钥
     */
    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    /**
     * 设置商户私钥
     *
     * @param merchantPrivateKey 商户私钥
     */
    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey == null ? null : merchantPrivateKey.trim();
    }

    /**
     * 获取支付宝公钥
     *
     * @return alipay_public_key - 支付宝公钥
     */
    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    /**
     * 设置支付宝公钥
     *
     * @param alipayPublicKey 支付宝公钥
     */
    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey == null ? null : alipayPublicKey.trim();
    }

    /**
     * @return return_url
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * @param returnUrl
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
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
}