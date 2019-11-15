package com.chloneda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author chloneda
 * @description: Controller接口的基础类
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final <T> ResponseEntity<T> ok(T object) {
        return new ResponseEntity<>(object, HttpStatus.MULTI_STATUS.OK);
    }

    protected final <T> ResponseEntity<T> ok(T object, HttpHeaders headers) {
        return new ResponseEntity<>(object,headers, HttpStatus.MULTI_STATUS.OK);
    }

    protected final ResponseEntity<Void> v() {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.MULTI_STATUS.OK);
    }

    private class BaseErrorInfo<T> {

        /**
         * 返回码
         */
        public int code;

        /**
         * 异常信息
         */
        public String exception;

        /**
         * 信息
         */
        public String message;

        /**
         * 日期
         */
        public Date date;

        public BaseErrorInfo(int code, String exception, String message, Date date) {
            this.code = code;
            this.exception = exception;
            this.message = message;
            this.date = date;
        }

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    protected final BaseErrorInfo baseExceptionHander(HttpServletRequest request, Throwable throwable) {
        logger.error("Controller error{}: ", throwable);
        return new BaseErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable.getClass().getName(), throwable.getMessage(), new Date());
    }

}
