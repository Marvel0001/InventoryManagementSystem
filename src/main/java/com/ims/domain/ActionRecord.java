package com.ims.domain;

public class ActionRecord {
    private Integer id;
    private Integer userId;
    private String username;
    private String actionName;
    private Double time;

    public ActionRecord(Integer id, Integer userId, String username, String actionName, Double time) {
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
        return "ActionRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", actionName='" + actionName + '\'' +
                ", time=" + time +
                '}';
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

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
