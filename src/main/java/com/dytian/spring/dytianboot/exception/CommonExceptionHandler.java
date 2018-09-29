package com.dytian.spring.dytianboot.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler  {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        HashMap<String, Object> response = new HashMap<>();
        response.put("code",9999);
        response.put("errmsg",e.getMessage());
        return response;
    }

}
