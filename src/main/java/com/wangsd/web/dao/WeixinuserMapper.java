package com.wangsd.web.dao;

import com.wangsd.common.base.MyMapper;
import com.wangsd.web.model.Weixinuser;
import com.wangsd.web.pojo.RoomCustom;

import java.util.List;

public interface WeixinuserMapper extends MyMapper<Weixinuser> {

    List<RoomCustom> queryRoomBunding(String openid);
}