package com.wenan.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.lang.reflect.Field;
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
@ApiModel(value="BlogContent对象", description="")
public class BlogContent implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "blog_content_id", type = IdType.ID_WORKER_STR)
    private String blogContentId;

    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "内容")
    private String blogContent;

    @ApiModelProperty(value = "图片id")
    private String contentImgId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "是否可用")
    private Integer isvalid;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
