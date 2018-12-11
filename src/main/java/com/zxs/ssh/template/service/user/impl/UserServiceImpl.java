package com.zxs.ssh.template.service.user.impl;

import com.zxs.ssh.template.dao.common.api.ICommonDao;
import com.zxs.ssh.template.model.UserModel;
import com.zxs.ssh.template.service.user.api.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project Name:ssh-template
 * File Name:UserServiceImpl
 * Package Name:com.zxs.ssh.template.service.user.impl
 * Date:2018/12/11
 * Author:zengxueshan
 * Description:用户
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询第一个用户
     */
    @Override
    public UserModel queryModel() {
        UserModel res = null;
        List<UserModel> userModels = this.commonDao.queryAll(UserModel.class);
        if(userModels != null && !userModels.isEmpty()){
            res =  userModels.get(0);
        }
        return res;
    }
}
