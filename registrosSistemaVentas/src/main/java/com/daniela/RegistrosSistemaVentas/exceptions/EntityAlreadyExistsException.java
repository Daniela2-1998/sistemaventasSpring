package com.daniela.RegistrosSistemaVentas.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{

    // Constructor

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
