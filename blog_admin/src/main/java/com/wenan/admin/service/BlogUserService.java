package com.wenan.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenan.admin.entity.BlogUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
public interface BlogUserService extends IService<BlogUser> {

    Page<BlogUser> listUser(Integer page, Integer limit);
}
