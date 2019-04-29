package com.zxs.ssh.template.service.user.impl;

import com.zxs.ssh.template.dao.common.api.ICommonDao;
import com.zxs.ssh.template.dao.user.api.IUserDao;
import com.zxs.ssh.template.model.db.UserModel;
import com.zxs.ssh.template.service.user.api.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class UserServiceImpl implements IUserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    @Resource(name = "userDao")
    private IUserDao userDao;


    /**
     * #1 添加一个model  增+删+改+查=1+2+2+3=8
     *
     * @return 添加个数
     * @throws Exception 异常
     */
    @Override
    public Object add() throws Exception {
        return this.userDao.add();
    }

    /**
     * #2 删除一个model
     *
     * @param modelId modelId
     * @return 删除个数
     * @throws Exception 异常
     */
    @Override
    public Object delete(long modelId) throws Exception {
        return this.userDao.delete(modelId);
    }

    /**
     * #3 删除多个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    @Override
    public Object deleteMany() throws Exception {
        return this.userDao.deleteMany();
    }

    /**
     * #4 更新一个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @Override
    public Object update(long modelId) throws Exception {
        return this.userDao.update(modelId);
    }

    /**
     * #5 更新多个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @Override
    public Object updateMany() throws Exception {
        return this.userDao.updateMany();
    }

    /**
     * #6 查询一个model
     *
     * @return 查询结果
     * @throws Exception 异常
     */
    @Override
    public UserModel findOne(long modelId) throws Exception {
        return this.userDao.findOne(modelId);
    }

    /**
     * #7 分页查询
     *
     * @param pageIndex 页码
     * @param pageSize  页面大小
     * @return 查询结果
     * @throws Exception 异常
     */
    @Override
    public Map<String, Object> findPage(int pageIndex, int pageSize) throws Exception {
        List<UserModel> list = this.userDao.findPage(pageIndex, pageSize);
        long total = this.userDao.getTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("data",list);
        map.put("pageIndex", pageIndex);
        map.put("pageSize", pageSize);
        map.put("pageCount", total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
        map.put("totalCount", total);
        return map;
    }

    /**
     * #8 查询结果总数
     *
     * @return 查询结果总数
     * @throws Exception 异常
     */
    @Override
    public long getTotalCount() throws Exception {
        return this.userDao.getTotalCount();
    }
}
