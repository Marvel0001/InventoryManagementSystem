package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.ActionRecordSelect;
import com.ims.common.util.Response;
import com.ims.dao.ActionRecordMapper;
import com.ims.domain.ActionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActionRecordSelectService implements ActionRecordSelect {

    @Autowired
    ActionRecordMapper actionRecordMapper;

    @Override
    public String _selectCommon(ArrayList<ActionRecord> actionRecords) {
        Response response = Response.generateResponse();
        int length = actionRecords.size();
        if(length > 0){
            ArrayList<String> data = new ArrayList<>();
            for(ActionRecord actionRecord: actionRecords) {
                data.add(actionRecord.toString());
            }
            response.success();
            response.setData(data.toString());
            response.setLength(length);
        }
        else{
            response.exception("该记录未找到");
        }
        return response.toJSONString();
    }

    @Override
    public String selectAllRecord(Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<ActionRecord> actionRecords = actionRecordMapper.selectAllRecord();
        return _selectCommon(actionRecords);
    }

    @Override
    public String selectActionByUsername(String username, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<ActionRecord> actionRecords = actionRecordMapper.selectActionByUsername(username);
        return _selectCommon(actionRecords);
    }

    @Override
    public String selectActionByUserId(String userId, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<ActionRecord> actionRecords = actionRecordMapper.selectActionByUserId(userId);
        return _selectCommon(actionRecords);
    }

    @Override
    public String selectActionByActionName(String actionName, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<ActionRecord> actionRecords = actionRecordMapper.selectActionByActionName(actionName);
        return _selectCommon(actionRecords);
    }

    @Override
    public String selectActionByTimeGap(Long pre, Long least, Integer offset, Integer limit) {
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        if(least <= pre)
            return Response._exception("时间错误");
        ArrayList<ActionRecord> actionRecords = actionRecordMapper.selectActionByTimeGap(pre, least);
        return _selectCommon(actionRecords);
    }
}
