package com.bsuir.task_manager.controller.exception;

public class NotFoundControllerException extends ControllerException {
    public NotFoundControllerException() {
        super();
    }

    public NotFoundControllerException(String message) {
        super(message);
    }

    public NotFoundControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundControllerException(Throwable cause) {
        super(cause);
    }

    protected NotFoundControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
