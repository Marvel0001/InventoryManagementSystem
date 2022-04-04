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
            result.setResult("success");
        }
        else{
            result.setResult("failure");
            result.setData("good not found");
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
                response.setResult("success");
            }catch (Exception e){
                e.printStackTrace();
                response.setResult("failure");
                response.setData("update failure");
            }
        }
        else{
            try{
                storageMapper.insertStorage(goodId, storehouseId, amount);
                response.setResult("success");
            }catch (Exception e){
                e.printStackTrace();
                response.setResult("failure");
                response.setData("insert failure");
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
                response.setResult("failure");
                response.setData("good amount not enough");
            }
            else if(amount.equals(number)){
                storageMapper.deleteStorage(goodId, storehouseId);
                response.setResult("success");
            }
            else{
                number -= amount;
                storageMapper.updateStorage(goodId, storehouseId, number);
                response.setResult("success");
            }
        }
        else {
            response.setResult("failure");
            response.setData("good not found");
        }
        return response.toJSONString();
    }

    @Override
    public String addStorehouse(String address, Integer status) {
        Response response = Response.generateResponse();
        if(status.equals(0) || status.equals(1)) {
            try {
                storageMapper.addStorehouse(address, status);
                response.setResult("success");
            } catch (Exception e) {
                response.setResult("failure");
            }
        }
        else {
            response.setResult("failure");
            response.setData("status error");
        }
        return response.toJSONString();
    }
}
