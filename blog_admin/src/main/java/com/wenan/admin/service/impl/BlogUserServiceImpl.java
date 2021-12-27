package com.wenan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenan.admin.entity.BlogUser;
import com.wenan.admin.mapper.BlogUserMapper;
import com.wenan.admin.service.BlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

    @Override
    public Page<BlogUser>  listUser(Integer page, Integer limit) {
        // 1 获取分页对象
        Page<BlogUser> blogUserPage = new Page<>(page, limit);
        // 2 传入user对象查找,查找isvalid为0的用户信息
        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("isvalid", 0);
        baseMapper.selectPage(blogUserPage, blogUserQueryWrapper);
        return blogUserPage;
    }
}
