package com.example.hotel.exceptions;

public class RecipeAlreadyAddedException extends RuntimeException{
    public RecipeAlreadyAddedException(String message) {
        super(message);
    }
}

