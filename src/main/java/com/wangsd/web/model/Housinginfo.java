package com.wangsd.web.model;

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
    private String community_id;

    private String code;

    private String name;

    private String address;

    /**
     * 上级物业id
     */
    private Integer parent_id;

    /**
     * 区县编码
     */
    private String district_code;

    /**
     * 地级市编码
     */
    private String city_code;

    /**
     * 省份编码
     */
    private String province_code;

    /**
     * 小区所在的经纬度列表
     */
    private String community_locations;

    /**
     * 小区对应的高德POI兴趣点列表
     */
    private String associated_pois;

    /**
     * 服务热线电话
     */
    private String hotline;

    /**
     * 短信条数
     */
    private Integer message_num;

    /**
     * 1未同步2已同步3已初始化
4已上线
     */
    private Integer status;

    private Boolean deleteStatus;

    private Date create_time;

    /**
     * 水费单价
     */
    private Double water_unit;

    /**
     * 微信云支付门店全局id
     */
    private String out_shop_id;

    /**
     * 云支付订单前缀
     */
    private String order_prefix;

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
    public String getCommunity_id() {
        return community_id;
    }

    /**
     * 设置支付宝小区统一编号
     *
     * @param community_id 支付宝小区统一编号
     */
    public void setCommunity_id(String community_id) {
        this.community_id = community_id == null ? null : community_id.trim();
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
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置上级物业id
     *
     * @param parent_id 上级物业id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取区县编码
     *
     * @return district_code - 区县编码
     */
    public String getDistrict_code() {
        return district_code;
    }

    /**
     * 设置区县编码
     *
     * @param district_code 区县编码
     */
    public void setDistrict_code(String district_code) {
        this.district_code = district_code == null ? null : district_code.trim();
    }

    /**
     * 获取地级市编码
     *
     * @return city_code - 地级市编码
     */
    public String getCity_code() {
        return city_code;
    }

    /**
     * 设置地级市编码
     *
     * @param city_code 地级市编码
     */
    public void setCity_code(String city_code) {
        this.city_code = city_code == null ? null : city_code.trim();
    }

    /**
     * 获取省份编码
     *
     * @return province_code - 省份编码
     */
    public String getProvince_code() {
        return province_code;
    }

    /**
     * 设置省份编码
     *
     * @param province_code 省份编码
     */
    public void setProvince_code(String province_code) {
        this.province_code = province_code == null ? null : province_code.trim();
    }

    /**
     * 获取小区所在的经纬度列表
     *
     * @return community_locations - 小区所在的经纬度列表
     */
    public String getCommunity_locations() {
        return community_locations;
    }

    /**
     * 设置小区所在的经纬度列表
     *
     * @param community_locations 小区所在的经纬度列表
     */
    public void setCommunity_locations(String community_locations) {
        this.community_locations = community_locations == null ? null : community_locations.trim();
    }

    /**
     * 获取小区对应的高德POI兴趣点列表
     *
     * @return associated_pois - 小区对应的高德POI兴趣点列表
     */
    public String getAssociated_pois() {
        return associated_pois;
    }

    /**
     * 设置小区对应的高德POI兴趣点列表
     *
     * @param associated_pois 小区对应的高德POI兴趣点列表
     */
    public void setAssociated_pois(String associated_pois) {
        this.associated_pois = associated_pois == null ? null : associated_pois.trim();
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
    public Integer getMessage_num() {
        return message_num;
    }

    /**
     * 设置短信条数
     *
     * @param message_num 短信条数
     */
    public void setMessage_num(Integer message_num) {
        this.message_num = message_num;
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
     * 获取水费单价
     *
     * @return water_unit - 水费单价
     */
    public Double getWater_unit() {
        return water_unit;
    }

    /**
     * 设置水费单价
     *
     * @param water_unit 水费单价
     */
    public void setWater_unit(Double water_unit) {
        this.water_unit = water_unit;
    }

    /**
     * 获取微信云支付门店全局id
     *
     * @return out_shop_id - 微信云支付门店全局id
     */
    public String getOut_shop_id() {
        return out_shop_id;
    }

    /**
     * 设置微信云支付门店全局id
     *
     * @param out_shop_id 微信云支付门店全局id
     */
    public void setOut_shop_id(String out_shop_id) {
        this.out_shop_id = out_shop_id == null ? null : out_shop_id.trim();
    }

    /**
     * 获取云支付订单前缀
     *
     * @return order_prefix - 云支付订单前缀
     */
    public String getOrder_prefix() {
        return order_prefix;
    }

    /**
     * 设置云支付订单前缀
     *
     * @param order_prefix 云支付订单前缀
     */
    public void setOrder_prefix(String order_prefix) {
        this.order_prefix = order_prefix == null ? null : order_prefix.trim();
    }
}