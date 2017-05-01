package com.bsuir.task_manager.controller.exception.category;

import com.bsuir.task_manager.controller.exception.ExistsControllerException;

public class CategoryExistsControllerException extends ExistsControllerException {
    public CategoryExistsControllerException() {
        super();
    }

    public CategoryExistsControllerException(String message) {
        super(message);
    }

    public CategoryExistsControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryExistsControllerException(Throwable cause) {
        super(cause);
    }

    protected CategoryExistsControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
