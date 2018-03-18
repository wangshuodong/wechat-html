package com.wangsd.web.model;

import javax.persistence.*;

@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    /**
     * 图标
     */
    private String icon_Cls;

    private Integer parent_id;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否启用
     */
    private Byte enable;

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取图标
     *
     * @return icon_Cls - 图标
     */
    public String getIcon_Cls() {
        return icon_Cls;
    }

    /**
     * 设置图标
     *
     * @param icon_Cls 图标
     */
    public void setIcon_Cls(String icon_Cls) {
        this.icon_Cls = icon_Cls == null ? null : icon_Cls.trim();
    }

    /**
     * @return parent_id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * @param parent_id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否启用
     *
     * @return enable - 是否启用
     */
    public Byte getEnable() {
        return enable;
    }

    /**
     * 设置是否启用
     *
     * @param enable 是否启用
     */
    public void setEnable(Byte enable) {
        this.enable = enable;
    }
}