package com.daniela.sistemaventas.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{

    // Constructor

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
