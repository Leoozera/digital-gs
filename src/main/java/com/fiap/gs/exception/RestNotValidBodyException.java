package com.fiap.gs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RestNotValidBodyException extends RuntimeException{
	
    public RestNotValidBodyException (String message){
        super(message);
    }
}
