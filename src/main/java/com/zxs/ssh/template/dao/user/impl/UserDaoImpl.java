package com.zxs.ssh.template.dao.user.impl;

import com.zxs.ssh.template.dao.common.api.ICommonDao;
import com.zxs.ssh.template.dao.user.api.IUserDao;
import com.zxs.ssh.template.model.db.UserModel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * Project Name:ssh-template
 * File Name:UserDaoImpl
 * Package Name:com.zxs.ssh.template.dao.user.impl
 * Date:2019/4/26
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl implements IUserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * #1 添加一个model
     *
     * @return 添加个数
     * @throws Exception 异常
     */
    @Override
    public Object add() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUsername("test");
        userModel.setPassword("123456");
        userModel.setCreateTime(Timestamp.from(Instant.now()));
        userModel.setUpdateTime(Timestamp.from(Instant.now()));
        if (this.commonDao.save(userModel)) {
            return 1;
        }
        return 0;
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
        String hql = "delete from UserModel model where model.userId = " + modelId;
        return hqlUpdateOrDelete(hql);
    }

    /**
     * 执行更新或删除hql
     *
     * @param hql hql
     * @return 影响的行数
     * @throws Exception 异常
     */
    private long hqlUpdateOrDelete(String hql) throws Exception {
        try {
            Session session = this.commonDao.getSession();
            Query query = session.createQuery(hql);
            long count = query.executeUpdate();
            session.clear();
            return count;
        } catch (Exception e) {
            logger.error("更新或删除失败", e);
        }
        return 0;
    }

    /**
     * #3 删除多个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    @Override
    public Object deleteMany() throws Exception {
        long expireDay = 5;//删除5天前的记录
        Timestamp limitTime = getLimitTimestamp(expireDay);
        String hql = "delete from UserModel model where model.createTime < '" + limitTime + "'";
        return hqlUpdateOrDelete(hql);
    }

    /**
     * 获取截止时间
     * 比如：现在2019-04-29 10:31:29； 过期时间为1，即删除1天前的记录；截止时间为2019-04-29 00:00:00
     *
     * @param expireDay 过期时间
     * @return 截止时间
     */
    private Timestamp getLimitTimestamp(long expireDay) {
        long limitTime = System.currentTimeMillis() - (expireDay - 1) * 24 * 60 * 60 * 1000;
        Timestamp time = new Timestamp(limitTime);
        time = Timestamp.valueOf(time.toString().substring(0, 10) + " 00:00:00");
        return time;
    }

    /**
     * #4 更新一个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @Override
    public Object update(long modelId) throws Exception {
        UserModel userModel = this.findOne(modelId);
        if (userModel == null) {
            throw new Exception("用户信息不存在");
        }
        userModel.setPassword("1234567");
        userModel.setUpdateTime(Timestamp.from(Instant.now()));
        if (this.commonDao.update(userModel)) {
            return 1;
        }
        return 0;
    }

    /**
     * #5 更新多个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @Override
    public Object updateMany() throws Exception {
        String hql = "update UserModel model set model.updateTime = '" + Timestamp.from(Instant.now()) + "' " +
                " where model.createTime < '" + Timestamp.from(Instant.now()) + "'";
        return hqlUpdateOrDelete(hql);
    }

    /**
     * #6 查询一个model
     *
     * @return 查询结果
     * @throws Exception 异常
     */
    @Override
    public UserModel findOne(long modelId) throws Exception {
        String condition = "model.userId = " + modelId;
        return this.commonDao.queryModel(condition, UserModel.class);
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
    public List<UserModel> findPage(int pageIndex, int pageSize) throws Exception {
        return this.commonDao.queryModels((pageIndex - 1) * pageSize, pageSize, "from UserModel model", UserModel.class);
    }

    /**
     * #8 查询结果总数
     *
     * @return 查询结果总数
     * @throws Exception 异常
     */
    @Override
    public long getTotalCount() throws Exception {
        return this.commonDao.queryTotalCount(null, UserModel.class);
    }
}
