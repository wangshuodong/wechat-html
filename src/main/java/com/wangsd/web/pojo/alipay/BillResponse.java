package com.wangsd.web.pojo.alipay;

import com.alipay.api.domain.CPBillResultSet;

import java.util.List;

/**
 * 封装账单返回参数
 */
public class BillResponse extends AlipayResponse {
    /**
     * 当前页码
     */
    private int current_page_num;
    /**
     * 符合条件的总结果数
     */
    private int total_bill_count;
    /**
     * 支付宝返回的集合
     */
    List<CPBillResultSet> billResultSet;

    public int getCurrent_page_num() {
        return current_page_num;
    }

    public void setCurrent_page_num(int current_page_num) {
        this.current_page_num = current_page_num;
    }

    public int getTotal_bill_count() {
        return total_bill_count;
    }

    public void setTotal_bill_count(int total_bill_count) {
        this.total_bill_count = total_bill_count;
    }

    public List<CPBillResultSet> getBillResultSet() {
        return billResultSet;
    }

    public void setBillResultSet(List<CPBillResultSet> billResultSet) {
        this.billResultSet = billResultSet;
    }
}
