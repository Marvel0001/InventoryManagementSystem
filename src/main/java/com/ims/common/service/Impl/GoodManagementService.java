package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.GoodManagement;
import com.ims.common.util.Response;
import com.ims.dao.CustomerMapper;
import com.ims.dao.GoodMapper;
import com.ims.dao.SupplierMapper;
import com.ims.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
//@Scope
public class GoodManagementService implements GoodManagement {

    @Autowired
    GoodMapper goodMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    SupplierMapper supplierMapper;

    final String SELECT = "SELECT";
    final String INSERT = "INSERT";
    final String DELETE = "DELETE";
    final String MODIFY = "MODIFY";

    @Override
    public String addGood(Good good) {
        Response response = Response.generateResponse();
        if (verification(good, response, INSERT)){
            try{
                goodMapper.addGood(good);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("添加失败，请检查参数");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String selectGoodById(Integer id) {
        ArrayList<Good> goods = goodMapper.selectGoodById(id);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByName(String name, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectGoodByName(name);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByType(String type, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectGoodByType(type);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByValue(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectGoodByValue(value);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodMoreThan(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectGoodMoreThan(value);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodLessThan(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectGoodLessThan(value);
        return selectCommon(goods);
    }

    @Override
    public String selectAllGood(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Good> goods = goodMapper.selectAllGood();
        return selectCommon(goods);
    }

    @Override
    public HashMap<Integer, String> selectAllName(){
        ArrayList<Good> goods = goodMapper.selectAllName();
        HashMap<Integer, String> goodMap = new HashMap<>();
        for(Good good:goods){
            goodMap.put(good.getId(), good.getName());
        }
        return goodMap;
    }

    @Override
    public String selectCommon(ArrayList<Good> goods) {
        Response response = Response.generateResponse();
        int length = goods.size();
        if(length > 0){
            ArrayList<String> data = new ArrayList<>();
            for(Good good: goods){
                data.add(good.toString());
            }
            response.success();
            response.setData(data.toString());
            response.setLength(length);
        }
        else{
            response.exception("未找到该货物");
        }
        return response.toJSONString();
    }

    @Override
    public String modifyGood(Good good) {
        System.out.println(good);
        Response response = Response.generateResponse();
        if(verification(good, response, MODIFY)) {
            try {
                goodMapper.modifyGood(good);
                response.success();
            } catch (Exception e) {
                e.printStackTrace();
                response.exception("修改错误");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String deleteGood(Good good) {
        Response response = Response.generateResponse();
        if(verification(good, response, DELETE)){
            try{
                goodMapper.deleteGood(good);
                response.success();
            }catch (Exception e){
                response.exception("删除错误错误");
            }
        }
        return response.toJSONString();
    }

    private boolean verification(Good good, Response response, String operation){
        if(good == null){
            response.exception("参数不能为空");
            return false;
        }
        switch (operation){
            case SELECT:
            case INSERT:
                break;
            case MODIFY:
                if(good.getId() == 0){
                    response.exception("id不能为空");
                    return false;
                }
                if(good.getCustomer() != null){
                    ArrayList<String> customers = customerMapper.selectAllCustomerName();
                    if(!customers.contains(good.getCustomer())) {
                        response.exception("不存在该顾客");
                        return false;
                    }
                    customers.clear();
                }
                if(good.getSupplier() != null){
                    ArrayList<String> suppliers = supplierMapper.selectAllSupplierName();
                    if(!suppliers.contains(good.getSupplier())) {
                        response.exception("不存在该供应商");
                        return false;
                    }
                }
                break;
            case DELETE:
                if(good.getId() == 0){
                    response.exception("id不能为空");
                    return false;
                }
        }
        return true;
    }

}
