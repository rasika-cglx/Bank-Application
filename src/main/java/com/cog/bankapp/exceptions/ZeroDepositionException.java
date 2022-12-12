package com.cog.bankapp.exceptions;

public class ZeroDepositionException extends  RuntimeException {
    public ZeroDepositionException(String message) {
        super(message);
    }
}
