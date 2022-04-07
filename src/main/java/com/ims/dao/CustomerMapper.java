package com.ims.dao;

import com.ims.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerMapper {
    void addCustomer(Customer customer);

    ArrayList<String> selectAllCustomerName();

    ArrayList<Customer> selectCustomerById(Integer id);

    ArrayList<Customer> selectCustomerByCompany(String company);

    ArrayList<Customer> selectCustomerByPerson(String person);

    ArrayList<Customer> selectAllCustomer();

    void modifyCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
