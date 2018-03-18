package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "costtype")
public class Costtype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 税率
     */
    private Double taxRate;

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
     * 获取税率
     *
     * @return taxRate - 税率
     */
    public Double getTaxRate() {
        return taxRate;
    }

    /**
     * 设置税率
     *
     * @param taxRate 税率
     */
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}