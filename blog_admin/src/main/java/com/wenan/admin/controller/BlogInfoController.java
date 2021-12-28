package com.wenan.admin.controller;


import com.wenan.admin.common.R;
import com.wenan.admin.entity.BlogInfo;
import com.wenan.admin.exception.BlogException;
import com.wenan.admin.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
@Api(description = "博客信息")
@RestController
@RequestMapping("/admin/info")
public class BlogInfoController {
    @Resource
    private BlogInfoService infoService;

    /**
     * 新增博客
     */
    @ApiOperation(value = "新增博客")
    @PostMapping("addBlog")
    public R addBlog(@RequestBody BlogInfo blogInfo) {
        boolean save = infoService.save(blogInfo);
        if (!save) {
            throw new BlogException(20002, "保存失败");
        }
        return R.ok();
    }


    /**
     *  删除博客
     */

    /**
     *  修改博客
     */

    /**
     *  分页展示博客
     */
}

