package com.bsuir.task_manager.controller.exception;

public class ExistsControllerException extends ControllerException {
    public ExistsControllerException() {
        super();
    }

    public ExistsControllerException(String message) {
        super(message);
    }

    public ExistsControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsControllerException(Throwable cause) {
        super(cause);
    }

    protected ExistsControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
