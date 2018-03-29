package com.wangsd.web.service;

import com.wangsd.common.base.IService;
import com.wangsd.web.model.Weixinuser;
import com.wangsd.web.pojo.RoomCustom;

import java.util.List;

public interface IWeixinuserService extends IService<Weixinuser> {

    public List<RoomCustom> queryRoomBunding(String openid);

    /**
     * 绑定房间
     * @param weixinuser
     */
    public void bingRoom(Weixinuser weixinuser);
}
