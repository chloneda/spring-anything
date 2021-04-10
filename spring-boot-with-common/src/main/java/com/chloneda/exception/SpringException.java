package com.chloneda.exception;

/**
 * @author chloneda
 * @description:
 */
public class SpringException extends Exception{

    private static final long serialVersionUID = 1L;

    public SpringException() {
        super();
    }

    public SpringException(String message) {
        super(message);
    }

    public SpringException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringException(Throwable cause) {
        super(cause);
    }

    protected SpringException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
