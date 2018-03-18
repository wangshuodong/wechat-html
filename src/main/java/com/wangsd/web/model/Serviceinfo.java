package com.wangsd.web.model;

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
    private String contact_people;

    /**
     * 联系电话
     */
    private String contact_phone;

    /**
     * 联系地址
     */
    private String contact_address;

    /**
     * 上级服务商id
     */
    private Integer parent_id;

    /**
     * 应用ID,您的APPID
     */
    private String app_id;

    /**
     * 商户私钥
     */
    private String merchant_private_key;

    /**
     * 支付宝公钥
     */
    private String alipay_public_key;

    private String return_url;

    private Date create_time;

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
    public String getContact_people() {
        return contact_people;
    }

    /**
     * 设置联系人
     *
     * @param contact_people 联系人
     */
    public void setContact_people(String contact_people) {
        this.contact_people = contact_people == null ? null : contact_people.trim();
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContact_phone() {
        return contact_phone;
    }

    /**
     * 设置联系电话
     *
     * @param contact_phone 联系电话
     */
    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone == null ? null : contact_phone.trim();
    }

    /**
     * 获取联系地址
     *
     * @return contact_address - 联系地址
     */
    public String getContact_address() {
        return contact_address;
    }

    /**
     * 设置联系地址
     *
     * @param contact_address 联系地址
     */
    public void setContact_address(String contact_address) {
        this.contact_address = contact_address == null ? null : contact_address.trim();
    }

    /**
     * 获取上级服务商id
     *
     * @return parent_id - 上级服务商id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置上级服务商id
     *
     * @param parent_id 上级服务商id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取应用ID,您的APPID
     *
     * @return app_id - 应用ID,您的APPID
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * 设置应用ID,您的APPID
     *
     * @param app_id 应用ID,您的APPID
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * 获取商户私钥
     *
     * @return merchant_private_key - 商户私钥
     */
    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    /**
     * 设置商户私钥
     *
     * @param merchant_private_key 商户私钥
     */
    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key == null ? null : merchant_private_key.trim();
    }

    /**
     * 获取支付宝公钥
     *
     * @return alipay_public_key - 支付宝公钥
     */
    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    /**
     * 设置支付宝公钥
     *
     * @param alipay_public_key 支付宝公钥
     */
    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key == null ? null : alipay_public_key.trim();
    }

    /**
     * @return return_url
     */
    public String getReturn_url() {
        return return_url;
    }

    /**
     * @param return_url
     */
    public void setReturn_url(String return_url) {
        this.return_url = return_url == null ? null : return_url.trim();
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
}