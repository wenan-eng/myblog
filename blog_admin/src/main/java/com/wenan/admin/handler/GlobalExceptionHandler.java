package com.wenan.admin.handler;

import com.wenan.admin.common.R;
import com.wenan.admin.exception.BlogException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 描述：    GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截自定义BlogException并返回

     */
    @ExceptionHandler(BlogException.class)
    public R error(BlogException e) {
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
