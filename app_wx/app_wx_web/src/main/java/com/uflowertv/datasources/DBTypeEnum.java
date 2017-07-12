package com.uflowertv.datasources;

public enum DBTypeEnum {

    dataSource_wx("dataSource_wx"),
    dataSource_tj("dataSource_tj");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}