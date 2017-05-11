package com.bsuir.task_manager.security.service.exception;

public class ForbiddenSecurityException extends AuthenticationException {
    public ForbiddenSecurityException() {
    }

    public ForbiddenSecurityException(String message) {
        super(message);
    }

    public ForbiddenSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenSecurityException(Throwable cause) {
        super(cause);
    }

    public ForbiddenSecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
