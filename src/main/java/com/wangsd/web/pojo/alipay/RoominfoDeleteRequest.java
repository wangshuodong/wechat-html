package com.wangsd.web.pojo.alipay;

import java.util.List;

public class RoominfoDeleteRequest extends AlipayBaseRequest {
    /**
     * 支付宝社区小区统一编号
     */
    private String community_id;

    /**
     * 请求批次号
     */
    private String batch_id;

    /**
     * 待删除的商户房间id列表
     */
    private List<String> out_room_id_set;

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public List<String> getOut_room_id_set() {
        return out_room_id_set;
    }

    public void setOut_room_id_set(List<String> out_room_id_set) {
        this.out_room_id_set = out_room_id_set;
    }
}
