package com.cog.bankapp.exceptions;

public class InsufficientInitialBalanceException extends RuntimeException{
    public InsufficientInitialBalanceException(String message) {
        super(message);
    }
}
