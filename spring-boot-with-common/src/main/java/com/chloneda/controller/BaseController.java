package com.chloneda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author chloneda
 * @description: Controller接口的基类,并可以进行全局异常处理
 *
 * ControllerAdvice注解用于拦截全局的Controller的异常,
 * 将作用在所有注解了@RequestMapping的控制器的方法上
 */
@ControllerAdvice
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

    /**
     * 全局异常处理,value属性可以过滤拦截条件，此处拦截所有的Exception,
     * 可以通过value处理特定异常，比如： NullPointerException
     *
     * @param request
     * @param throwable
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    protected final BaseErrorInfo globalExceptionHandler(HttpServletRequest request, Throwable throwable) {
        logger.error("Controller error: {}", throwable);
        return new BaseErrorInfo(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                throwable.getClass().getName(),
                throwable.getMessage(),
                new Date());
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

}
