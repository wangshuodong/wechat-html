package com.wangsd.web.pojo;

import com.wangsd.web.model.Roominfo;

public class RoomCustom extends Roominfo {
    private String housingName;

    private Integer weixinuserId;

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public Integer getWeixinuserId() {
        return weixinuserId;
    }

    public void setWeixinuserId(Integer weixinuserId) {
        this.weixinuserId = weixinuserId;
    }
}
