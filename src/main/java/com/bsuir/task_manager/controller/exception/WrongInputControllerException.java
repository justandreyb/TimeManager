package com.bsuir.task_manager.controller.exception;

public class WrongInputControllerException extends ControllerException {
    public WrongInputControllerException() {
        super();
    }

    public WrongInputControllerException(String message) {
        super(message);
    }

    public WrongInputControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputControllerException(Throwable cause) {
        super(cause);
    }

    protected WrongInputControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
