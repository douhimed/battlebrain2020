package org.sqli.staysafe.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.sqli.staysafe.utilities.exceptions.BusinessException;
import org.sqli.staysafe.utilities.response.ErrorResponse;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ErrorResponse> projectIdExceptionHandler(BusinessException ex){
        return new ResponseEntity<>(new ErrorResponse(ex.getCode(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
