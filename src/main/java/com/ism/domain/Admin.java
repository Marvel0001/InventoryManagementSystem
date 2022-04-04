package com.ism.domain;

public class Admin {
    private Integer id;

    private String name;

    private String sex;

    private String telephone;

    private String address;

    private Integer storehouseId;

    private Integer role;

    public Admin() {
    }

    public Admin(String name, String sex, String telephone, String address, Integer storehouseId, Integer role) {
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.address = address;
        this.storehouseId = storehouseId;
        this.role = role;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
