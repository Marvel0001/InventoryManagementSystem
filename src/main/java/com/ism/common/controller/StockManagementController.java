package com.ism.common.controller;

import com.ism.common.service.Impl.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StockManagement")
@ResponseBody
public class StockManagementController {
    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_GOOD_ID = "selectByGoodId";
    final String SELECT_BY_GOOD_NAME = "selectByGoodName";
    final String SELECT_BY_GOOD_TYPE = "selectByGoodType";

    @Autowired
    private StockManagementService stockManagementService;

    public String _Select(String type, String param, Integer offset, Integer limit, Integer storehouseId){
        String result = "";
        switch(type){
            case SELECT_ALL:
                 result = stockManagementService.selectAll(storehouseId, limit, offset);
                 break;
            case SELECT_BY_GOOD_ID:
                result = stockManagementService.selectByGoodId(Integer.valueOf(param), storehouseId, limit, offset);
                break;
            case SELECT_BY_GOOD_NAME:
                result = stockManagementService.selectByGoodName(param, storehouseId, limit, offset);
                break;
            case SELECT_BY_GOOD_TYPE:
                result = stockManagementService.selectByGoodType(param, storehouseId, limit, offset);
                break;
            default:
                result = "{\"result\":\"failure\", \"data\": \"select type error\"}";
                break;
        }
        return result;
    }

    @RequestMapping(value = "/Select", method = RequestMethod.POST)
    public String Select(String type, String param, Integer offset, Integer limit, Integer storehouseId){
        return _Select(type, param, offset, limit, storehouseId);
    }

    @RequestMapping(value = "/StockIn", method = RequestMethod.POST)
    public String StockIn(Integer goodId, Integer storehouseId, Integer amount){
        return stockManagementService.stockIn(goodId, storehouseId, amount);
    }

    @RequestMapping(value = "/StockOut", method = RequestMethod.POST)
    public String StockOut(Integer goodId, Integer storehouseId, Integer amount){
        return stockManagementService.stockOut(goodId, storehouseId, amount);
    }

    @RequestMapping(value = "/AddStorehouse", method = RequestMethod.POST)
    public String AddStorehouse(String address, Integer status){
        return stockManagementService.addStorehouse(address, status);
    }

}
