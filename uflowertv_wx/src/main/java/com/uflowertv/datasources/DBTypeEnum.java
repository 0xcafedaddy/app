package com.uflowertv.datasources;

public enum DBTypeEnum {

    one("dataSource_wx"),
    two("dataSource_tj");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}