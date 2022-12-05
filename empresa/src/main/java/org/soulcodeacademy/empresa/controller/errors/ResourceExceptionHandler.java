package org.soulcodeacademy.empresa.controller.errors;

import org.soulcodeacademy.empresa.service.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.service.errors.RecursoNaoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.authentication.BadCredentialsException;

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

    @ExceptionHandler(ParametrosInsuficientesError.class)
    public ResponseEntity<CustomErrorResponse> parametrosInsuficientesError(ParametrosInsuficientesError erro , HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(erro.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> badCredentialsException(BadCredentialsException erro, HttpServletRequest request){
       CustomErrorResponse response = new CustomErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.FORBIDDEN.value()); // 403 codigo
        response.setMessage("Email/senha invalidos");
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> methodArgumentNotValid(MethodArgumentNotValidException erro, HttpServletRequest request){
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setFieldErrorList(erro.getFieldErrors());
        response.setPath(request.getRequestURI());

        System.out.println(erro.getFieldErrors());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
//    Outra forma de mostrar o erro do MethodArgumentNotValidException
//    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException errors) {
//        Map<String, Object> errorMap = new HashMap<String, Object>();
//        errorMap.put("hasErrors", "true");
//        errorMap.put("developerMessage", "There are validation issues, please provide valid inputs");
//        errorMap.put("userMessage", "Please provide valid inputs");
//        errorMap.put("moreInfo", errors.getMessage());
//        errorMap.put("errorCode", HttpStatus.BAD_REQUEST);
//        errors.printStackTrace();
//        for (FieldError error : errors.getBindingResult().getFieldErrors()) {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        }
//        return new ResponseEntity<Map<String, Object>>(errorMap, HttpStatus.BAD_REQUEST);
//    }
