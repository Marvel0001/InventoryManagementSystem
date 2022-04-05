package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Storage {

    private Integer goodId;
    private String goodName;
    private String goodType;
    private Double goodValue;
    private Integer storehouseId;
    private Integer number;

    @Override
    public String toString() {
        JSONObject result = new JSONObject();
        result.put("goodId", goodId);
        result.put("goodName", goodName);
        result.put("goodType", goodType);
        result.put("goodValue", goodValue);
        result.put("storehouseId", storehouseId);
        result.put("number", number);
        return result.toJSONString();
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public Double getGoodValue() {
        return goodValue;
    }

    public void setGoodValue(Double goodValue) {
        this.goodValue = goodValue;
    }

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

