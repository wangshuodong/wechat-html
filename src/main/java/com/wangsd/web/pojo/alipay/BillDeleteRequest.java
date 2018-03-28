package com.wangsd.web.pojo.alipay;

import java.util.List;

public class BillDeleteRequest extends AlipayBaseRequest {
    /**
     * 支付宝社区小区统一编号
     */
    private String community_id;
    /**
     * 指定小区下待删除的物业费账单应收明细条目ID列表，一次最多删除1000条，如果明细条目已被支付或在支付中，则无法被删除。接口会返回无法删除的明细条目ID列表。
     */
    private List<String> bill_entry_id_list;

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public List<String> getBill_entry_id_list() {
        return bill_entry_id_list;
    }

    public void setBill_entry_id_list(List<String> bill_entry_id_list) {
        this.bill_entry_id_list = bill_entry_id_list;
    }
}
