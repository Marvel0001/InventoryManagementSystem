package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionRecord {
    private Integer id;
    private Integer userId;
    private String username;
    private String actionName;
    private Long time;

    public ActionRecord(Integer id, Integer userId, String username, String actionName, Long time) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.actionName = actionName;
        this.time = time;
    }

    public ActionRecord() {
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("userId", userId);
        result.put("username", username);
        result.put("actionName", actionName);
        result.put("time", simpleDateFormat.format(date));
        return result.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
