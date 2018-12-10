package com.zxs.ssh.template.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Project Name:ssh-template
 * File Name:UserModel
 * Package Name:com.zxs.ssh.template.model
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:用户
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Entity
@Table(name = "user", schema = "ssh_template")
public class UserModel {
    private String id;  //主键
    private String username;  //用户名
    private String password;  //密码


    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != null ? !id.equals(userModel.id) : userModel.id != null) return false;
        if (username != null ? !username.equals(userModel.username) : userModel.username != null) return false;
        return password != null ? password.equals(userModel.password) : userModel.password == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
