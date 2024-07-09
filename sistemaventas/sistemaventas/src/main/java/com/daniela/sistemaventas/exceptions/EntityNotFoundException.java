package com.daniela.sistemaventas.exceptions;

public class EntityNotFoundException extends RuntimeException{

    // Constructor
    public EntityNotFoundException(String message) {
        super(message);
    }
}
