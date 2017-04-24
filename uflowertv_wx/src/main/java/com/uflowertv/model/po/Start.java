package com.uflowertv.model.po;

import lombok.Data;

import java.util.Date;
@Data
public class Start {

    private Integer id;
    
    private Date dt;

    private Integer platformID;

    private String zoneID;

    private String deviceID;

    private Integer entryID;

}