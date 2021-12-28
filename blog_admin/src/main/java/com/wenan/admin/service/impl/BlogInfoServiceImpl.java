package com.wenan.admin.service.impl;

import com.wenan.admin.entity.BlogContent;
import com.wenan.admin.entity.BlogInfo;
import com.wenan.admin.entity.vo.BlogVo;
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
}
