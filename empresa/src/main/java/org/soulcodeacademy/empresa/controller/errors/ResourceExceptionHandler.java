package org.soulcodeacademy.empresa.controller.errors;

import org.soulcodeacademy.empresa.service.errors.RecursoNaoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoError.class)
    public ResponseEntity<CustomErrorResponse> recursoNaoEncontradoError(RecursoNaoEncontradoError erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now()); // Data e hora do erro
        response.setStatus(HttpStatus.NOT_FOUND.value()); // Define como 404 o código de status
        response.setMessage(erro.getMessage()); //A mensagem de erro vinda do service
        response.setPath(request.getRequestURI()); // Qual endpoint ocorreu a requisição

        // Retorna o objeto com os dados e codigo 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<CustomErrorResponse> badCredentialsException(BadCredentialsException erro, HttpServletRequest request){
//        CustomErrorResponse response = new CustomErrorResponse();
//
//        response.setTimestamp(LocalDateTime.now());
//        response.setStatus(HttpStatus.FORBIDDEN.value()); // 403 codigo
//        response.setMessage("Email/senha invalidos");
//        response.setPath(request.getRequestURI());
//
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
//    }
}
