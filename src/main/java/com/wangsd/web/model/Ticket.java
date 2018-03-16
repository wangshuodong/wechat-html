package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "billaccount_id")
    private Integer billaccountId;

    /**
     * 发票抬头
     */
    @Column(name = "title_name")
    private String titleName;

    /**
     * 发票类型0单位，1个人
     */
    private Integer type;

    /**
     * 税号
     */
    @Column(name = "register_no")
    private String registerNo;

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
    public Integer getBillaccountId() {
        return billaccountId;
    }

    /**
     * @param billaccountId
     */
    public void setBillaccountId(Integer billaccountId) {
        this.billaccountId = billaccountId;
    }

    /**
     * 获取发票抬头
     *
     * @return title_name - 发票抬头
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置发票抬头
     *
     * @param titleName 发票抬头
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
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
    public String getRegisterNo() {
        return registerNo;
    }

    /**
     * 设置税号
     *
     * @param registerNo 税号
     */
    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo == null ? null : registerNo.trim();
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