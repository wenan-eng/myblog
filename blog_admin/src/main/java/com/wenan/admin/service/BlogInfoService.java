package com.wenan.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenan.admin.entity.BlogInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenan.admin.entity.vo.BlogVo;
import com.wenan.admin.entity.vo.UpdateBlogVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
public interface BlogInfoService extends IService<BlogInfo> {

    void addBlog(BlogVo blogVo);

    void delBlog(String id);

    void updateBlog(UpdateBlogVo blogVo);

    Page<BlogInfo> listBlog(Integer page, Integer limit);
}
