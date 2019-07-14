package com.kodilla.ecommercee.exception;

public class WrongDataException extends RuntimeException{

    public WrongDataException(String message) {
        super(message);
    }
}
