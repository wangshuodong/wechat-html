package com.wangsd.web.pojo;

import com.wangsd.web.model.Billaccount;

public class BillaccountCustom extends Billaccount {

    private String costTypeName;

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }
}
