package com.uflowertv.controller;

import com.uflowertv.model.vo.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  
public class SpringExceptionHandler{  
  /** 
     * 全局处理Exception 
     * 错误的情况下返回500 
     * @param ex 
     * @return
     */  
    @ExceptionHandler(value = {Exception.class})  
    public ResponseEntity<Object> handleOtherExceptions(final Exception ex) {
        JsonResult result = new JsonResult();
        result.setCode("500");
    	result.setMsg(ex.getMessage());
        return new ResponseEntity<Object>(result,HttpStatus.INTERNAL_SERVER_ERROR);
    }  
}