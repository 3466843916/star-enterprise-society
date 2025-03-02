package com.sxpi.common.exception;


import com.sxpi.common.result.Result;
import com.sxpi.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public Result<Object> error(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }


    @ExceptionHandler({AccessDeniedException.class})
    public Result<Object> error(AccessDeniedException e) {
        // e.printStackTrace();
        return Result.build(e.getMessage(), ResultCodeEnum.SC_UNAUTHORIZED);
    }

    /**
     * 自定义异常处理方法
     */
    @ExceptionHandler(ProjectException.class)
    public Result<Object> error(ProjectException e) {
        return Result.build(null, e.getCode(), e.getMessage());
    }
}
