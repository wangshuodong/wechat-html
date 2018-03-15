package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roominfo")
public class Roominfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 支付宝房屋编号
     */
    @Column(name = "room_id")
    private String roomId;

    /**
     * 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    @Column(name = "group_name")
    private String groupName;

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
    @Column(name = "owner_name")
    private String ownerName;

    /**
     * 业主身份证
     */
    @Column(name = "owner_card")
    private String ownerCard;

    /**
     * 业主电话
     */
    @Column(name = "owner_phone")
    private String ownerPhone;

    /**
     * 入住时间
     */
    @Column(name = "entryDate")
    private String entrydate;

    @Column(name = "deleteStatus")
    private Boolean deletestatus;

    /**
     * false没有同步，true同步
     */
    private Boolean status;

    @Column(name = "create_time")
    private Date createTime;

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
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取支付宝房屋编号
     *
     * @return room_id - 支付宝房屋编号
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * 设置支付宝房屋编号
     *
     * @param roomId 支付宝房屋编号
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * 获取房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     *
     * @return group_name - 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     *
     * @param groupName 房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置业主姓名
     *
     * @param ownerName 业主姓名
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    /**
     * 获取业主身份证
     *
     * @return owner_card - 业主身份证
     */
    public String getOwnerCard() {
        return ownerCard;
    }

    /**
     * 设置业主身份证
     *
     * @param ownerCard 业主身份证
     */
    public void setOwnerCard(String ownerCard) {
        this.ownerCard = ownerCard == null ? null : ownerCard.trim();
    }

    /**
     * 获取业主电话
     *
     * @return owner_phone - 业主电话
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * 设置业主电话
     *
     * @param ownerPhone 业主电话
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone == null ? null : ownerPhone.trim();
    }

    /**
     * 获取入住时间
     *
     * @return entryDate - 入住时间
     */
    public String getEntrydate() {
        return entrydate;
    }

    /**
     * 设置入住时间
     *
     * @param entrydate 入住时间
     */
    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate == null ? null : entrydate.trim();
    }

    /**
     * @return deleteStatus
     */
    public Boolean getDeletestatus() {
        return deletestatus;
    }

    /**
     * @param deletestatus
     */
    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}