package org.soulcodeacademy.empresa.service.errors;

public class RecursoNaoEncontradoError extends RuntimeException{

    public RecursoNaoEncontradoError(String message){
        super(message);
    }
}
