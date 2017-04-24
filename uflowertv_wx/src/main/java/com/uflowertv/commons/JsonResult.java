package com.uflowertv.commons;

import lombok.Data;

/**
 * 封装Json返回信息
 */
@Data
public class JsonResult {

    private boolean success;
    private String status;
    private String msg;
    private Object obj;
}
