package com.wenan.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenan.admin.common.R;
import com.wenan.admin.entity.BlogInfo;
import com.wenan.admin.entity.vo.BlogVo;
import com.wenan.admin.entity.vo.UpdateBlogVo;
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
     *  根据id删除博客
     */
    @ApiOperation(value = "删除博客")
    @PostMapping("delBlog/{id}")
    public R delBlog(@PathVariable("id") String id) {
        infoService.delBlog(id);
        return R.ok();
    }

    /**
     *  修改博客
     */
    @ApiOperation(value = "修改博客")
    @PostMapping("updateBlog")
    public R updateBlog(@RequestBody UpdateBlogVo UpdateBlogVo) {
        infoService.updateBlog(UpdateBlogVo);
        return R.ok();
    }

    /**
     *  分页展示博客
     */
    @ApiOperation(value = "分页展示博客列表")
    @PostMapping("listBlog/{page}/{limit}")
    public R listBlog(@PathVariable("page") Integer page,
                      @PathVariable("limit") Integer limit) {
        Page<BlogInfo> listBlog=infoService.listBlog(page,limit);
        return R.ok().data("listBlog", listBlog);
    }
}

