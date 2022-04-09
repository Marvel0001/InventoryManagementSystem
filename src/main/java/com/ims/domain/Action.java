package com.ims.domain;

public class Action {
    private Integer id;
    private String keyword;
    private String name;
    private String permission;

    public Action(Integer id, String keyword, String name, String permission) {
        this.id = id;
        this.keyword = keyword;
        this.name = name;
        this.permission = permission;
    }

    public Action() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
