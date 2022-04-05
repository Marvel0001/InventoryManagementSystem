package com.ims.common.controller;

import com.ims.common.service.Impl.GoodManagementService;
import com.ims.common.util.Response;
import com.ims.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/GoodManagement")
@ResponseBody
public class GoodManagementController {
    @Autowired
    GoodManagementService goodManagementService;

    final String SELECT_ALL = "selectAll";
    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_NAME = "selectByName";
    final String SELECT_BY_TYPE = "selectByType";
    final String SELECT_BY_VALUE = "selectByValue";
    final String SELECT_BY_MORE = "selectByMore";
    final String SELECT_BY_LESS = "selectByLess";

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addGood(Good good){
        return goodManagementService.addGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectGood(String type, String param, Integer offset, Integer limit){
        try {
            switch (type) {
                case SELECT_ALL:
                    return goodManagementService.selectAllGood(offset, limit);
                case SELECT_BY_ID:
                    return goodManagementService.selectGoodById(Integer.valueOf(param));
                case SELECT_BY_LESS:
                    return goodManagementService.selectGoodLessThan(Float.valueOf(param), offset, limit);
                case SELECT_BY_MORE:
                    return goodManagementService.selectGoodMoreThan(Float.valueOf(param), offset, limit);
                case SELECT_BY_NAME:
                    return goodManagementService.selectGoodByName(param, offset, limit);
                case SELECT_BY_TYPE:
                    return goodManagementService.selectGoodByType(param, offset, limit);
                case SELECT_BY_VALUE:
                    return goodManagementService.selectGoodByValue(Float.valueOf(param), offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数转换错误");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String modifyGood(Good good){
        return goodManagementService.modifyGood(good);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteGood(Good good){
        return goodManagementService.deleteGood(good);
    }
}
