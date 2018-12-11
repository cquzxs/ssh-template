package com.zxs.ssh.template.service.user.api;

import com.zxs.ssh.template.model.UserModel;

/**
 * Project Name:ssh-template
 * File Name:IUserService
 * Package Name:com.zxs.ssh.template.service.user.api
 * Date:2018/12/11
 * Author:zengxueshan
 * Description:用户
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IUserService {
    /**
     * 查询第一个用户
     */
    UserModel queryModel();
}
