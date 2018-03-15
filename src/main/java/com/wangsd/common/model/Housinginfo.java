package com.wangsd.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "housinginfo")
public class Housinginfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 支付宝小区统一编号
     */
    @Column(name = "community_id")
    private String communityId;

    private String code;

    private String name;

    private String address;

    /**
     * 上级物业id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 区县编码
     */
    @Column(name = "district_code")
    private String districtCode;

    /**
     * 地级市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 省份编码
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 小区所在的经纬度列表
     */
    @Column(name = "community_locations")
    private String communityLocations;

    /**
     * 小区对应的高德POI兴趣点列表
     */
    @Column(name = "associated_pois")
    private String associatedPois;

    /**
     * 服务热线电话
     */
    private String hotline;

    /**
     * 短信条数
     */
    @Column(name = "message_num")
    private Integer messageNum;

    /**
     * 1未同步2已同步3已初始化
4已上线
     */
    private Integer status;

    @Column(name = "deleteStatus")
    private Boolean deletestatus;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 水费单价
     */
    @Column(name = "water_unit")
    private Double waterUnit;

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
     * 获取支付宝小区统一编号
     *
     * @return community_id - 支付宝小区统一编号
     */
    public String getCommunityId() {
        return communityId;
    }

    /**
     * 设置支付宝小区统一编号
     *
     * @param communityId 支付宝小区统一编号
     */
    public void setCommunityId(String communityId) {
        this.communityId = communityId == null ? null : communityId.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取上级物业id
     *
     * @return parent_id - 上级物业id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级物业id
     *
     * @param parentId 上级物业id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取区县编码
     *
     * @return district_code - 区县编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 设置区县编码
     *
     * @param districtCode 区县编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * 获取地级市编码
     *
     * @return city_code - 地级市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置地级市编码
     *
     * @param cityCode 地级市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取省份编码
     *
     * @return province_code - 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省份编码
     *
     * @param provinceCode 省份编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 获取小区所在的经纬度列表
     *
     * @return community_locations - 小区所在的经纬度列表
     */
    public String getCommunityLocations() {
        return communityLocations;
    }

    /**
     * 设置小区所在的经纬度列表
     *
     * @param communityLocations 小区所在的经纬度列表
     */
    public void setCommunityLocations(String communityLocations) {
        this.communityLocations = communityLocations == null ? null : communityLocations.trim();
    }

    /**
     * 获取小区对应的高德POI兴趣点列表
     *
     * @return associated_pois - 小区对应的高德POI兴趣点列表
     */
    public String getAssociatedPois() {
        return associatedPois;
    }

    /**
     * 设置小区对应的高德POI兴趣点列表
     *
     * @param associatedPois 小区对应的高德POI兴趣点列表
     */
    public void setAssociatedPois(String associatedPois) {
        this.associatedPois = associatedPois == null ? null : associatedPois.trim();
    }

    /**
     * 获取服务热线电话
     *
     * @return hotline - 服务热线电话
     */
    public String getHotline() {
        return hotline;
    }

    /**
     * 设置服务热线电话
     *
     * @param hotline 服务热线电话
     */
    public void setHotline(String hotline) {
        this.hotline = hotline == null ? null : hotline.trim();
    }

    /**
     * 获取短信条数
     *
     * @return message_num - 短信条数
     */
    public Integer getMessageNum() {
        return messageNum;
    }

    /**
     * 设置短信条数
     *
     * @param messageNum 短信条数
     */
    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    /**
     * 获取1未同步2已同步3已初始化
4已上线
     *
     * @return status - 1未同步2已同步3已初始化
4已上线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1未同步2已同步3已初始化
4已上线
     *
     * @param status 1未同步2已同步3已初始化
4已上线
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 获取水费单价
     *
     * @return water_unit - 水费单价
     */
    public Double getWaterUnit() {
        return waterUnit;
    }

    /**
     * 设置水费单价
     *
     * @param waterUnit 水费单价
     */
    public void setWaterUnit(Double waterUnit) {
        this.waterUnit = waterUnit;
    }
}