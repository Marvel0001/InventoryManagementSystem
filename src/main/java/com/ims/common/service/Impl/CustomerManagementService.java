package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.CustomerManagement;
import com.ims.common.util.Response;
import com.ims.dao.CustomerMapper;
import com.ims.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManagementService implements CustomerManagement {

    @Autowired
    CustomerMapper customerMapper;
    @Override
    public String addCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(customer != null){
            try{
                customerMapper.addCustomer(customer);
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
    public String selectCommon(List<Customer> customers) {
        Response response = Response.generateResponse();
        int length = customers.size();
        if(length > 0){
            ArrayList<String> data = new ArrayList<>();
            for(Customer customer: customers){
                data.add(customer.toString());
            }
            response.success();
            response.setData(data.toString());
            response.setLength(length);
        }
        else{
            response.exception("该顾客未找到");
        }
        return response.toJSONString();
    }

    @Override
    public String selectCustomerById(Integer id) {
        List<Customer> customers = customerMapper.selectCustomerById(id);
        return selectCommon(customers);
    }

    @Override
    public String selectCustomerByCompany(String company, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Customer> customers = customerMapper.selectCustomerByCompany(company);
        return selectCommon(customers);
    }

    @Override
    public String selectCustomerByPerson(String person, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Customer> customers = customerMapper.selectCustomerByPerson(person);
        return selectCommon(customers);
    }

    @Override
    public String selectAllCustomer(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Customer> customers = customerMapper.selectAllCustomer();
        return selectCommon(customers);
    }

    @Override
    public String modifyCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(customer != null){
            try{
                customerMapper.modifyCustomer(customer);
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
    public String deleteCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(customer != null){
            try{
                customerMapper.deleteCustomer(customer);
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
