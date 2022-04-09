package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Admin {
    private Integer id;

    private String name;

    private String sex;

    private String telephone;

    private String address;

    private Integer storehouseId;

    private String role;

    private String password;

    @Override
    public String toString() {
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("name", name);
        result.put("sex", sex);
        result.put("telephone", telephone);
        result.put("address", address);
        result.put("storehouseId", storehouseId);
        result.put("role", role);
        result.put("password", password);
        return result.toJSONString();
    }

    public Admin() {
    }

    public Admin(String name, String sex, String telephone, String address, Integer storehouseId, String role, String password) {
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.address = address;
        this.storehouseId = storehouseId;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
