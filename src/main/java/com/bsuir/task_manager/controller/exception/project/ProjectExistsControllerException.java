package com.bsuir.task_manager.controller.exception.project;

import com.bsuir.task_manager.controller.exception.ExistsControllerException;

public class ProjectExistsControllerException extends ExistsControllerException {
    public ProjectExistsControllerException() {
        super();
    }

    public ProjectExistsControllerException(String message) {
        super(message);
    }

    public ProjectExistsControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectExistsControllerException(Throwable cause) {
        super(cause);
    }

    protected ProjectExistsControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
