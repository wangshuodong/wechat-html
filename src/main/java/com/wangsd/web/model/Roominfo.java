package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roominfo")
public class Roominfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer parent_id;

    /**
     * 支付宝房屋编号
     */
    private String room_id;

    /**
     * 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    private String group_name;

    /**
     * 房屋所在楼栋名称。例如“1栋”，“1幢”等
     */
    private String building;

    /**
     * 房屋所在单元名称
     */
    private String unit;

    /**
     * 房屋所在房号。例如“1101室”，“11B室”等
     */
    private String room;

    /**
     * 房间的完整门牌地址，例如一期1栋2单元2202室
     */
    private String address;

    /**
     * 业主姓名
     */
    private String owner_name;

    /**
     * 业主身份证
     */
    private String owner_card;

    /**
     * 业主电话
     */
    private String owner_phone;

    /**
     * 入住时间
     */
    private String entryDate;

    private Boolean deleteStatus;

    /**
     * false没有同步，true同步
     */
    private Boolean status;

    private Date create_time;

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
     * @return parent_id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * @param parent_id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取支付宝房屋编号
     *
     * @return room_id - 支付宝房屋编号
     */
    public String getRoom_id() {
        return room_id;
    }

    /**
     * 设置支付宝房屋编号
     *
     * @param room_id 支付宝房屋编号
     */
    public void setRoom_id(String room_id) {
        this.room_id = room_id == null ? null : room_id.trim();
    }

    /**
     * 获取房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     *
     * @return group_name - 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    public String getGroup_name() {
        return group_name;
    }

    /**
     * 设置房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     *
     * @param group_name 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    public void setGroup_name(String group_name) {
        this.group_name = group_name == null ? null : group_name.trim();
    }

    /**
     * 获取房屋所在楼栋名称。例如“1栋”，“1幢”等
     *
     * @return building - 房屋所在楼栋名称。例如“1栋”，“1幢”等
     */
    public String getBuilding() {
        return building;
    }

    /**
     * 设置房屋所在楼栋名称。例如“1栋”，“1幢”等
     *
     * @param building 房屋所在楼栋名称。例如“1栋”，“1幢”等
     */
    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    /**
     * 获取房屋所在单元名称
     *
     * @return unit - 房屋所在单元名称
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置房屋所在单元名称
     *
     * @param unit 房屋所在单元名称
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 获取房屋所在房号。例如“1101室”，“11B室”等
     *
     * @return room - 房屋所在房号。例如“1101室”，“11B室”等
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置房屋所在房号。例如“1101室”，“11B室”等
     *
     * @param room 房屋所在房号。例如“1101室”，“11B室”等
     */
    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    /**
     * 获取房间的完整门牌地址，例如一期1栋2单元2202室
     *
     * @return address - 房间的完整门牌地址，例如一期1栋2单元2202室
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置房间的完整门牌地址，例如一期1栋2单元2202室
     *
     * @param address 房间的完整门牌地址，例如一期1栋2单元2202室
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取业主姓名
     *
     * @return owner_name - 业主姓名
     */
    public String getOwner_name() {
        return owner_name;
    }

    /**
     * 设置业主姓名
     *
     * @param owner_name 业主姓名
     */
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name == null ? null : owner_name.trim();
    }

    /**
     * 获取业主身份证
     *
     * @return owner_card - 业主身份证
     */
    public String getOwner_card() {
        return owner_card;
    }

    /**
     * 设置业主身份证
     *
     * @param owner_card 业主身份证
     */
    public void setOwner_card(String owner_card) {
        this.owner_card = owner_card == null ? null : owner_card.trim();
    }

    /**
     * 获取业主电话
     *
     * @return owner_phone - 业主电话
     */
    public String getOwner_phone() {
        return owner_phone;
    }

    /**
     * 设置业主电话
     *
     * @param owner_phone 业主电话
     */
    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone == null ? null : owner_phone.trim();
    }

    /**
     * 获取入住时间
     *
     * @return entryDate - 入住时间
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * 设置入住时间
     *
     * @param entryDate 入住时间
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate == null ? null : entryDate.trim();
    }

    /**
     * @return deleteStatus
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * @param deleteStatus
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取false没有同步，true同步
     *
     * @return status - false没有同步，true同步
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置false没有同步，true同步
     *
     * @param status false没有同步，true同步
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
}