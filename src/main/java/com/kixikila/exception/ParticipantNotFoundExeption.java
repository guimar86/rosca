package com.kixikila.exception;

public class ParticipantNotFoundExeption extends RuntimeException {

    public ParticipantNotFoundExeption(long id){

        super("Participant not found "+id);
    }
}
