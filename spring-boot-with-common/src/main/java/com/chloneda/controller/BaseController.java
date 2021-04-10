package com.chloneda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author chloneda
 * @description: Controller接口的基类, 规范统一返回内容, 并可以进行全局异常处理
 * <p>
 * ControllerAdvice注解用于拦截全局的Controller的异常,
 * 将作用在所有注解了@RequestMapping的控制器的方法上
 */
@ControllerAdvice
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final <T> ResponseEntity<T> ok(T object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    protected final <T> ResponseEntity<T> ok(T object, HttpHeaders headers) {
        return new ResponseEntity<>(object, headers, HttpStatus.OK);
    }

    protected final ResponseEntity<Void> v() {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * 全局异常处理,value属性可以过滤拦截条件，此处拦截所有的Exception,
     * 可以通过value处理特定异常，比如： NullPointerException
     *
     * @param request
     * @param throwable
     * @return
     * @ResponseBody 注解 表示抛出的异常以 Rest 的方式返回，这时就系统就不会指向到错误页面 error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    protected final ResponseEntity globalExceptionHandler(HttpServletRequest request, Throwable throwable) {
        logger.error("{} exception: {}", this.getClass().getSimpleName(), throwable.getMessage());
        return new ResponseEntity(new BaseErrorInfo(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                throwable.getClass().getName(),
                throwable.getMessage(),
                new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理Controller层面的异常,返回指定error页面
     *
     * @param request
     * @param throwable
     * @param model
     * @return
     */
    @ExceptionHandler(value = Error.class)
    protected final String defaultExceptionHandler(HttpServletRequest request, Throwable throwable, Model model) {
        logger.error("{} error: {}",this.getClass().getSimpleName(), throwable.getMessage());
        model.addAttribute("code", 404);
        model.addAttribute("url", request.getRequestURL().toString());
        model.addAttribute("message", throwable.getMessage());
        model.addAttribute("date", new Date());
        return "error";
    }

    private class BaseErrorInfo {

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
