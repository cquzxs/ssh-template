package com.zxs.ssh.template.controller;

import com.zxs.ssh.template.model.db.UserModel;
import com.zxs.ssh.template.model.response.ResponseResult;
import com.zxs.ssh.template.service.user.api.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
@RequestMapping("user")
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private IUserService userService;

    /**
     * #1 添加一个model   增+删+改+查=1+2+2+3=8
     *
     * @return 添加个数
     * @throws Exception 异常
     */
    @RequestMapping("add")
    public Object add() throws Exception{
        try{
            Object o = this.userService.add();
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #2 删除一个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    @RequestMapping("delete")
    public Object delete(@RequestParam(name = "modelId", defaultValue = "-1") long modelId) throws Exception{
        try{
            Object o = this.userService.delete(modelId);
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #3 删除多个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    @RequestMapping("deleteMany")
    public Object deleteMany() throws Exception{
        try{
            Object o = this.userService.deleteMany();
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #4 更新一个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @RequestMapping("update")
    public Object update(@RequestParam(name = "modelId", defaultValue = "-1") long modelId) throws Exception{
        try{
            Object o = this.userService.update(modelId);
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #5 更新多个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    @RequestMapping("updateMany")
    public Object updateMany() throws Exception{
        try{
            Object o = this.userService.updateMany();
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #6 查询一个model
     *
     * @return 查询结果
     * @throws Exception 异常
     */
    @RequestMapping("findOne")
    public Object findOne(@RequestParam(name = "modelId", defaultValue = "-1") long modelId) throws Exception{
        try{
            UserModel userModel = this.userService.findOne(modelId);
            Map<String, Object> map = new HashMap<>();
            map.put("data", userModel);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #7 分页查询
     *
     * @return 查询结果
     * @throws Exception 异常
     */
    @RequestMapping("findPage")
    public Object findPage(@RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) throws Exception{
        try{
            Map<String,Object> data = this.userService.findPage(pageIndex,pageSize);
            Map<String, Object> map = new HashMap<>();
            map.put("data", data);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
    /**
     * #8 查询结果总数
     *
     * @return 查询结果总数
     * @throws Exception 异常
     */
    @RequestMapping("getTotalCount")
    public Object getTotalCount() throws Exception{
        try{
            Object o = this.userService.getTotalCount();
            Map<String, Object> map = new HashMap<>();
            map.put("count", o);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "操作成功");
        }catch (Exception e){
            logger.error("操作异常", e);
            return new ResponseResult(1, ResponseResult.ResponseState.FAILURE,new HashMap<>(),e.getMessage());
        }
    }
}
