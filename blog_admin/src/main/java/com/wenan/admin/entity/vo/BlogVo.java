package com.wenan.admin.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：    BlogVo
 */
@Data
public class BlogVo {

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博客简介")
    private String blogDes;

    @ApiModelProperty(value = "博客分类")
    private String blogTypeId;

    @ApiModelProperty(value = "博客内容id")
    private String blogContentId;

    @ApiModelProperty(value = "博客图片地址")
    private String blogImg;

    @ApiModelProperty(value = "作者id")
    private String userId;
}
