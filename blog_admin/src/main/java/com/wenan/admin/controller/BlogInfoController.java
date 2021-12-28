package com.wenan.admin.controller;


import com.wenan.admin.common.R;
import com.wenan.admin.entity.BlogInfo;
import com.wenan.admin.entity.vo.BlogVo;
import com.wenan.admin.exception.BlogException;
import com.wenan.admin.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public R addBlog(@RequestBody BlogVo BlogVo) {
        infoService.addBlog(BlogVo);
        return R.ok();
    }


    /**
     *  删除博客
     */
    @ApiOperation(value = "删除博客")
    @PostMapping("delBlog/{id}")
    public R delBlog(@PathVariable("id") String id) {
        // 1 根据id查找对应博客信息
        BlogInfo blogInfo = infoService.getById(id);
        if (blogInfo == null) {
            throw new BlogException(20003, "博客不存在");
        }
        // 2 将博客的isvalid修改为1
        blogInfo.setIsvalid(1);
        boolean save = infoService.save(blogInfo);
        if (!save) {
            throw new BlogException(20002, "删除失败");
        }
        return R.ok();
    }

    /**
     *  修改博客
     */

    /**
     *  分页展示博客
     */
}

