package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "neworder")
public class Neworder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 账单id
     */
    private Integer billId;

    /**
     * 状态，0新建，1已支付
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

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
     * 获取订单id
     *
     * @return orderId - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取账单id
     *
     * @return billId - 账单id
     */
    public Integer getBillId() {
        return billId;
    }

    /**
     * 设置账单id
     *
     * @param billId 账单id
     */
    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    /**
     * 获取状态，0新建，1已支付
     *
     * @return status - 状态，0新建，1已支付
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0新建，1已支付
     *
     * @param status 状态，0新建，1已支付
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取支付时间
     *
     * @return payTime - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}