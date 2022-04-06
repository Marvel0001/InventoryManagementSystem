package com.ims.common.controller;

import com.ims.common.service.Impl.SupplierManagementService;
import com.ims.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SupplierSelect")
public class SupplierSelectController {

    @Autowired
    SupplierManagementService supplierManagementService;

    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_COMPANY = "selectByCompany";
    final String SELECT_BY_PERSON = "selectByPerson";


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectSupplier(String type, String param, Integer offset, Integer limit){
        try{
            switch (type){
                case SELECT_ALL:
                    return supplierManagementService.selectAllSupplier(offset, limit);
                case SELECT_BY_ID:
                    return supplierManagementService.selectSupplierById(Integer.valueOf(param));
                case SELECT_BY_COMPANY:
                    return supplierManagementService.selectSupplierByCompany(param, offset, limit);
                case SELECT_BY_PERSON:
                    return supplierManagementService.selectSupplierByPerson(param, offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            return Response._exception("参数转换错误");
        }
    }
}
