package com.zxs.ssh.template.model.db;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-template
 * File Name:UserModel
 * Package Name:com.zxs.ssh.template.model.db
 * Date:2019/4/26
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "user", schema = "ssh_template")
public class UserModel {
    private long userId;
    private String username;
    private String password;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (userId != userModel.userId) return false;
        if (username != null ? !username.equals(userModel.username) : userModel.username != null) return false;
        if (password != null ? !password.equals(userModel.password) : userModel.password != null) return false;
        if (createTime != null ? !createTime.equals(userModel.createTime) : userModel.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(userModel.updateTime) : userModel.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
