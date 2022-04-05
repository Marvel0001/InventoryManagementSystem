package com.ims.common.controller;

import com.ims.common.service.Impl.StockManagementService;
import com.ims.common.util.Response;
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
        try {
            switch (type) {
                case SELECT_ALL:
                    return stockManagementService.selectAll(storehouseId, limit, offset);
                case SELECT_BY_GOOD_ID:
                    return stockManagementService.selectByGoodId(Integer.valueOf(param), storehouseId, limit, offset);
                case SELECT_BY_GOOD_NAME:
                    return stockManagementService.selectByGoodName(param, storehouseId, limit, offset);
                case SELECT_BY_GOOD_TYPE:
                    return stockManagementService.selectByGoodType(param, storehouseId, limit, offset);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数格式错误");
        }
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
