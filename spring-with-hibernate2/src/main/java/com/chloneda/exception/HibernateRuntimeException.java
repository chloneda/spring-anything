package com.chloneda.exception;

/**
 * @author chloneda
 * @description:
 */
public class HibernateRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    /**
     * @param message
     * @param cause
     */
    public HibernateRuntimeException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public HibernateRuntimeException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public HibernateRuntimeException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
