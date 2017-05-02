package com.bsuir.task_manager.service.exception.category;

import com.bsuir.task_manager.service.exception.ExistsServiceException;

public class CategoryExistsServiceException extends ExistsServiceException {
    public CategoryExistsServiceException() {
        super();
    }

    public CategoryExistsServiceException(String message) {
        super(message);
    }

    public CategoryExistsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryExistsServiceException(Throwable cause) {
        super(cause);
    }

    protected CategoryExistsServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
