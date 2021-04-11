package com.chloneda.exception;

/**
 * @author chloneda
 * @description:
 */
public class SpringRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SpringRuntimeException() {
        super();
    }

    public SpringRuntimeException(String message) {
        super(message);
    }

    public SpringRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringRuntimeException(Throwable cause) {
        super(cause);
    }


    protected SpringRuntimeException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
