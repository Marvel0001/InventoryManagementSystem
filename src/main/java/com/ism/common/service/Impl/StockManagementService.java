package com.ism.common.service.Impl;
import com.ism.common.service.Interface.StockManagement;
import com.ism.common.util.Response;
import com.ism.dao.StorageMapper;
import com.ism.domain.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockManagementService implements StockManagement {
    @Autowired
    private StorageMapper storageMapper;

    public String select_common(List<Storage> storages){
        Response result = Response.generateResponse();
        Integer length = storages.size();
        if(!length.equals(0)){
            ArrayList<String> data = new ArrayList<>();
            for(Storage storage: storages) {
                data.add(storage.toString());
            }
            result.setData(data.toString());
            result.setLength(length);
            result.success();
        }
        else{
            result.failure();
            result.setData("找不到该货物");
        }
        return result.toJSONString();
    }
    @Override
    public String selectAll(Integer storehouseId, Integer limit, Integer offset) {
        if(limit > 0 && offset>=0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectAll(storehouseId);
        return select_common(storages);
    }
    @Override
    public String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        return select_common(storages);
    }

    @Override
    public String selectByGoodName(String goodName, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodName(goodName, storehouseId);
        return select_common(storages);
    }

    @Override
    public String selectByGoodType(String goodType, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodType(goodType, storehouseId);
        return select_common(storages);
    }

    @Override
    public String stockIn(Integer goodId, Integer storehouseId, Integer amount){
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        Response response = Response.generateResponse();
        if(storages.size() > 0){
            Storage storage = storages.get(0);
            Integer goodAmount = storage.getNumber() + amount;
            try {
                storageMapper.updateStorage(goodId, storehouseId, goodAmount);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.failure();
                response.setData("入库失败");
            }
        }
        else{
            try{
                storageMapper.insertStorage(goodId, storehouseId, amount);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.failure();
                response.setData("入库失败");
            }
        }
        return response.toJSONString();
    }

    public String stockOut(Integer goodId, Integer storehouseId, Integer amount){
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        Response response = Response.generateResponse();
        if(storages.size() > 0){
            Storage storage = storages.get(0);
            Integer number = storage.getNumber();
            if(amount > number){
                response.failure();
                response.setData("货物数量不够");
            }
            else if(amount.equals(number)){
                storageMapper.deleteStorage(goodId, storehouseId);
                response.success();
            }
            else{
                number -= amount;
                storageMapper.updateStorage(goodId, storehouseId, number);
                response.success();
            }
        }
        else {
            response.failure();
            response.setData("找不到该货物");
        }
        return response.toJSONString();
    }

    @Override
    public String addStorehouse(String address, Integer status) {
        Response response = Response.generateResponse();
        if(status.equals(0) || status.equals(1)) {
            try {
                storageMapper.addStorehouse(address, status);
                response.success();
            } catch (Exception e) {
                response.failure();
            }
        }
        else {
            response.failure();
            response.setData("状态设置错误");
        }
        return response.toJSONString();
    }
}
