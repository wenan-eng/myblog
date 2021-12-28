package com.wenan.admin.controller.front;

import com.wenan.admin.common.R;
import com.wenan.admin.controller.BlogUserController;
import com.wenan.admin.entity.BlogUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 描述：    UserApi
 */
@Api(description = "前台用户管理接口")
@RequestMapping("user")
public class UserApi {

    @Resource
    private BlogUserController userController;

    @ApiOperation(value = "用户注册")
    @PostMapping("registry")
    public R login(@RequestBody BlogUser user) {
        return userController.addUser(user);
    }

    //todo 用户登录，使用spring security实现
}
