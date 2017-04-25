package com.uflowertv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.uflowertv.model.ApiResult;

@ControllerAdvice  
public class SpringExceptionHandler{  
  /** 
     * 全局处理Exception 
     * 错误的情况下返回500 
     * @param ex 
     * @param req 
     * @return 
     */  
    @ExceptionHandler(value = {Exception.class})  
    public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) {  
    	ApiResult result = new ApiResult();
    	result.setCode(500);
    	result.setMsg(ex.getMessage());
        return new ResponseEntity<Object>(result,HttpStatus.INTERNAL_SERVER_ERROR);
    }  
  
}  