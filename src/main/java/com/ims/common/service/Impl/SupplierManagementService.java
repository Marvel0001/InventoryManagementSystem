package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.SupplierManagement;
import com.ims.common.util.Response;
import com.ims.dao.SupplierMapper;
import com.ims.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierManagementService implements SupplierManagement {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public String addSupplier(Supplier supplier) {
        Response response = Response.generateResponse();
        if(supplier != null){
            try{
                supplierMapper.addSupplier(supplier);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("添加失败");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String selectCommon(List<Supplier> suppliers) {
        Response response = Response.generateResponse();
        int length = suppliers.size();
        if(length > 0){
            ArrayList<String> data = new ArrayList<>();
            for(Supplier supplier: suppliers){
                data.add(supplier.toString());
            }
            response.success();
            response.setData(data.toString());
            response.setLength(length);
        }
        else{
            response.exception("该供应商未找到");
        }
        return response.toJSONString();
    }

    @Override
    public String selectSupplierById(Integer id) {
        List<Supplier> suppliers = supplierMapper.selectSupplierById(id);
        return selectCommon(suppliers);
    }

    @Override
    public String selectSupplierByCompany(String company, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Supplier> suppliers = supplierMapper.selectSupplierByCompany(company);
        return selectCommon(suppliers);
    }

    @Override
    public String selectSupplierByPerson(String person, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Supplier> suppliers = supplierMapper.selectSupplierByPerson(person);
        return selectCommon(suppliers);
    }

    @Override
    public String selectAllSupplier(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Supplier> suppliers = supplierMapper.selectAllSupplier();
        return selectCommon(suppliers);
    }

    @Override
    public String modifySupplier(Supplier supplier) {
        Response response = Response.generateResponse();
        if(supplier != null){
            try{
                supplierMapper.modifySupplier(supplier);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("修改错误");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String deleteSupplier(Supplier supplier) {
        Response response = Response.generateResponse();
        if(supplier != null){
            try{
                supplierMapper.deleteSupplier(supplier);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("删除错误");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }
}
