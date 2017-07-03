package com.uflowertv.statistics.model;

import lombok.Data;

import java.util.Date;
@Data
public class Start {
    private Integer id;
    
    private Date dt;

    private Integer platformid;

    private String zoneid;

    private String deviceid;

    private Short entryid;

    private Integer params;
}