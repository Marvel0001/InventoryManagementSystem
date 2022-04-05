package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.GoodManagement;
import com.ims.common.util.Response;
import com.ims.dao.GoodMapper;
import com.ims.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodManagementService implements GoodManagement {

    @Autowired
    GoodMapper goodMapper;

    @Override
    public String addGood(Good good) {
        Response response = Response.generateResponse();
        if (good != null){
            try{
                goodMapper.addGood(good);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("添加失败，请检查参数");
            }
        }
        else{
            response.exception("参数错误");
        }
        return response.toJSONString();
    }

    @Override
    public String selectGoodById(Integer id) {
        List<Good> goods = goodMapper.selectGoodById(id);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByName(String name, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectGoodByName(name);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByType(String type, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectGoodByType(type);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodByValue(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectGoodByValue(value);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodMoreThan(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectGoodMoreThan(value);
        return selectCommon(goods);
    }

    @Override
    public String selectGoodLessThan(Float value, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectGoodLessThan(value);
        return selectCommon(goods);
    }

    @Override
    public String selectAllGood(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Good> goods = goodMapper.selectAllGood();
        return selectCommon(goods);
    }

    @Override
    public String selectCommon(List<Good> goods) {
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
        Response response = Response.generateResponse();
        if(good != null){
            try{
                goodMapper.modifyGood(good);
                response.success();
            }catch (Exception e){
                response.exception("修改错误");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String deleteGood(Good good) {
        Response response = Response.generateResponse();
        if(good != null){
            try{
                goodMapper.deleteGood(good);
                response.success();
            }catch (Exception e){
                response.exception("删除错误错误");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }
}
