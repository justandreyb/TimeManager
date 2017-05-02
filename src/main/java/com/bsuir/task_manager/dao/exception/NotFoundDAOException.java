package com.bsuir.task_manager.dao.exception;

public class NotFoundDAOException extends DAOException {
    public NotFoundDAOException() {
        super();
    }

    public NotFoundDAOException(String message) {
        super(message);
    }

    public NotFoundDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundDAOException(Throwable cause) {
        super(cause);
    }

    protected NotFoundDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
