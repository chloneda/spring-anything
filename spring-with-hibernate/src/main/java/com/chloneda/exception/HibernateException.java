package com.chloneda.exception;

/**
 * @Created by chloneda
 * @Description:
 */
public class HibernateException extends Exception{

    private static final long serialVersionUID = 1L;

    public HibernateException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public HibernateException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public HibernateException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
