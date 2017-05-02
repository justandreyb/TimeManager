package com.bsuir.task_manager.service.exception.task;

import com.bsuir.task_manager.service.exception.NotFoundServiceException;

public class TaskNotFoundServiceException extends NotFoundServiceException {
    public TaskNotFoundServiceException() {
        super();
    }

    public TaskNotFoundServiceException(String message) {
        super(message);
    }

    public TaskNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskNotFoundServiceException(Throwable cause) {
        super(cause);
    }

    protected TaskNotFoundServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
