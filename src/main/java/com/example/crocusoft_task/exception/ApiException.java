package com.example.crocusoft_task.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
