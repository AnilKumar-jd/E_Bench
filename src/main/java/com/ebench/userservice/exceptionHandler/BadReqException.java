package com.ebench.userservice.exceptionHandler;

public class BadReqException extends RuntimeException {
    public BadReqException(String message) { super(message); }

}