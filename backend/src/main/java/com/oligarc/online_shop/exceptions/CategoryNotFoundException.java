package com.oligarc.online_shop.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message){
        super(message);
    }
}
