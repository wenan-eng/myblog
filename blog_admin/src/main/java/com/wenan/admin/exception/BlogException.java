package com.wenan.admin.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：    BlogException
 */
@Data
public class BlogException extends RuntimeException {

    @ApiModelProperty(value = "异常状态码")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String msg;

    public BlogException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
