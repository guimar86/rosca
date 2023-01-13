package com.kixikila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class RoscaExceptionAdvice{


    @ResponseBody
    @ExceptionHandler(RoscaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String,Object> RoscaExceptionHandler(RoscaException exception){

        return exception.validations;
    }
}
