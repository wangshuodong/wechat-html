package com.wangsd.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.wangsd.common.base.ServiceImpl;
import com.wangsd.common.utils.DateUtils;
import com.wangsd.web.dao.*;
import com.wangsd.web.model.*;
import com.wangsd.web.pojo.alipay.AlipayBaseRequest;
import com.wangsd.web.pojo.alipay.BillDeleteRequest;
import com.wangsd.web.service.INeworderService;
import com.wangsd.web.service.IRoominfoService;
import com.wangsd.web.utils.AlipayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NeworderServiceImpl extends ServiceImpl<Neworder> implements INeworderService {

    @Autowired
    NeworderMapper neworderMapper;
    @Autowired
    BillaccountMapper billaccountMapper;
    @Autowired
    HousinginfoMapper housinginfoMapper;
    @Autowired
    PropertyinfoMapper propertyinfoMapper;
    @Autowired
    ServiceinfoMapper serviceinfoMapper;

    @Transactional
    public boolean updateNeworderAndBillAccount(String orderId, String time_end, String transaction_id) {
        Date date = DateUtils.paseDatetime(DateUtils.timeStamp2Date(time_end, null));
        Neworder query = new Neworder();
        query.setOrderId(orderId);
        List<Neworder> list = mapper.select(query);
        for (Neworder order : list) {
            order.setPayTime(date);
            neworderMapper.updateByPrimaryKey(order);
            Billaccount billaccount = billaccountMapper.selectByPrimaryKey(order.getBillId());
            //如果已同步到支付宝
            if (billaccount.getStatus() && !billaccount.getPayStatus()) {

                Housinginfo housinginfo = housinginfoMapper.selectByPrimaryKey(billaccount.getHousing_id());
                Propertyinfo propertyinfo = propertyinfoMapper.selectByPrimaryKey(housinginfo.getParent_id());
                Serviceinfo serviceinfo = serviceinfoMapper.selectByPrimaryKey(propertyinfo.getParent_id());

                AlipayBaseRequest alipayRequest = new AlipayBaseRequest();
                alipayRequest.setAppId(serviceinfo.getApp_id());
                alipayRequest.setPrivateKey(serviceinfo.getMerchant_private_key());
                alipayRequest.setApp_auth_token(propertyinfo.getToken());

                BillDeleteRequest billRequest = new BillDeleteRequest();
                billRequest.setCommunity_id(housinginfo.getCommunity_id());
                List<String> ids = new ArrayList<>();
                ids.add(billaccount.getId().toString());
                billRequest.setBill_entry_id_list(ids);
                alipayRequest.setBiz_content(JSONObject.toJSONString(billRequest));

                AlipayUtil alipayUtil = new AlipayUtil(alipayRequest);
                try {
                    alipayUtil.billDelete();
                } catch (AlipayApiException e) {
                    e.printStackTrace();
                }
            }
            billaccount.setPayDate(date);
            billaccount.setPayStatus(true);
            billaccount.setWeixin_trade_no(transaction_id);
            billaccount.setPayType(3);
            billaccountMapper.updateByPrimaryKey(billaccount);

        }
        return true;
    }
}
