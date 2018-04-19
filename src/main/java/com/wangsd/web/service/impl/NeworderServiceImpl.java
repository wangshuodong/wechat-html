package com.wangsd.web.service.impl;

import com.wangsd.common.base.ServiceImpl;
import com.wangsd.common.utils.DateUtils;
import com.wangsd.web.dao.BillaccountMapper;
import com.wangsd.web.dao.NeworderMapper;
import com.wangsd.web.model.Billaccount;
import com.wangsd.web.model.Neworder;
import com.wangsd.web.model.Roominfo;
import com.wangsd.web.service.INeworderService;
import com.wangsd.web.service.IRoominfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NeworderServiceImpl extends ServiceImpl<Neworder> implements INeworderService {

    @Autowired
    NeworderMapper neworderMapper;
    @Autowired
    BillaccountMapper billaccountMapper;

    @Transactional
    public boolean updateNeworderAndBillAccount(String orderId, String time_end) {
        Date date = DateUtils.paseDatetime(DateUtils.timeStamp2Date(time_end, null));
        Neworder query = new Neworder();
        query.setOrderId(orderId);
        List<Neworder> list = mapper.select(query);
        for (Neworder order : list) {
            order.setPayTime(date);
            neworderMapper.updateByPrimaryKey(order);
            Billaccount billaccount = new Billaccount();
            billaccount.setId(order.getBillId());
            billaccount.setPayDate(date);
            billaccount.setPayStatus(true);
            billaccount.setPayType(3);
            billaccountMapper.updateByPrimaryKey(billaccount);
        }
        return true;
    }
}
