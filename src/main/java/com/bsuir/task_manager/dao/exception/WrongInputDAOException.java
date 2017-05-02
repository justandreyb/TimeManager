package com.bsuir.task_manager.dao.exception;

public class WrongInputDAOException extends DAOException {
    public WrongInputDAOException() {
        super();
    }

    public WrongInputDAOException(String message) {
        super(message);
    }

    public WrongInputDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputDAOException(Throwable cause) {
        super(cause);
    }

    protected WrongInputDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
