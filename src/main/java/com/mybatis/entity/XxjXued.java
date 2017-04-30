package com.mybatis.entity;

public class XxjXued {
    private Integer xuedId;

    private String xuedName;

    private Integer sort;

    public Integer getXuedId() {
        return xuedId;
    }

    public void setXuedId(Integer xuedId) {
        this.xuedId = xuedId;
    }

    public String getXuedName() {
        return xuedName;
    }

    public void setXuedName(String xuedName) {
        this.xuedName = xuedName == null ? null : xuedName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}