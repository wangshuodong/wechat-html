package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "directfee")
public class Directfee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 金额
     */
    private Double fee;

    /**
     * 费用类型
     */
    private Integer costtypeid;

    private String phone;

    /**
     * 项目类型
     */
    private String projectid;

    private String fee_unit;

    private Date create_time;

    /**
     * 支付方式
     */
    private Integer pay_type;

    /**
     * 关联users的parent_code
     */
    private String code;

    /**
     * 开票状态：0未开票，1已开票，2退票
     */
    private Integer ticketStatus;

    /**
     * 发票流水号
     */
    private String invoiceSerialNum;

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
     * 获取金额
     *
     * @return fee - 金额
     */
    public Double getFee() {
        return fee;
    }

    /**
     * 设置金额
     *
     * @param fee 金额
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * 获取费用类型
     *
     * @return costtypeid - 费用类型
     */
    public Integer getCosttypeid() {
        return costtypeid;
    }

    /**
     * 设置费用类型
     *
     * @param costtypeid 费用类型
     */
    public void setCosttypeid(Integer costtypeid) {
        this.costtypeid = costtypeid;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取项目类型
     *
     * @return projectid - 项目类型
     */
    public String getProjectid() {
        return projectid;
    }

    /**
     * 设置项目类型
     *
     * @param projectid 项目类型
     */
    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    /**
     * @return fee_unit
     */
    public String getFee_unit() {
        return fee_unit;
    }

    /**
     * @param fee_unit
     */
    public void setFee_unit(String fee_unit) {
        this.fee_unit = fee_unit == null ? null : fee_unit.trim();
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
     * 获取支付方式
     *
     * @return pay_type - 支付方式
     */
    public Integer getPay_type() {
        return pay_type;
    }

    /**
     * 设置支付方式
     *
     * @param pay_type 支付方式
     */
    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    /**
     * 获取关联users的parent_code
     *
     * @return code - 关联users的parent_code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置关联users的parent_code
     *
     * @param code 关联users的parent_code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取开票状态：0未开票，1已开票，2退票
     *
     * @return ticketStatus - 开票状态：0未开票，1已开票，2退票
     */
    public Integer getTicketStatus() {
        return ticketStatus;
    }

    /**
     * 设置开票状态：0未开票，1已开票，2退票
     *
     * @param ticketStatus 开票状态：0未开票，1已开票，2退票
     */
    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    /**
     * 获取发票流水号
     *
     * @return invoiceSerialNum - 发票流水号
     */
    public String getInvoiceSerialNum() {
        return invoiceSerialNum;
    }

    /**
     * 设置发票流水号
     *
     * @param invoiceSerialNum 发票流水号
     */
    public void setInvoiceSerialNum(String invoiceSerialNum) {
        this.invoiceSerialNum = invoiceSerialNum == null ? null : invoiceSerialNum.trim();
    }
}