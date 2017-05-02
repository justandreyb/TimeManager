package com.bsuir.task_manager.service.exception;

public class NotFoundServiceException extends ServiceException {
    public NotFoundServiceException() {
        super();
    }

    public NotFoundServiceException(String message) {
        super(message);
    }

    public NotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundServiceException(Throwable cause) {
        super(cause);
    }

    protected NotFoundServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
