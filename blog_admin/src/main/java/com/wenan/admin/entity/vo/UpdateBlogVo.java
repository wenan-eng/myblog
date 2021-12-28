package com.wenan.admin.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：    BlogVo
 */
@Data
public class UpdateBlogVo {
    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博客简介")
    private String blogDes;

    @ApiModelProperty(value = "博客分类")
    private String blogTypeId;

    @ApiModelProperty(value = "内容")
    private String blogContent;

    @ApiModelProperty(value = "作者id")
    private String userId;


}
