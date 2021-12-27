package com.wenan.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="BlogType对象", description="")
public class BlogType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "blog_type_id", type = IdType.ID_WORKER_STR)
    private String blogTypeId;

    private String blogType;

    private Integer isvalid;

    private String typeDes;

    private Date createTime;

    private Date updateTime;


}
