package com.ims.common.controller;

import com.ims.common.service.Interface.SupplierManagement;
import com.ims.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SupplierSelect")
@ResponseBody
public class SupplierSelectController {

    @Autowired
    SupplierManagement supplierManagement;

    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_COMPANY = "selectByCompany";
    final String SELECT_BY_PERSON = "selectByPerson";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectSupplier(String type, String param, Integer offset, Integer limit){
        try{
            switch (type){
                case SELECT_ALL:
                    return supplierManagement.selectAllSupplier(offset, limit);
                case SELECT_BY_ID:
                    return supplierManagement.selectSupplierById(Integer.valueOf(param));
                case SELECT_BY_COMPANY:
                    return supplierManagement.selectSupplierByCompany(param, offset, limit);
                case SELECT_BY_PERSON:
                    return supplierManagement.selectSupplierByPerson(param, offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return Response._exception("参数转换错误");
        }
    }
}
