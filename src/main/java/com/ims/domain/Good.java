package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Good {
    private int id;
    private String name;
    private String type;
    private Float value=-1f;
    private String supplier;
    private String customer;

    public Good(int id, String name, String type, Float value, String supplier, String customer) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.id = id;
        this.supplier = supplier;
        this.customer = customer;
    }

    public Good() {
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        JSONObject result =new JSONObject();
        result.put("name", name);
        result.put("type", type);
        result.put("value", value);
        result.put("id", id);
        result.put("supplier", supplier);
        result.put("customer", customer);
        return result.toJSONString();
    }
}
