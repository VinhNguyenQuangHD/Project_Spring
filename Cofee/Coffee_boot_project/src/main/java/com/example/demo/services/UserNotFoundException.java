package com.example.demo.services;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException(String s) {
        super(s);
    }
}
