package com.ims.common.controller;

import com.ims.common.service.Interface.StorehouseManagement;
import com.ims.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/StorehouseSelect")
@ResponseBody
public class StorehouseSelectController {
    @Autowired
    StorehouseManagement storehouseManagement;

    final String SELECT_BY_ID = "selectById";
    final String SELECT_BY_REGION = "selectByRegion";
    final String SELECT_ENABLED = "selectEnabled";
    final String SELECT_DISABLED = "selectDisabled";
    final String SELECT_ALL = "selectAll";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String selectStorehouse(String type, String param, Integer offset, Integer limit){
        try {
            switch (type) {
                case SELECT_ALL:
                    return storehouseManagement.selectAllStorehouse(offset, limit);
                case SELECT_BY_ID:
                    return storehouseManagement.selectStorehouseById(Integer.valueOf(param));
                case SELECT_BY_REGION:
                    return storehouseManagement.selectStorehouseByRegion(param, offset, limit);
                case SELECT_ENABLED:
                    return storehouseManagement.selectStorehouseEnabled(offset, limit);
                case SELECT_DISABLED:
                    return storehouseManagement.selectStorehouseDisabled(offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("格式错误");
        }
    }
}
