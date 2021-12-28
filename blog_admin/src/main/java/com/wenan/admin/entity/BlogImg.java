package com.wenan.admin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="BlogImg对象", description="")
public class BlogImg implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "content_img_id", type = IdType.ID_WORKER_STR)
    private String contentImgId;

    private String contentImg;

    private String imgDes;

    @ApiModelProperty(value = "博客内容id")
    private String blogContentId;

    @TableField(fill = FieldFill.INSERT)
    private Integer isvalid;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
