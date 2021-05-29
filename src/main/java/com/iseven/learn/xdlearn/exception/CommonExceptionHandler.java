package com.iseven.learn.xdlearn.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iseven.learn.xdlearn.util.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常处理
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    Object commonException(Exception e, HttpServletRequest request) throws JsonProcessingException {
        //打印引起错误的入参
        ObjectMapper objectMapper = new ObjectMapper();
        logger.error("请求url:{},请求入参:{}", request.getRequestURL(), objectMapper.writeValueAsString(request.getParameterMap()));
        e.printStackTrace();
        return ResultData.error(e.getMessage());
    }
}
