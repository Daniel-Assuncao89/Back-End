package org.soulcodeacademy.empresa.service.errors;

public class ParametrosInsuficientesError extends RuntimeException{

    public ParametrosInsuficientesError(String message) {
        super(message);
    }
}
