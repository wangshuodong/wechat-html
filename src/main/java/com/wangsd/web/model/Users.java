package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户昵称
     */
    private String name;

    private String username;

    private String password;

    /**
     * 部门id
     */
    private Integer parent_id;

    private String parent_code;

    /**
     * 角色id
     */
    private Integer role_id;

    private String phone;

    private String email;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 1代表服务商，2代表物业，3代表小区
     */
    private Integer type;

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
     * 获取用户昵称
     *
     * @return name - 用户昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户昵称
     *
     * @param name 用户昵称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取部门id
     *
     * @return parent_id - 部门id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置部门id
     *
     * @param parent_id 部门id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * @return parent_code
     */
    public String getParent_code() {
        return parent_code;
    }

    /**
     * @param parent_code
     */
    public void setParent_code(String parent_code) {
        this.parent_code = parent_code == null ? null : parent_code.trim();
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置角色id
     *
     * @param role_id 角色id
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取是否启用
     *
     * @return enable - 是否启用
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * 设置是否启用
     *
     * @param enable 是否启用
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
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