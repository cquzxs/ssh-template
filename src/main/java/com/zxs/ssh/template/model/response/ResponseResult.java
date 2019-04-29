package com.zxs.ssh.template.model.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name:log-analysis-platform
 * File Name:ResponseResult
 * Package Name:com.yk.parking.log.analysis.platform.model.response
 * Date:2018/7/24
 * Author:zhangju
 * Description:
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class ResponseResult {

    private int code;// 状态码
    private ResponseState state; // 状态名称
    private Map<String, Object> result;// 操作结果
    private String msg; // 响应信息

    public ResponseResult() {
        this.result = new HashMap<>();
    }

    public ResponseResult(int code, ResponseState state, Map<String, Object> result, String msg) {
        this.code = code;
        this.state = state;
        this.result = result;
        this.msg = msg;
    }

    public ResponseResult(int code, ResponseState state, List data, String msg) {
        this.result = new HashMap<>();
        this.code = code;
        this.state = state;
        result.put("data", data);
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseState getState() {
        return state;
    }

    public void setState(ResponseState state) {
        this.state = state;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public enum ResponseState {
        SUCCESS("success"),
        FAILURE("failure"),
        EXCEPTION("exception");
        private String state;

        ResponseState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

}
