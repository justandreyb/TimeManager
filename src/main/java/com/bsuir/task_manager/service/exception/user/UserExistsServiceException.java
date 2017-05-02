package com.bsuir.task_manager.service.exception.user;

import com.bsuir.task_manager.service.exception.ExistsServiceException;

public class UserExistsServiceException extends ExistsServiceException {
    public UserExistsServiceException() {
        super();
    }

    public UserExistsServiceException(String message) {
        super(message);
    }

    public UserExistsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsServiceException(Throwable cause) {
        super(cause);
    }

    protected UserExistsServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
