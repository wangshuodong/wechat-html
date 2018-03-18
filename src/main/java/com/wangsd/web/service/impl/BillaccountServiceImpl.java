package com.wangsd.web.service.impl;

import com.wangsd.common.base.ServiceImpl;
import com.wangsd.web.dao.BillaccountMapper;
import com.wangsd.web.model.Billaccount;
import com.wangsd.web.pojo.BillaccountCustom;
import com.wangsd.web.service.IBillaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillaccountServiceImpl extends ServiceImpl<Billaccount> implements IBillaccountService{

    @Autowired
    BillaccountMapper billaccountMapper;

    @Override
    public List<BillaccountCustom> queryBillByRoomId(Integer roomid) {
        return billaccountMapper.queryBillByRoomid(roomid);
    }
}
