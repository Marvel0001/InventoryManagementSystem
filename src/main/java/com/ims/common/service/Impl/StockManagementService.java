package com.ims.common.service.Impl;
import com.ims.common.service.Interface.StockManagement;
import com.ims.common.util.Response;
import com.ims.dao.StorageMapper;
import com.ims.domain.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;

@Service
public class StockManagementService implements StockManagement {

    @Autowired
    private StorageMapper storageMapper;

    public String _selectCommon(ArrayList<Storage> storages){
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
            result.exception("找不到该库存");
        }
        return result.toJSONString();
    }

    @Override
    public String selectAll(Integer storehouseId, Integer limit, Integer offset) {
        if(limit > 0 && offset>=0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storage> storages = storageMapper.selectAll(storehouseId);
        return _selectCommon(storages);
    }

    @Override
    public String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        return _selectCommon(storages);
    }

    @Override
    public String selectByGoodName(String goodName, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storage> storages = storageMapper.selectByGoodName(goodName, storehouseId);
        return _selectCommon(storages);
    }

    @Override
    public String selectByGoodType(String goodType, Integer storehouseId, Integer limit, Integer offset){
        if(limit > 0 && offset >0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Storage> storages = storageMapper.selectByGoodType(goodType, storehouseId);
        return _selectCommon(storages);
    }

    @Override
    public String stockIn(Integer goodId, Integer storehouseId, Integer amount){
        ArrayList<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        Response response = Response.generateResponse();
        if(storages.size() > 0){
            Storage storage = storages.get(0);
            Integer goodAmount = storage.getNumber() + amount;
            try {
                storageMapper.updateStorage(goodId, storehouseId, goodAmount);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("入库失败");
            }
        }
        else{
            try{
                storageMapper.insertStorage(goodId, storehouseId, amount);
                response.success();
            }catch (Exception e){
                e.printStackTrace();
                response.exception("入库失败");
            }
        }
        return response.toJSONString();
    }

    public String stockOut(Integer goodId, Integer storehouseId, Integer amount){
        ArrayList<Storage> storages = storageMapper.selectByGoodId(goodId, storehouseId);
        Response response = Response.generateResponse();
        if(storages.size() > 0){
            Storage storage = storages.get(0);
            Integer number = storage.getNumber();
            if(amount > number){
                response.exception("出库失败， 数量不足");
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
            response.exception("找不到该库存");
        }
        return response.toJSONString();
    }
}
