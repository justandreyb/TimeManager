package com.bsuir.task_manager.controller.exception.user;

import com.bsuir.task_manager.controller.exception.NotFoundControllerException;

public class UserNotFoundControllerException extends NotFoundControllerException {
    public UserNotFoundControllerException() {
        super();
    }

    public UserNotFoundControllerException(String message) {
        super(message);
    }

    public UserNotFoundControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundControllerException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
