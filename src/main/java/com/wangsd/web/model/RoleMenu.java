package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "role_menu")
public class RoleMenu {
    @Id
    private Integer role_id;

    @Id
    private Integer menu_id;

    /**
     * @return role_id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * @param role_id
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return menu_id
     */
    public Integer getMenu_id() {
        return menu_id;
    }

    /**
     * @param menu_id
     */
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }
}