package com.bsuir.task_manager.controller.exception.task;

import com.bsuir.task_manager.controller.exception.ExistsControllerException;

public class TaskExistsControllerException extends ExistsControllerException {
    public TaskExistsControllerException() {
        super();
    }

    public TaskExistsControllerException(String message) {
        super(message);
    }

    public TaskExistsControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskExistsControllerException(Throwable cause) {
        super(cause);
    }

    protected TaskExistsControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
