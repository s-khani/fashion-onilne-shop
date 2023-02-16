package com.example.FashionOnlineShop.exception;

public class isAlreadyExistedException extends RuntimeException{
    public isAlreadyExistedException() {
    }

    public isAlreadyExistedException(String message) {
        super(message);
    }

    public isAlreadyExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public isAlreadyExistedException(Throwable cause) {
        super(cause);
    }

    public isAlreadyExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
