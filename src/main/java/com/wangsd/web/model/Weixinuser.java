package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "weixinuser")
public class Weixinuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 房间id
     */
    private Integer roominfoid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取微信openid
     *
     * @return openid - 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openid
     *
     * @param openid 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取房间id
     *
     * @return roominfoid - 房间id
     */
    public Integer getRoominfoid() {
        return roominfoid;
    }

    /**
     * 设置房间id
     *
     * @param roominfoid 房间id
     */
    public void setRoominfoid(Integer roominfoid) {
        this.roominfoid = roominfoid;
    }
}