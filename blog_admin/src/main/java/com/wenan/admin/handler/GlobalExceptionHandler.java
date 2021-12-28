package com.wenan.admin.handler;

import com.wenan.admin.common.R;
import com.wenan.admin.exception.BlogException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：    GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 拦截自定义BlogException并返回
     */
    @ExceptionHandler(BlogException.class)
    @ResponseBody
    public R error(BlogException e) {
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("系统异常");
    }
}
