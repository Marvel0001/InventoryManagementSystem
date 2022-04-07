package com.ims.common.controller;

import com.ims.common.service.Impl.CustomerManagementService;
import com.ims.common.util.Response;
import com.ims.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/CustomerManagement", "/selectCustomer"})
@ResponseBody
public class CustomerManagementController {
    @Autowired
    CustomerManagementService customerManagementService;



    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addCustomer(Customer customer){
        return customerManagementService.addCustomer(customer);
    }



    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyCustomer(Customer customer){
        return customerManagementService.modifyCustomer(customer);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteCustomer(Customer customer){
        return customerManagementService.deleteCustomer(customer);
    }
}
