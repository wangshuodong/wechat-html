package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "billaccount")
public class Billaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应小区id
     */
    @Column(name = "housing_id")
    private Integer housingId;

    /**
     * 对应房间id
     */
    @Column(name = "roominfo_id")
    private Integer roominfoId;

    /**
     * 费用类型名称
     */
    @Column(name = "cost_type")
    private Integer costType;

    /**
     * 应收金额
     */
    @Column(name = "bill_entry_amount")
    private Double billEntryAmount;

    /**
     * 账期，用于归类和向用户展示
     */
    @Column(name = "acct_period")
    private String acctPeriod;

    /**
     * 出账日期20160831
     */
    @Column(name = "release_day")
    private String releaseDay;

    /**
     * 缴费截止日期20160831
     */
    private String deadline;

    /**
     * 缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     */
    @Column(name = "relate_id")
    private String relateId;

    /**
     * 0:未同步 1：已同步
     */
    private Boolean status;

    /**
     * 付款时间
     */
    @Column(name = "payDate")
    private Date paydate;

    /**
     * 微信 支付宝 现金 刷卡 银行转账
     */
    @Column(name = "payType")
    private Integer paytype;

    /**
     * 付款状态 0：未付款  1：已付款
     */
    @Column(name = "payStatus")
    private Boolean paystatus;

    @Column(name = "deleteStatus")
    private Boolean deletestatus;

    /**
     * 支付宝付款成功回传编号
     */
    @Column(name = "alipay_trade_no")
    private String alipayTradeNo;

    /**
     * 微信付款成功回传编号
     */
    @Column(name = "weixin_trade_no")
    private String weixinTradeNo;

    /**
     * 打印状态
     */
    @Column(name = "printStatus")
    private Boolean printstatus;

    /**
     * 开票状态0未开票，1已开票，2退票
     */
    @Column(name = "ticketStatus")
    private Integer ticketstatus;

    /**
     * 发票流水号
     */
    @Column(name = "invoiceSerialNum")
    private String invoiceserialnum;

    /**
     * 发票代码
     */
    @Column(name = "invoiceCode")
    private String invoicecode;

    /**
     * 发票号码
     */
    @Column(name = "invoiceNum")
    private String invoicenum;

    /**
     * 付款人支付宝id
     */
    @Column(name = "buyer_user_id")
    private String buyerUserId;

    private String remark;

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
     * 获取对应小区id
     *
     * @return housing_id - 对应小区id
     */
    public Integer getHousingId() {
        return housingId;
    }

    /**
     * 设置对应小区id
     *
     * @param housingId 对应小区id
     */
    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    /**
     * 获取对应房间id
     *
     * @return roominfo_id - 对应房间id
     */
    public Integer getRoominfoId() {
        return roominfoId;
    }

    /**
     * 设置对应房间id
     *
     * @param roominfoId 对应房间id
     */
    public void setRoominfoId(Integer roominfoId) {
        this.roominfoId = roominfoId;
    }

    /**
     * 获取费用类型名称
     *
     * @return cost_type - 费用类型名称
     */
    public Integer getCostType() {
        return costType;
    }

    /**
     * 设置费用类型名称
     *
     * @param costType 费用类型名称
     */
    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    /**
     * 获取应收金额
     *
     * @return bill_entry_amount - 应收金额
     */
    public Double getBillEntryAmount() {
        return billEntryAmount;
    }

    /**
     * 设置应收金额
     *
     * @param billEntryAmount 应收金额
     */
    public void setBillEntryAmount(Double billEntryAmount) {
        this.billEntryAmount = billEntryAmount;
    }

    /**
     * 获取账期，用于归类和向用户展示
     *
     * @return acct_period - 账期，用于归类和向用户展示
     */
    public String getAcctPeriod() {
        return acctPeriod;
    }

    /**
     * 设置账期，用于归类和向用户展示
     *
     * @param acctPeriod 账期，用于归类和向用户展示
     */
    public void setAcctPeriod(String acctPeriod) {
        this.acctPeriod = acctPeriod == null ? null : acctPeriod.trim();
    }

    /**
     * 获取出账日期20160831
     *
     * @return release_day - 出账日期20160831
     */
    public String getReleaseDay() {
        return releaseDay;
    }

    /**
     * 设置出账日期20160831
     *
     * @param releaseDay 出账日期20160831
     */
    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay == null ? null : releaseDay.trim();
    }

    /**
     * 获取缴费截止日期20160831
     *
     * @return deadline - 缴费截止日期20160831
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * 设置缴费截止日期20160831
     *
     * @param deadline 缴费截止日期20160831
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    /**
     * 获取缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     *
     * @return relate_id - 缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     */
    public String getRelateId() {
        return relateId;
    }

    /**
     * 设置缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     *
     * @param relateId 缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     */
    public void setRelateId(String relateId) {
        this.relateId = relateId == null ? null : relateId.trim();
    }

    /**
     * 获取0:未同步 1：已同步
     *
     * @return status - 0:未同步 1：已同步
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置0:未同步 1：已同步
     *
     * @param status 0:未同步 1：已同步
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取付款时间
     *
     * @return payDate - 付款时间
     */
    public Date getPaydate() {
        return paydate;
    }

    /**
     * 设置付款时间
     *
     * @param paydate 付款时间
     */
    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    /**
     * 获取微信 支付宝 现金 刷卡 银行转账
     *
     * @return payType - 微信 支付宝 现金 刷卡 银行转账
     */
    public Integer getPaytype() {
        return paytype;
    }

    /**
     * 设置微信 支付宝 现金 刷卡 银行转账
     *
     * @param paytype 微信 支付宝 现金 刷卡 银行转账
     */
    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    /**
     * 获取付款状态 0：未付款  1：已付款
     *
     * @return payStatus - 付款状态 0：未付款  1：已付款
     */
    public Boolean getPaystatus() {
        return paystatus;
    }

    /**
     * 设置付款状态 0：未付款  1：已付款
     *
     * @param paystatus 付款状态 0：未付款  1：已付款
     */
    public void setPaystatus(Boolean paystatus) {
        this.paystatus = paystatus;
    }

    /**
     * @return deleteStatus
     */
    public Boolean getDeletestatus() {
        return deletestatus;
    }

    /**
     * @param deletestatus
     */
    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    /**
     * 获取支付宝付款成功回传编号
     *
     * @return alipay_trade_no - 支付宝付款成功回传编号
     */
    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    /**
     * 设置支付宝付款成功回传编号
     *
     * @param alipayTradeNo 支付宝付款成功回传编号
     */
    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo == null ? null : alipayTradeNo.trim();
    }

    /**
     * 获取微信付款成功回传编号
     *
     * @return weixin_trade_no - 微信付款成功回传编号
     */
    public String getWeixinTradeNo() {
        return weixinTradeNo;
    }

    /**
     * 设置微信付款成功回传编号
     *
     * @param weixinTradeNo 微信付款成功回传编号
     */
    public void setWeixinTradeNo(String weixinTradeNo) {
        this.weixinTradeNo = weixinTradeNo == null ? null : weixinTradeNo.trim();
    }

    /**
     * 获取打印状态
     *
     * @return printStatus - 打印状态
     */
    public Boolean getPrintstatus() {
        return printstatus;
    }

    /**
     * 设置打印状态
     *
     * @param printstatus 打印状态
     */
    public void setPrintstatus(Boolean printstatus) {
        this.printstatus = printstatus;
    }

    /**
     * 获取开票状态0未开票，1已开票，2退票
     *
     * @return ticketStatus - 开票状态0未开票，1已开票，2退票
     */
    public Integer getTicketstatus() {
        return ticketstatus;
    }

    /**
     * 设置开票状态0未开票，1已开票，2退票
     *
     * @param ticketstatus 开票状态0未开票，1已开票，2退票
     */
    public void setTicketstatus(Integer ticketstatus) {
        this.ticketstatus = ticketstatus;
    }

    /**
     * 获取发票流水号
     *
     * @return invoiceSerialNum - 发票流水号
     */
    public String getInvoiceserialnum() {
        return invoiceserialnum;
    }

    /**
     * 设置发票流水号
     *
     * @param invoiceserialnum 发票流水号
     */
    public void setInvoiceserialnum(String invoiceserialnum) {
        this.invoiceserialnum = invoiceserialnum == null ? null : invoiceserialnum.trim();
    }

    /**
     * 获取发票代码
     *
     * @return invoiceCode - 发票代码
     */
    public String getInvoicecode() {
        return invoicecode;
    }

    /**
     * 设置发票代码
     *
     * @param invoicecode 发票代码
     */
    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode == null ? null : invoicecode.trim();
    }

    /**
     * 获取发票号码
     *
     * @return invoiceNum - 发票号码
     */
    public String getInvoicenum() {
        return invoicenum;
    }

    /**
     * 设置发票号码
     *
     * @param invoicenum 发票号码
     */
    public void setInvoicenum(String invoicenum) {
        this.invoicenum = invoicenum == null ? null : invoicenum.trim();
    }

    /**
     * 获取付款人支付宝id
     *
     * @return buyer_user_id - 付款人支付宝id
     */
    public String getBuyerUserId() {
        return buyerUserId;
    }

    /**
     * 设置付款人支付宝id
     *
     * @param buyerUserId 付款人支付宝id
     */
    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId == null ? null : buyerUserId.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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