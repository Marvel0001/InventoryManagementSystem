package com.ims.domain;

public class Customer {
    private String company;
    private String person;
    private String telephone;
    private String email;
    private String address;

    public Customer(String company, String person, String telephone, String email, String address) {
        this.company = company;
        this.person = person;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "company='" + company + '\'' +
                ", person='" + person + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
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
