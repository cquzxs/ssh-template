package com.zxs.ssh.template.controller;

import com.zxs.ssh.template.model.UserModel;
import com.zxs.ssh.template.service.user.api.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project Name:ssh-template
 * File Name:UserController
 * Package Name:com.zxs.ssh.template.controller
 * Date:2018/12/11
 * Author:zengxueshan
 * Description:用户
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@RestController("userController")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    /**
     * 查询第一个用户
     *
     * @return 结果
     */
    @RequestMapping("user/query")
    public String queryUser(){
        String res = "";
        UserModel userModel = this.userService.queryModel();
        if(userModel != null){
            res = userModel.toString();
        }
        return res;
    }
}
