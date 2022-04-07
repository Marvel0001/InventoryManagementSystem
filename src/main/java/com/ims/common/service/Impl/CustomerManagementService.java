package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.CustomerManagement;
import com.ims.common.util.Response;
import com.ims.dao.CustomerMapper;
import com.ims.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerManagementService implements CustomerManagement {

    final String SELECT = "SELECT";
    final String INSERT = "INSERT";
    final String DELETE = "DELETE";
    final String MODIFY = "MODIFY";

    @Autowired
    CustomerMapper customerMapper;
    @Override
    public String addCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(verification(customer, response, SELECT)){
            try{
                customerMapper.addCustomer(customer);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("添加失败");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String selectCommon(ArrayList<Customer> customers) {
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
        ArrayList<Customer> customers = customerMapper.selectCustomerById(id);
        return selectCommon(customers);
    }

    @Override
    public String selectCustomerByCompany(String company, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Customer> customers = customerMapper.selectCustomerByCompany(company);
        return selectCommon(customers);
    }

    @Override
    public String selectCustomerByPerson(String person, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Customer> customers = customerMapper.selectCustomerByPerson(person);
        return selectCommon(customers);
    }

    @Override
    public String selectAllCustomer(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Customer> customers = customerMapper.selectAllCustomer();
        return selectCommon(customers);
    }

    @Override
    public String modifyCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(verification(customer, response, MODIFY)){
            try{
                customerMapper.modifyCustomer(customer);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("修改错误");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String deleteCustomer(Customer customer) {
        Response response = Response.generateResponse();
        if(verification(customer, response, DELETE)){
            try{
                customerMapper.deleteCustomer(customer);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("删除错误");
            }
        }
        return response.toJSONString();
    }

    private boolean verification(Customer customer, Response response, String operation){
        if(customer == null){
            response.exception("参数不足");
            return false;
        }
        switch (operation){
            case INSERT:
                break;
            case DELETE:
            case MODIFY:
                if(customer.getId() == 0){
                    response.exception("id不能为空");
                    return false;
                }
        }
        return true;
    }
}
