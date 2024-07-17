package com.daniela.RegistrosSistemaVentas.exceptions;

public class EntityNotFoundException extends RuntimeException{

    // Constructor
    public EntityNotFoundException(String message) {
        super(message);
    }
}
