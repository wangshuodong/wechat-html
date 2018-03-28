package com.wangsd.web.pojo.alipay;

/**
 * 封装账单请求参数
 */
public class BillQueryRequest {
    /**
     * 支付宝社区小区统一编号，必须在授权物业账号名下存在。
     */
    private String community_id;
    /**
     * 根据账单状态查询，不传该字段则返回所有状态的账单。
     * FINISH_PAYMENT - 用户完成支付和销账
     * UNDER_PAYMENT - 账单锁定待用户完成支付
     * WAIT_PAYMENT - 待缴且未过缴费截止日期
     * OUT_OF_DATE - 未支付且已过缴费截止日期
     */
    private String bill_status;
    /**
     * 根据物业系统端房屋编号查询
     */
    private String out_room_id;
    /**
     * 根据费用类型查询，只支持精确查询。
     */
    private String cost_type;
    /**
     * 根据账期查询
     */
    private String acct_period;
    /**
     * 根据出账日期查询，格式为YYYYMMDD
     */
    private String release_day;
    /**
     * 根据开发者上传物业费账单时需要的批次号查询指定批次下上传成功的账单
     */
    private String batch_id;
    /**
     * 分页查询的当前页码数，分页从1开始计数。
     * 该参数不传入的时候，默认为1
     */
    private Integer page_num;
    /**
     * 分页查询的每页最大数据条数，取值范围1-500。
     * 不传该参数默认为200。
     */
    private Integer page_size;

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getBill_status() {
        return bill_status;
    }

    public void setBill_status(String bill_status) {
        this.bill_status = bill_status;
    }

    public String getOut_room_id() {
        return out_room_id;
    }

    public void setOut_room_id(String out_room_id) {
        this.out_room_id = out_room_id;
    }

    public String getCost_type() {
        return cost_type;
    }

    public void setCost_type(String cost_type) {
        this.cost_type = cost_type;
    }

    public String getAcct_period() {
        return acct_period;
    }

    public void setAcct_period(String acct_period) {
        this.acct_period = acct_period;
    }

    public String getRelease_day() {
        return release_day;
    }

    public void setRelease_day(String release_day) {
        this.release_day = release_day;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }
}
