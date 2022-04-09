package com.ims.common.controller;

import com.ims.common.service.Interface.SupplierManagement;
import com.ims.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SupplierManagement")
@ResponseBody
public class SupplierManagementController {
    @Autowired
    SupplierManagement supplierManagement;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addSupplier(Supplier supplier){
        return supplierManagement.addSupplier(supplier);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifySupplier(Supplier supplier){
        System.out.println(supplier);
        return supplierManagement.modifySupplier(supplier);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteSupplier(Supplier supplier){
        return supplierManagement.deleteSupplier(supplier);
    }
}
