package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 角色标识,程序中判断使用,如"admin"
     */
    private String role_sign;

    private String description;

    private Date create_time;

    /**
     * 1代表服务商，2代表物业，3代表小区
     */
    private Integer type;

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
     * 获取角色标识,程序中判断使用,如"admin"
     *
     * @return role_sign - 角色标识,程序中判断使用,如"admin"
     */
    public String getRole_sign() {
        return role_sign;
    }

    /**
     * 设置角色标识,程序中判断使用,如"admin"
     *
     * @param role_sign 角色标识,程序中判断使用,如"admin"
     */
    public void setRole_sign(String role_sign) {
        this.role_sign = role_sign == null ? null : role_sign.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * 获取1代表服务商，2代表物业，3代表小区
     *
     * @return type - 1代表服务商，2代表物业，3代表小区
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1代表服务商，2代表物业，3代表小区
     *
     * @param type 1代表服务商，2代表物业，3代表小区
     */
    public void setType(Integer type) {
        this.type = type;
    }
}