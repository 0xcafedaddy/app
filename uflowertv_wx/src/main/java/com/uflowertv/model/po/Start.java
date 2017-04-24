package com.uflowertv.model.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("start_2017")
public class Start {

    @TableId
    private Integer id;
    
    private Date dt;

    private Integer platformID;

    private String zoneID;

    private String deviceID;

    private Integer entryID;

}