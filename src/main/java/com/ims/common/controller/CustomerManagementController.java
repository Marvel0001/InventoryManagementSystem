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
@RequestMapping("/CustomerManagement")
@ResponseBody
public class CustomerManagementController {
    @Autowired
    CustomerManagementService customerManagementService;

    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_COMPANY = "selectByCompany";
    final String SELECT_BY_PERSON = "selectByPerson";

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addCustomer(Customer customer){
        return customerManagementService.addCustomer(customer);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectCustomer(String type, String param, Integer offset, Integer limit){
        try{
            switch (type){
                case SELECT_ALL:
                    return customerManagementService.selectAllCustomer(offset, limit);
                case SELECT_BY_ID:
                    return customerManagementService.selectCustomerById(Integer.valueOf(param));
                case SELECT_BY_COMPANY:
                    return customerManagementService.selectCustomerByCompany(param, offset, limit);
                case SELECT_BY_PERSON:
                    return customerManagementService.selectCustomerByPerson(param, offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return Response._exception("参数转换错误");
        }
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
