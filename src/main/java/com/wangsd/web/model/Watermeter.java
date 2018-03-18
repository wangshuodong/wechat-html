package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "watermeter")
public class Watermeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer housing_id;

    private Integer roominfo_id;

    /**
     * 本期实数
     */
    private Double water_num;

    /**
     * 本期用量
     */
    private Double use_num;

    /**
     * 抄表员
     */
    private Integer user_id;

    /**
     * 本期金额
     */
    private Double amount;

    private Date create_time;

    private Double old_water_num;

    private Double old_use_num;

    /**
     * 0:未上传 1：已上传
     */
    private Boolean status;

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
     * @return housing_id
     */
    public Integer getHousing_id() {
        return housing_id;
    }

    /**
     * @param housing_id
     */
    public void setHousing_id(Integer housing_id) {
        this.housing_id = housing_id;
    }

    /**
     * @return roominfo_id
     */
    public Integer getRoominfo_id() {
        return roominfo_id;
    }

    /**
     * @param roominfo_id
     */
    public void setRoominfo_id(Integer roominfo_id) {
        this.roominfo_id = roominfo_id;
    }

    /**
     * 获取本期实数
     *
     * @return water_num - 本期实数
     */
    public Double getWater_num() {
        return water_num;
    }

    /**
     * 设置本期实数
     *
     * @param water_num 本期实数
     */
    public void setWater_num(Double water_num) {
        this.water_num = water_num;
    }

    /**
     * 获取本期用量
     *
     * @return use_num - 本期用量
     */
    public Double getUse_num() {
        return use_num;
    }

    /**
     * 设置本期用量
     *
     * @param use_num 本期用量
     */
    public void setUse_num(Double use_num) {
        this.use_num = use_num;
    }

    /**
     * 获取抄表员
     *
     * @return user_id - 抄表员
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置抄表员
     *
     * @param user_id 抄表员
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取本期金额
     *
     * @return amount - 本期金额
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置本期金额
     *
     * @param amount 本期金额
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * @param create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * @return old_water_num
     */
    public Double getOld_water_num() {
        return old_water_num;
    }

    /**
     * @param old_water_num
     */
    public void setOld_water_num(Double old_water_num) {
        this.old_water_num = old_water_num;
    }

    /**
     * @return old_use_num
     */
    public Double getOld_use_num() {
        return old_use_num;
    }

    /**
     * @param old_use_num
     */
    public void setOld_use_num(Double old_use_num) {
        this.old_use_num = old_use_num;
    }

    /**
     * 获取0:未上传 1：已上传
     *
     * @return status - 0:未上传 1：已上传
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置0:未上传 1：已上传
     *
     * @param status 0:未上传 1：已上传
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}