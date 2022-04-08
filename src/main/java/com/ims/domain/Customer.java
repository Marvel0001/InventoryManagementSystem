package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;


public class Customer {
    private Integer id;
    private String company;
    private String person;
    private String telephone;
    private String email;
    private String address;
    private String pre_order_goods;
    private String pre_order_goods_id;

    public Customer(String company, String person, String telephone, String email, String address, String pre_order_goods, String pre_order_goods_id) {
        this.company = company;
        this.person = person;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.pre_order_goods = pre_order_goods;
        this.pre_order_goods_id = pre_order_goods_id;
    }

    public Customer() {
    }

    public String getPre_order_goods_id() {
        return pre_order_goods_id;
    }

    public void setPre_order_goods_id(String pre_order_goods_id) {
        this.pre_order_goods_id = pre_order_goods_id;
    }

    public String getPre_order_goods() {
        return pre_order_goods;
    }

    public void setPre_order_goods(String pre_order_goods) {
        this.pre_order_goods = pre_order_goods;
    }

    @Override
    public String toString() {
        JSONObject result = new JSONObject();
        result.put("id", id);
        result.put("company", company);
        result.put("person", person);
        result.put("telephone", telephone);
        result.put("email", email);
        result.put("address", address);
        result.put("pre_order_goods", pre_order_goods);
        return result.toJSONString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
