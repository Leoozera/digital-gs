package com.fiap.gs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RestDuplicatedException extends RuntimeException{
    
    public RestDuplicatedException (String message){
        super(message);
    }
}