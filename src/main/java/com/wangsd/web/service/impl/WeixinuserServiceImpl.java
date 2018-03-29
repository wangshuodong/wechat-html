package com.wangsd.web.service.impl;

import com.wangsd.common.base.ServiceImpl;
import com.wangsd.web.dao.WeixinuserMapper;
import com.wangsd.web.model.Weixinuser;
import com.wangsd.web.pojo.RoomCustom;
import com.wangsd.web.service.IWeixinuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeixinuserServiceImpl extends ServiceImpl<Weixinuser> implements IWeixinuserService {

    @Autowired
    WeixinuserMapper weixinuserMapper;

    public List<RoomCustom> queryRoomBunding(String openid) {
        return weixinuserMapper.queryRoomBunding(openid);
    }
}
