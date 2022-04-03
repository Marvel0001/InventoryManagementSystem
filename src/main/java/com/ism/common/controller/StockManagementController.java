package com.ism.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.ism.common.service.Impl.StockManagementService;
import com.ism.dao.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StockManagement")
public class StockManagementController {
    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_GOOD_ID = "selectByGoodId";
    final String SELECT_BY_GOOD_NAME = "selectByGoodName";
    final String SELECT_BY_GOOD_TYPE = "selectByGoodType";
    @Autowired
    private StockManagementService stockManagementService;
    public String _Check(String type, String param, Integer offset, Integer limit, Integer storehouse){
        String result = "";
        switch(type){
            case SELECT_ALL:
                 result = stockManagementService.selectAll(storehouse, limit, offset);
                 break;
            case SELECT_BY_GOOD_ID:
                result = stockManagementService.selectByGoodId(Integer.valueOf(param), storehouse, limit, offset);
                break;
            case SELECT_BY_GOOD_NAME:
                result = stockManagementService.selectByGoodName(param, storehouse, limit, offset);
                break;
            case SELECT_BY_GOOD_TYPE:
                result = stockManagementService.selectByGoodType(param, storehouse, limit, offset);
                break;
        }
        return result;
    }

    public String _StockIn(Integer goodId, Integer storehouseId, Integer amount){
        return stockManagementService.stockIn(goodId, storehouseId, amount);
    }

    @RequestMapping(value = "/Check", method = RequestMethod.POST)
    @ResponseBody
    public String Check(String checkType, String param, Integer offset, Integer limit, Integer storehouse){
        return _Check(checkType, param, offset, limit, storehouse);
    }

    @RequestMapping(value = "/StockIn", method = RequestMethod.POST)
    @ResponseBody
    public String StockIn(Integer goodId, Integer storehouseId, Integer amount){
        return _StockIn(goodId, storehouseId, amount);
    }

}
