package com.proyecto.todo1.kardex.util;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(String message, Throwable cause){
        super(message,cause);
    }
}
