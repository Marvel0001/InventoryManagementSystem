package com.ism.common.service.Impl;
import com.alibaba.fastjson.JSONObject;
import com.ism.common.service.Interface.StockManagement;
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

    public String common(List<Storage> storages){
        Integer length = storages.size();
        ArrayList<String> data = new ArrayList<>();
        for(Storage storage: storages) {
            data.add(storage.toString());
        }
        JSONObject result = new JSONObject();
        result.put("data", data);
        result.put("length", length);
        return result.toString();
    }
    @Override
    public String selectAll(Integer storehouseId, Integer limit, Integer offset) {
        if(limit > 0 && offset>=0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectAll(storehouseId);
        return common(storages);
    }
    @Override
    public String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        return common(storages);
    }

    @Override
    public String selectByGoodName(String goodName, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodName(goodName, storehouseId);
        return common(storages);
    }

    @Override
    public String selectByGoodType(String goodType, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodType(goodType, storehouseId);
        return common(storages);
    }

    @Override
    public String stockIn(Integer goodId, Integer storehouseId, Integer amount){
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        JSONObject result = new JSONObject();
        if(storages.size() > 0){
            Storage storage = storages.get(0);
            Integer goodAmount = storage.getNumber() + amount;
            try {
                storageMapper.updateStorage(goodId, storehouseId, goodAmount);
                result.put("result", "success");
            }catch (Exception e){
                e.printStackTrace();
                result.put("result", "failure");
            }
        }
        else{
            try{
                storageMapper.insertStorage(goodId, storehouseId, amount);
                result.put("result", "success");
            }catch (Exception e){
                e.printStackTrace();
                result.put("result", "failure");
            }
        }
        return result.toJSONString();
    }
}
