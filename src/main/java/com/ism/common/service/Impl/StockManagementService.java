package com.ism.common.service.Impl;
import com.alibaba.fastjson.JSONObject;
import com.ism.common.service.Interface.StockManagement;
import com.ism.dao.StorageMapper;
import com.ism.domain.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockManagementService implements StockManagement {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public String selectAll(Integer storehouseId, Integer limit, Integer offset) {
        if(limit > 0 && offset>=0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectAll(storehouseId);
        Integer length = storages.size();
        ArrayList<String> data = new ArrayList<>();
        for(Storage storage: storages) {
            data.add(storage.toString());
        }
        JSONObject result = new JSONObject();
        result.put("length", length);
        result.put("data", data);
        return result.toString();
    }
    @Override
    public String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        List<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        Integer length = storages.size();
        ArrayList<String> data = new ArrayList<>();
        for(Storage storage: storages){
            data.add(storage.toString());
        }
        JSONObject result = new JSONObject();
        result.put("length", length);
        result.put("data", data);
        return result.toString();
    }
}
