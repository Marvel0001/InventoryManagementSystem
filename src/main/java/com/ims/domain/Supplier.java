package com.ims.domain;

import com.alibaba.fastjson.JSONObject;

public class Supplier {
    private Integer id;
    private String company;
    private String person;
    private String telephone;
    private String email;
    private String address;

    public Supplier(String company, String person, String telephone, String email, String address) {
        this.company = company;
        this.person = person;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public Supplier() {
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
