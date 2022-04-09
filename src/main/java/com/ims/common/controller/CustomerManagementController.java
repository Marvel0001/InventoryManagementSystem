package com.ims.common.controller;

import com.ims.common.service.Interface.CustomerManagement;
import com.ims.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/CustomerManagement"})
@ResponseBody
public class CustomerManagementController {
    @Autowired
    CustomerManagement customerManagement;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addCustomer(Customer customer){
        return customerManagement.addCustomer(customer);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyCustomer(Customer customer){
        return customerManagement.modifyCustomer(customer);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteCustomer(Customer customer){
        return customerManagement.deleteCustomer(customer);
    }
}
