package com.gzhipin.globalHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleCommonException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("status", 400);
        map.put("msg", e.getMessage());
        return map;
    }

}
