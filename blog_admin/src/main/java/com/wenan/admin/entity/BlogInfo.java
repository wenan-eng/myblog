package com.wenan.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BlogInfo对象", description="")
public class BlogInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "博客id")
    @TableId(value = "blog_id", type = IdType.ID_WORKER_STR)
    private String blogId;

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

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "是否可用")
    private Integer isvalid;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
