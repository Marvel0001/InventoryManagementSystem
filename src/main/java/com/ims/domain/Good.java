package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Good {
    private int id;
    private String name;
    private String type;
    private float value;

    public Good(int id, String name, String type, float value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.id = id;
    }

    public Good() {
    }

    @Override
    public String toString() {
        JSONObject result =new JSONObject();
        result.put("name", name);
        result.put("type", type);
        result.put("value", value);
        result.put("id", id);
        return result.toJSONString();
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
}
