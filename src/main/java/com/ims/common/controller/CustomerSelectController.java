package com.ims.common.controller;

import com.ims.common.service.Interface.CustomerManagement;
import com.ims.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CustomerSelect")
@ResponseBody
@CrossOrigin
public class CustomerSelectController {
    @Autowired
    CustomerManagement customerManagement;

    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_COMPANY = "selectByCompany";
    final String SELECT_BY_PERSON = "selectByPerson";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectCustomer(String type, String param, Integer offset, Integer limit){
        try{
            switch (type){
                case SELECT_ALL:
                    return customerManagement.selectAllCustomer(offset, limit);
                case SELECT_BY_ID:
                    return customerManagement.selectCustomerById(Integer.valueOf(param));
                case SELECT_BY_COMPANY:
                    return customerManagement.selectCustomerByCompany(param, offset, limit);
                case SELECT_BY_PERSON:
                    return customerManagement.selectCustomerByPerson(param, offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return Response._exception("参数转换错误");
        }
    }

}
