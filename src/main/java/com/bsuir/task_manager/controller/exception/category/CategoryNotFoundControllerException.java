package com.bsuir.task_manager.controller.exception.category;

import com.bsuir.task_manager.controller.exception.NotFoundControllerException;

public class CategoryNotFoundControllerException extends NotFoundControllerException {
    public CategoryNotFoundControllerException() {
        super();
    }

    public CategoryNotFoundControllerException(String message) {
        super(message);
    }

    public CategoryNotFoundControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundControllerException(Throwable cause) {
        super(cause);
    }

    protected CategoryNotFoundControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
