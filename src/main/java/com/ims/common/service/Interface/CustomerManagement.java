package com.ims.common.service.Interface;

import com.ims.domain.Customer;

import java.util.List;


public interface CustomerManagement {
    String addCustomer(Customer customer);

    String selectCommon(List<Customer> customers);

    String selectCustomerById(Integer id);

    String selectCustomerByCompany(String company, Integer offset, Integer limit);

    String selectCustomerByPerson(String person, Integer offset, Integer limit);

    String selectAllCustomer(Integer offset, Integer limit);

    String modifyCustomer(Customer customer);

    String deleteCustomer(Customer customer);


}
