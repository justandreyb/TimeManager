package com.bsuir.task_manager.security.service.exception;

public class PasswordDoesntMatchSecurityException extends AuthenticationException {
    public PasswordDoesntMatchSecurityException() {
    }

    public PasswordDoesntMatchSecurityException(String message) {
        super(message);
    }

    public PasswordDoesntMatchSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordDoesntMatchSecurityException(Throwable cause) {
        super(cause);
    }

    public PasswordDoesntMatchSecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
