package com.ims.dao;

import com.ims.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    void addCustomer(Customer customer);

    List<Customer> selectCustomerById(Integer id);

    List<Customer> selectCustomerByCompany(String company);

    List<Customer> selectCustomerByPerson(String person);

    List<Customer> selectAllCustomer();

    void modifyCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
