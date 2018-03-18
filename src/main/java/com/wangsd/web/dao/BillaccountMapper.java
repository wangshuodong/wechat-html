package com.wangsd.web.dao;

import com.wangsd.common.base.MyMapper;
import com.wangsd.web.model.Billaccount;
import com.wangsd.web.pojo.BillaccountCustom;

import java.util.List;

public interface BillaccountMapper extends MyMapper<Billaccount> {

    List<BillaccountCustom> queryBillByRoomid(Integer roomid);
}