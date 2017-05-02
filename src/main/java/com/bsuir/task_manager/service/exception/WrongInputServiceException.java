package com.bsuir.task_manager.service.exception;

public class WrongInputServiceException extends ServiceException {
    public WrongInputServiceException() {
        super();
    }

    public WrongInputServiceException(String message) {
        super(message);
    }

    public WrongInputServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputServiceException(Throwable cause) {
        super(cause);
    }

    protected WrongInputServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
