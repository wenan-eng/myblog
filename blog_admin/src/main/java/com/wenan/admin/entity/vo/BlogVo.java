package com.wenan.admin.entity.vo;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：    BlogVo
 */
@Data
public class BlogVo {

    @NotNull
    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博客简介")
    private String blogDes;

    @ApiModelProperty(value = "博客分类")
    private String blogTypeId;

    @NotNull
    @ApiModelProperty(value = "作者id")
    private String userId;

}
