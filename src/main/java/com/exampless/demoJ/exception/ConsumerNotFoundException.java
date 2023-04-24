package com.exampless.demoJ.exception;

public class ConsumerNotFoundException extends  RuntimeException{
    public ConsumerNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}
