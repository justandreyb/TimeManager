package com.bsuir.task_manager.dao.exception;

public class ExistsDAOException extends DAOException {
    public ExistsDAOException() {
        super();
    }

    public ExistsDAOException(String message) {
        super(message);
    }

    public ExistsDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsDAOException(Throwable cause) {
        super(cause);
    }

    protected ExistsDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
