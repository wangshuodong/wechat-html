package com.wangsd.web.service;

import com.wangsd.common.base.IService;
import com.wangsd.web.model.Billaccount;
import com.wangsd.web.pojo.BillaccountCustom;

import java.util.List;

public interface IBillaccountService extends IService<Billaccount> {

    public List<BillaccountCustom> queryBillByRoomId(Integer roomid);
}
