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
    private Integer housing_id;

    /**
     * 对应房间id
     */
    private Integer roominfo_id;

    /**
     * 费用类型名称
     */
    private Integer cost_type;

    /**
     * 应收金额
     */
    private Double bill_entry_amount;

    /**
     * 账期，用于归类和向用户展示
     */
    private String acct_period;

    /**
     * 出账日期20160831
     */
    private String release_day;

    /**
     * 缴费截止日期20160831
     */
    private String deadline;

    /**
     * 缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     */
    private String relate_id;

    /**
     * 0:未同步 1：已同步
     */
    private Boolean status;

    /**
     * 付款时间
     */
    private Date payDate;

    /**
     * 微信 支付宝 现金 刷卡 银行转账
     */
    private Integer payType;

    /**
     * 付款状态 0：未付款  1：已付款
     */
    private Boolean payStatus;

    private Boolean deleteStatus;

    /**
     * 支付宝付款成功回传编号
     */
    private String alipay_trade_no;

    /**
     * 微信付款成功回传编号
     */
    private String weixin_trade_no;

    /**
     * 打印状态
     */
    private Boolean printStatus;

    /**
     * 开票状态0未开票，1已开票，2退票
     */
    private Integer ticketStatus;

    /**
     * 发票流水号
     */
    private String invoiceSerialNum;

    /**
     * 发票代码
     */
    private String invoiceCode;

    /**
     * 发票号码
     */
    private String invoiceNum;

    /**
     * 付款人支付宝id
     */
    private String buyer_user_id;

    private String remark;

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
     * 获取对应小区id
     *
     * @return housing_id - 对应小区id
     */
    public Integer getHousing_id() {
        return housing_id;
    }

    /**
     * 设置对应小区id
     *
     * @param housing_id 对应小区id
     */
    public void setHousing_id(Integer housing_id) {
        this.housing_id = housing_id;
    }

    /**
     * 获取对应房间id
     *
     * @return roominfo_id - 对应房间id
     */
    public Integer getRoominfo_id() {
        return roominfo_id;
    }

    /**
     * 设置对应房间id
     *
     * @param roominfo_id 对应房间id
     */
    public void setRoominfo_id(Integer roominfo_id) {
        this.roominfo_id = roominfo_id;
    }

    /**
     * 获取费用类型名称
     *
     * @return cost_type - 费用类型名称
     */
    public Integer getCost_type() {
        return cost_type;
    }

    /**
     * 设置费用类型名称
     *
     * @param cost_type 费用类型名称
     */
    public void setCost_type(Integer cost_type) {
        this.cost_type = cost_type;
    }

    /**
     * 获取应收金额
     *
     * @return bill_entry_amount - 应收金额
     */
    public Double getBill_entry_amount() {
        return bill_entry_amount;
    }

    /**
     * 设置应收金额
     *
     * @param bill_entry_amount 应收金额
     */
    public void setBill_entry_amount(Double bill_entry_amount) {
        this.bill_entry_amount = bill_entry_amount;
    }

    /**
     * 获取账期，用于归类和向用户展示
     *
     * @return acct_period - 账期，用于归类和向用户展示
     */
    public String getAcct_period() {
        return acct_period;
    }

    /**
     * 设置账期，用于归类和向用户展示
     *
     * @param acct_period 账期，用于归类和向用户展示
     */
    public void setAcct_period(String acct_period) {
        this.acct_period = acct_period == null ? null : acct_period.trim();
    }

    /**
     * 获取出账日期20160831
     *
     * @return release_day - 出账日期20160831
     */
    public String getRelease_day() {
        return release_day;
    }

    /**
     * 设置出账日期20160831
     *
     * @param release_day 出账日期20160831
     */
    public void setRelease_day(String release_day) {
        this.release_day = release_day == null ? null : release_day.trim();
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
    public String getRelate_id() {
        return relate_id;
    }

    /**
     * 设置缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     *
     * @param relate_id 缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。
     */
    public void setRelate_id(String relate_id) {
        this.relate_id = relate_id == null ? null : relate_id.trim();
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
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置付款时间
     *
     * @param payDate 付款时间
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取微信 支付宝 现金 刷卡 银行转账
     *
     * @return payType - 微信 支付宝 现金 刷卡 银行转账
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置微信 支付宝 现金 刷卡 银行转账
     *
     * @param payType 微信 支付宝 现金 刷卡 银行转账
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取付款状态 0：未付款  1：已付款
     *
     * @return payStatus - 付款状态 0：未付款  1：已付款
     */
    public Boolean getPayStatus() {
        return payStatus;
    }

    /**
     * 设置付款状态 0：未付款  1：已付款
     *
     * @param payStatus 付款状态 0：未付款  1：已付款
     */
    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return deleteStatus
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * @param deleteStatus
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取支付宝付款成功回传编号
     *
     * @return alipay_trade_no - 支付宝付款成功回传编号
     */
    public String getAlipay_trade_no() {
        return alipay_trade_no;
    }

    /**
     * 设置支付宝付款成功回传编号
     *
     * @param alipay_trade_no 支付宝付款成功回传编号
     */
    public void setAlipay_trade_no(String alipay_trade_no) {
        this.alipay_trade_no = alipay_trade_no == null ? null : alipay_trade_no.trim();
    }

    /**
     * 获取微信付款成功回传编号
     *
     * @return weixin_trade_no - 微信付款成功回传编号
     */
    public String getWeixin_trade_no() {
        return weixin_trade_no;
    }

    /**
     * 设置微信付款成功回传编号
     *
     * @param weixin_trade_no 微信付款成功回传编号
     */
    public void setWeixin_trade_no(String weixin_trade_no) {
        this.weixin_trade_no = weixin_trade_no == null ? null : weixin_trade_no.trim();
    }

    /**
     * 获取打印状态
     *
     * @return printStatus - 打印状态
     */
    public Boolean getPrintStatus() {
        return printStatus;
    }

    /**
     * 设置打印状态
     *
     * @param printStatus 打印状态
     */
    public void setPrintStatus(Boolean printStatus) {
        this.printStatus = printStatus;
    }

    /**
     * 获取开票状态0未开票，1已开票，2退票
     *
     * @return ticketStatus - 开票状态0未开票，1已开票，2退票
     */
    public Integer getTicketStatus() {
        return ticketStatus;
    }

    /**
     * 设置开票状态0未开票，1已开票，2退票
     *
     * @param ticketStatus 开票状态0未开票，1已开票，2退票
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

    /**
     * 获取发票代码
     *
     * @return invoiceCode - 发票代码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置发票代码
     *
     * @param invoiceCode 发票代码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 获取发票号码
     *
     * @return invoiceNum - 发票号码
     */
    public String getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * 设置发票号码
     *
     * @param invoiceNum 发票号码
     */
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum == null ? null : invoiceNum.trim();
    }

    /**
     * 获取付款人支付宝id
     *
     * @return buyer_user_id - 付款人支付宝id
     */
    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    /**
     * 设置付款人支付宝id
     *
     * @param buyer_user_id 付款人支付宝id
     */
    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id == null ? null : buyer_user_id.trim();
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