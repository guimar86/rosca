package com.kixikila.exception;

import java.util.Map;


public class RoscaException extends RuntimeException {

    public RoscaException(String message){
        super(message);
    }
    public Map<String,Object> validations;

}
