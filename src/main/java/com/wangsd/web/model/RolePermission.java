package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "role_permission")
public class RolePermission {
    /**
     * 角色id
     */
    @Id
    private Long role_id;

    /**
     * 权限id
     */
    @Id
    private Long permission_id;

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRole_id() {
        return role_id;
    }

    /**
     * 设置角色id
     *
     * @param role_id 角色id
     */
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取权限id
     *
     * @return permission_id - 权限id
     */
    public Long getPermission_id() {
        return permission_id;
    }

    /**
     * 设置权限id
     *
     * @param permission_id 权限id
     */
    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }
}