package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.StorehouseManagement;
import com.ims.common.util.Response;
import com.ims.dao.StorehouseMapper;
import com.ims.domain.Storehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StorehouseManagementService implements StorehouseManagement {

    @Autowired
    StorehouseMapper storehouseMapper;

    @Override
    public String addStorehouse(Storehouse storehouse) {
        Response response = Response.generateResponse();
        if(storehouse != null){
            try {
                storehouseMapper.addStorehouse(storehouse);
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
    public String selectStorehouseById(Integer storehouseId) {
        ArrayList<Storehouse> storehouses = storehouseMapper.selectStorehouseById(storehouseId);
        return _selectCommon(storehouses);
    }

    @Override
    public String selectStorehouseByRegion(String region, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storehouse> storehouses = storehouseMapper.selectStorehouseByRegion(region);
        return _selectCommon(storehouses);
    }

    @Override
    public String selectStorehouseEnabled(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storehouse> storehouses = storehouseMapper.selectStorehouseEnabled();
        return _selectCommon(storehouses);
    }

    @Override
    public String selectStorehouseDisabled(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storehouse> storehouses = storehouseMapper.selectStorehouseDisabled();
        return _selectCommon(storehouses);
    }

    @Override
    public String selectAllStorehouse(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storehouse> storehouses = storehouseMapper.selectAllStorehouse();
        return _selectCommon(storehouses);
    }

    public String _selectCommon(ArrayList<Storehouse> storehouses){
        Response response = Response.generateResponse();
        int length = storehouses.size();
        if(length > 0){
            ArrayList<String> data = new ArrayList<>();
            for (Storehouse storehouse: storehouses){
                data.add(storehouse.toString());
            }
            response.setData(data.toString());
            response.success();
            response.setLength(length);
        }
        else{
            response.exception("找不到该仓库");
        }
        return response.toJSONString();
    }

    @Override
    public String modifyStorehouse(Storehouse storehouse) {
        Response response = Response.generateResponse();
        if(storehouse != null){
            try {
                storehouseMapper.modifyStorehouse(storehouse);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("修改出错");
            }
        }
        else{
            response.exception("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String deleteStorehouse(Storehouse storehouse) {
        Response response = Response.generateResponse();
        if(storehouse != null){
            try{
                storehouseMapper.deleteStorehouse(storehouse);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("删除出错");
            }
        }
        else {
            response.exception("参数不足");
        }
        return response.toJSONString();
    }
}
