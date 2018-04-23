package com.wangsd.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.wangsd.common.base.ServiceImpl;
import com.wangsd.common.utils.DateUtils;
import com.wangsd.common.utils.yilianyun.Methods;
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
    @Autowired
    RoominfoMapper roominfoMapper;
    @Autowired
    CosttypeMapper costtypeMapper;
    @Autowired
    PrintinfoMapper printinfoMapper;

    @Transactional
    public boolean updateNeworderAndBillAccount(String orderId, String time_end, String transaction_id, double total_amount) {
        Date date = DateUtils.paseDatetime(DateUtils.timeStamp2Date(time_end, null));
        Neworder query = new Neworder();
        query.setOrderId(orderId);
        List<Neworder> list = mapper.select(query);

        Housinginfo housinginfo = null;
        Propertyinfo propertyinfo = null;
        Serviceinfo serviceinfo = null;
        Billaccount billaccount = null;

        StringBuffer detail = new StringBuffer("");

        for (Neworder order : list) {
            order.setPayTime(date);
            neworderMapper.updateByPrimaryKey(order);

            billaccount = billaccountMapper.selectByPrimaryKey(order.getBillId());
            //如果已同步到支付宝
            if (billaccount.getStatus() && !billaccount.getPayStatus()) {

                housinginfo = housinginfoMapper.selectByPrimaryKey(billaccount.getHousing_id());
                propertyinfo = propertyinfoMapper.selectByPrimaryKey(housinginfo.getParent_id());
                serviceinfo = serviceinfoMapper.selectByPrimaryKey(propertyinfo.getParent_id());

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

            Costtype costtype = costtypeMapper.selectByPrimaryKey(billaccount.getCost_type());
            detail.append("账期：" + billaccount.getAcct_period() + "\n");
            detail.append("类别：" + costtype.getName() + "\n");
            detail.append("金额：" + billaccount.getBill_entry_amount() + "\n");
        }
        Roominfo roominfo = roominfoMapper.selectByPrimaryKey(billaccount.getRoominfo_id());
        StringBuffer sb = new StringBuffer("");
        sb.append("<center>智慧小区</center>\n");
        sb.append("小区名称：" + housinginfo.getName() + "\n");
        sb.append(roominfo.getAddress() + "\n");
        sb.append("业主姓名：" + roominfo.getOwner_name() + "\n");
        sb.append("付款时间：" + DateUtils.formatDatetime(new Date()) + "\n");
        sb.append("订单编号：" + billaccount.getId() + "\n");
        sb.append("微信订单号：" + transaction_id + "\n");
        sb.append("支付方式：微信\n");
        sb.append("缴费金额：" + total_amount + "\n");
        sb.append("缴费明细：\n");
        sb.append("----------------------\n");
        sb.append(detail);
        sb.append("----------------------\n");
        sb.append("收款单位：" + propertyinfo.getName() + "\n");
        sb.append("----------------------\n");
        sb.append("<center>交易小票</center>\n");
        Printinfo printinfo = new Printinfo();
        printinfo.setDepartment_id(housinginfo.getId());
        printinfo.setDeleteStatus(true);
        printinfo = printinfoMapper.selectOne(printinfo);
        String originId = String.valueOf(System.currentTimeMillis());
        Methods.getInstance().print(printinfo.getMachine_code(), sb.toString(), originId);
        return true;
    }
}
