package com.bsuir.task_manager.controller.exception.project;

import com.bsuir.task_manager.controller.exception.NotFoundControllerException;

public class ProjectNotFoundControllerException extends NotFoundControllerException {
    public ProjectNotFoundControllerException() {
        super();
    }

    public ProjectNotFoundControllerException(String message) {
        super(message);
    }

    public ProjectNotFoundControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotFoundControllerException(Throwable cause) {
        super(cause);
    }

    protected ProjectNotFoundControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
