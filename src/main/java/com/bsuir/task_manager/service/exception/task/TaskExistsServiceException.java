package com.bsuir.task_manager.service.exception.task;

import com.bsuir.task_manager.service.exception.ExistsServiceException;

public class TaskExistsServiceException extends ExistsServiceException {
    public TaskExistsServiceException() {
        super();
    }

    public TaskExistsServiceException(String message) {
        super(message);
    }

    public TaskExistsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskExistsServiceException(Throwable cause) {
        super(cause);
    }

    protected TaskExistsServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
