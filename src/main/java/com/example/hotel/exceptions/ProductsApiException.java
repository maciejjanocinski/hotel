package com.example.hotel.exceptions;

public class ProductsApiException extends RuntimeException{
    public ProductsApiException(String message) {
        super(message);
    }
}
