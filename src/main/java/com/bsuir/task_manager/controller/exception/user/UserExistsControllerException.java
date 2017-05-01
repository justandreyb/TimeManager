package com.bsuir.task_manager.controller.exception.user;

import com.bsuir.task_manager.controller.exception.ExistsControllerException;

public class UserExistsControllerException extends ExistsControllerException {

    public UserExistsControllerException() {
        super();
    }

    public UserExistsControllerException(String message) {
        super(message);
    }

    public UserExistsControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsControllerException(Throwable cause) {
        super(cause);
    }

    protected UserExistsControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
