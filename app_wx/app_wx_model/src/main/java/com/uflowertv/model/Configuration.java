package com.uflowertv.model;

import lombok.Data;

import java.util.Date;

@Data
public class Configuration {
    private String id;

    private String content;

    private Date modified;

    private String value;

}