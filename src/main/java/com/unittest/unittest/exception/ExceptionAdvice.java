package com.unittest.unittest.exception;

import com.unittest.unittest.bean.ResultBean;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的异常处理切面类
 * Created by https://www.ixushu.com on 2017/5/18 0018.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice{
	protected static final Logger logger = Logger.getLogger(ExceptionAdvice.class);
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultBean handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    	logger.error("参数解析失败", e);
        return new ResultBean(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultBean handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    	logger.error("不支持当前请求方法", e);
        return new ResultBean(HttpStatus.METHOD_NOT_ALLOWED.value(),HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultBean handleHttpMediaTypeNotSupportedException(Exception e) {
    	logger.error("不支持当前媒体类型", e);
        return new ResultBean(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase());
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultBean handleException(Exception e) {
    	logger.error("服务运行异常", e);
        return new ResultBean(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
