package com.wangsd.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "printinfo")
public class Printinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer department_id;

    /**
     * 打印机终端号
     */
    private String machine_code;

    /**
     * 打印机密钥
     */
    private String msign;

    private String mobile_phone;

    private String print_name;

    /**
     * 0小区，1物业
     */
    private Integer status;

    /**
     * 0,禁用；1，激活
     */
    private Boolean deleteStatus;

    private Date createtime;

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
     * @return department_id
     */
    public Integer getDepartment_id() {
        return department_id;
    }

    /**
     * @param department_id
     */
    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    /**
     * 获取打印机终端号
     *
     * @return machine_code - 打印机终端号
     */
    public String getMachine_code() {
        return machine_code;
    }

    /**
     * 设置打印机终端号
     *
     * @param machine_code 打印机终端号
     */
    public void setMachine_code(String machine_code) {
        this.machine_code = machine_code == null ? null : machine_code.trim();
    }

    /**
     * 获取打印机密钥
     *
     * @return msign - 打印机密钥
     */
    public String getMsign() {
        return msign;
    }

    /**
     * 设置打印机密钥
     *
     * @param msign 打印机密钥
     */
    public void setMsign(String msign) {
        this.msign = msign == null ? null : msign.trim();
    }

    /**
     * @return mobile_phone
     */
    public String getMobile_phone() {
        return mobile_phone;
    }

    /**
     * @param mobile_phone
     */
    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone == null ? null : mobile_phone.trim();
    }

    /**
     * @return print_name
     */
    public String getPrint_name() {
        return print_name;
    }

    /**
     * @param print_name
     */
    public void setPrint_name(String print_name) {
        this.print_name = print_name == null ? null : print_name.trim();
    }

    /**
     * 获取0小区，1物业
     *
     * @return status - 0小区，1物业
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0小区，1物业
     *
     * @param status 0小区，1物业
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0,禁用；1，激活
     *
     * @return deleteStatus - 0,禁用；1，激活
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置0,禁用；1，激活
     *
     * @param deleteStatus 0,禁用；1，激活
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}