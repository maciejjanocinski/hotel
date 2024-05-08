package com.example.hotel.exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
}
