package com.wangsd.web.service;

import com.wangsd.common.base.IService;
import com.wangsd.web.model.Neworder;
import com.wangsd.web.model.Roominfo;

public interface INeworderService extends IService<Neworder>{

    public boolean updateNeworderAndBillAccount(String orderId, String time_end);
}
