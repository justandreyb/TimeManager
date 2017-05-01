package com.bsuir.task_manager.controller.exception.task;

import com.bsuir.task_manager.controller.exception.NotFoundControllerException;

public class TaskNotFoundControllerException extends NotFoundControllerException {
    public TaskNotFoundControllerException() {
        super();
    }

    public TaskNotFoundControllerException(String message) {
        super(message);
    }

    public TaskNotFoundControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskNotFoundControllerException(Throwable cause) {
        super(cause);
    }

    protected TaskNotFoundControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
