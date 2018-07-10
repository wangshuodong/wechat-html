package com.wangsd.web.pojo.alipay;

public class RoominfoQueryRequest extends AlipayBaseRequest {
    /**
     * 支付宝社区小区统一编号
     */
    private String community_id;

    private int page_num = 1;

    private int page_size = 200;

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public int getPage_num() {
        return page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }
}
