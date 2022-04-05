package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Storehouse {
    private Integer id;
    private String address;
    private Integer status;

    public Storehouse() {
    }

    public Storehouse(Integer id, String address, Integer status) {
        this.id = id;
        this.address = address;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("address", address);
        result.put("status", status);

        return result.toJSONString();
    }
}
