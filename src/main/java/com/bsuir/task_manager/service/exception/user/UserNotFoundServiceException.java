package com.bsuir.task_manager.service.exception.user;

import com.bsuir.task_manager.service.exception.NotFoundServiceException;

public class UserNotFoundServiceException extends NotFoundServiceException {
    public UserNotFoundServiceException() {
        super();
    }

    public UserNotFoundServiceException(String message) {
        super(message);
    }

    public UserNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundServiceException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
