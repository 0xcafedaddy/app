package com.uflowertv.wechat.model;

import lombok.Data;

import java.util.Date;
@Data
public class PhoneCode {
    private String phone;

    private String code;

    private Byte amount;

    private Date time;
}