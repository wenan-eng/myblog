package com.wenan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenan.admin.entity.BlogContent;
import com.wenan.admin.entity.BlogInfo;
import com.wenan.admin.entity.vo.BlogVo;
import com.wenan.admin.entity.vo.UpdateBlogVo;
import com.wenan.admin.exception.BlogException;
import com.wenan.admin.mapper.BlogInfoMapper;
import com.wenan.admin.service.BlogContentService;
import com.wenan.admin.service.BlogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenan
 * @since 2021-12-27
 */
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo> implements BlogInfoService {
    @Resource
    private BlogContentService contentService;

    @Transactional
    @Override
    public void addBlog(BlogVo blogVo) {
        // 1 创建BlogInfo对象，插入Info信息，并获得BlogId
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setBlogTitle(blogVo.getBlogTitle());
        blogInfo.setBlogDes(blogVo.getBlogDes());
        blogInfo.setUserId(blogVo.getUserId());
        int insert = baseMapper.insert(blogInfo);
        if (insert < 1) {
            throw new BlogException(20001, "新增失败");
        }
        System.out.println(blogInfo);
        // 2 创建BlogContent对象，并插入BlogId，形成对应关系
        BlogContent blogContent = new BlogContent();
        blogContent.setBlogContent(blogVo.getBlogContent());
        blogContent.setBlogId(blogInfo.getBlogId());
        boolean save = contentService.save(blogContent);
        if (!save) {
            throw new BlogException(20001, "新增失败");
        }
    }

    @Transactional
    @Override
    public void delBlog(String id) {
        // 1 删除BlogContent
        QueryWrapper<BlogContent> contentQueryWrapper = new QueryWrapper<>();
        contentQueryWrapper.eq("blog_id", id);
        boolean remove = contentService.remove(contentQueryWrapper);
        if (!remove) {
            throw new BlogException(20001, "删除博文失败");
        }
        // 2 删除BlogInfo
        int delete = baseMapper.deleteById(id);
        if (delete!=1) {
            throw new BlogException(20001, "删除博客失败");
        }
    }

    @Transactional
    @Override
    public void updateBlog(UpdateBlogVo UpdateBlogVo) {
        // 1 修改BlogInfo
        String blogId = UpdateBlogVo.getBlogId();
        BlogInfo blogInfo = baseMapper.selectById(blogId);
        if (blogInfo == null) {
            throw new BlogException(2001, "博客不存在");
        }
        blogInfo.setBlogDes(UpdateBlogVo.getBlogDes());
        blogInfo.setBlogTitle(UpdateBlogVo.getBlogTitle());
        int update = baseMapper.updateById(blogInfo);
        if (update != 1) {
            throw new BlogException(200100, "修改失败");
        }
        // 2 修改BlogContent
        QueryWrapper<BlogContent> contentQueryWrapper = new QueryWrapper<>();
        contentQueryWrapper.eq("blog_id", blogId);
        BlogContent content = contentService.getOne(contentQueryWrapper);
        content.setBlogContent(UpdateBlogVo.getBlogContent());
        boolean save = contentService.update(content,contentQueryWrapper);
        if (!save) {
            throw new BlogException(20001, "修改失败");
        }
    }

    @Override
    public Page<BlogInfo> listBlog(Integer page, Integer limit) {
        Page<BlogInfo> infoPage = new Page<>(page,limit);
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isvalid", 0);
        baseMapper.selectPage(infoPage, queryWrapper);
        return infoPage;
    }
}
