package com.wenan.admin.controller;


import com.wenan.admin.common.R;
import com.wenan.admin.entity.BlogUser;
import com.wenan.admin.service.BlogUserService;
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
@Api(description = "用户管理")
@RestController
@RequestMapping("/admin/user")
public class BlogUserController {
    @Resource
    private BlogUserService userService;

    /**
     * 新增用户
     * @param user 传入用户对象
     * @return 返回结果
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("addUser")
    public R addUser(@RequestBody BlogUser user) {
        boolean save = userService.save(user);
        // todo 密码加密，验证权限等功能，需要完善
        if (!save) {
            return R.error().data("20001","用户新增失败");
        }
        return R.ok().data("20000","用户新增成功");
    }
    // 2 修改用户
    @ApiOperation(value = "根据id修改用户")
    @PostMapping("updateUser")
    public R updateUser(@RequestBody BlogUser user) {
        // 1 根据id查找到对应的用户
        BlogUser blogUser = userService.getById(user.getUserId());
        // 2 修改用户信息
        blogUser.setUsername(user.getUsername());
        blogUser.setPassword(user.getPassword());
        blogUser.setUserDes(user.getUserDes());
        // 3 保存修改后的用户信息
        boolean save = userService.updateById(blogUser);
        if (!save) {
            return R.error().data("20001","用户修改失败");
        }
        return R.ok().data("20000","用户修改成功");
    }
    // 3 删除用户
    // 4 分页获取用户信息
}

