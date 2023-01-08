package com.kixikila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ParticipantNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ParticipantNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String participantNotFoundHandler(ParticipantNotFoundExeption e) {
        return e.getMessage();
    }
}
