package com.ims.common.controller;

import com.ims.common.service.Interface.ActionRecordSelect;
import com.ims.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ActionRecordSelect")
@ResponseBody
public class ActionSelectController {

    @Autowired
    ActionRecordSelect actionRecordSelect;

    final String SELECT_ALL_ACTION = "selectAll";
    final String SELECT_BY_ACTION_NAME = "selectByActionName";
    final String SELECT_BY_USER_ID = "selectByUserId";
    final String SELECT_BY_USERNAME = "selectByUsername";
    final String SELECT_BY_TIME_GAP = "selectByTimeGap";

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public String select(String type, String param1, String param2, Integer offset, Integer limit){
        System.out.println(type);
        try{
            switch(type){
                case SELECT_ALL_ACTION:
                    return actionRecordSelect.selectAllRecord(offset, limit);
                case SELECT_BY_ACTION_NAME:
                    return actionRecordSelect.selectActionByActionName(param1, offset, limit);
                case SELECT_BY_TIME_GAP:
                    return actionRecordSelect.selectActionByTimeGap(Long.valueOf(param1), Long.valueOf(param2), offset, limit);
                case SELECT_BY_USER_ID:
                    return actionRecordSelect.selectActionByUserId(param1, offset, limit);
                case SELECT_BY_USERNAME:
                    return actionRecordSelect.selectActionByUsername(param1, offset, limit);
                default:
                    return Response._default();
            }
        }catch (NumberFormatException e){
            return Response._exception("参数转换错误");
        }
    }
}
