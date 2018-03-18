package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer billaccount_id;

    /**
     * 发票抬头
     */
    private String title_name;

    /**
     * 发票类型0单位，1个人
     */
    private Integer type;

    /**
     * 税号
     */
    private String register_no;

    private Double amount;

    /**
     * 联系电话
     */
    private String phone;

    private String email;

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
     * @return billaccount_id
     */
    public Integer getBillaccount_id() {
        return billaccount_id;
    }

    /**
     * @param billaccount_id
     */
    public void setBillaccount_id(Integer billaccount_id) {
        this.billaccount_id = billaccount_id;
    }

    /**
     * 获取发票抬头
     *
     * @return title_name - 发票抬头
     */
    public String getTitle_name() {
        return title_name;
    }

    /**
     * 设置发票抬头
     *
     * @param title_name 发票抬头
     */
    public void setTitle_name(String title_name) {
        this.title_name = title_name == null ? null : title_name.trim();
    }

    /**
     * 获取发票类型0单位，1个人
     *
     * @return type - 发票类型0单位，1个人
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置发票类型0单位，1个人
     *
     * @param type 发票类型0单位，1个人
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取税号
     *
     * @return register_no - 税号
     */
    public String getRegister_no() {
        return register_no;
    }

    /**
     * 设置税号
     *
     * @param register_no 税号
     */
    public void setRegister_no(String register_no) {
        this.register_no = register_no == null ? null : register_no.trim();
    }

    /**
     * @return amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}