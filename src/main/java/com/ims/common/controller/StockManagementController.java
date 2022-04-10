package com.ims.common.controller;

import com.ims.common.service.Interface.StockManagement;
import com.ims.common.util.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
    private StockManagement stockManagement;

    @RequestMapping(value = "/Select", method = RequestMethod.POST)
    public String Select(String type, String param, Integer offset, Integer limit, Integer storehouseId){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(!storehouseId.toString().equals(session.getAttribute("storehouseId"))){
            return Response._exception("禁止跨仓库管理");
        }
        try {
            switch (type) {
                case SELECT_ALL:
                    return stockManagement.selectAll(storehouseId, limit, offset);
                case SELECT_BY_GOOD_ID:
                    return stockManagement.selectByGoodId(Integer.valueOf(param), storehouseId, limit, offset);
                case SELECT_BY_GOOD_NAME:
                    return stockManagement.selectByGoodName(param, storehouseId, limit, offset);
                case SELECT_BY_GOOD_TYPE:
                    return stockManagement.selectByGoodType(param, storehouseId, limit, offset);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数格式错误");
        }
    }

    @RequestMapping(value = "/StockIn", method = RequestMethod.POST)
    public String StockIn(Integer goodId, Integer storehouseId, Integer amount){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        if(!storehouseId.toString().equals(session.getAttribute("storehouseId"))){
            return Response._exception("禁止跨仓库管理");
        }
        return stockManagement.stockIn(goodId, storehouseId, amount);
    }

    @RequestMapping(value = "/StockOut", method = RequestMethod.POST)
    public String StockOut(Integer goodId, Integer storehouseId, Integer amount){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        if(!storehouseId.toString().equals(session.getAttribute("storehouseId"))){
            return Response._exception("禁止跨仓库管理");
        }
        return stockManagement.stockOut(goodId, storehouseId, amount);
    }

}
