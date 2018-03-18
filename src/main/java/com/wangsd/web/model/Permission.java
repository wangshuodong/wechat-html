package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "permission")
public class Permission {
    /**
     * 权限id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限标识,程序中判断使用,如"user:create"
     */
    private String permission_sign;

    /**
     * 权限描述,UI界面显示使用
     */
    private String description;

    /**
     * 获取权限id
     *
     * @return id - 权限id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置权限id
     *
     * @param id 权限id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取权限名
     *
     * @return name - 权限名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名
     *
     * @param name 权限名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限标识,程序中判断使用,如"user:create"
     *
     * @return permission_sign - 权限标识,程序中判断使用,如"user:create"
     */
    public String getPermission_sign() {
        return permission_sign;
    }

    /**
     * 设置权限标识,程序中判断使用,如"user:create"
     *
     * @param permission_sign 权限标识,程序中判断使用,如"user:create"
     */
    public void setPermission_sign(String permission_sign) {
        this.permission_sign = permission_sign == null ? null : permission_sign.trim();
    }

    /**
     * 获取权限描述,UI界面显示使用
     *
     * @return description - 权限描述,UI界面显示使用
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述,UI界面显示使用
     *
     * @param description 权限描述,UI界面显示使用
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}