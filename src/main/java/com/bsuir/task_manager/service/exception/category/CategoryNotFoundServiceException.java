package com.bsuir.task_manager.service.exception.category;

import com.bsuir.task_manager.service.exception.NotFoundServiceException;

public class CategoryNotFoundServiceException extends NotFoundServiceException {
    public CategoryNotFoundServiceException() {
        super();
    }

    public CategoryNotFoundServiceException(String message) {
        super(message);
    }

    public CategoryNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundServiceException(Throwable cause) {
        super(cause);
    }

    protected CategoryNotFoundServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
