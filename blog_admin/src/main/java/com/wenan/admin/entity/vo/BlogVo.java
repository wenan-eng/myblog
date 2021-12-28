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

    @ApiModelProperty(value = "博客封面地址")
    private String blogImg;

    @NotNull
    @ApiModelProperty(value = "作者id")
    private String userId;

    @ApiModelProperty(value = "图片地址")
    private String contentImg;

    @ApiModelProperty(value = "图片描述")
    private String imgDes;
}
