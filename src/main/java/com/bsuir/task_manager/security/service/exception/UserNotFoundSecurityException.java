package com.bsuir.task_manager.security.service.exception;

public class UserNotFoundSecurityException extends AuthenticationException {
    public UserNotFoundSecurityException() {
        super();
    }

    public UserNotFoundSecurityException(String message) {
        super(message);
    }

    public UserNotFoundSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundSecurityException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundSecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
