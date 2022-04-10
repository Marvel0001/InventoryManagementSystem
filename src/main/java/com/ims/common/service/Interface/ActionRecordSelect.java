package com.ims.common.service.Interface;

import com.ims.domain.ActionRecord;

import java.util.ArrayList;


public interface ActionRecordSelect {
    String _selectCommon(ArrayList<ActionRecord> actionRecords);

    String selectAllRecord(Integer offset, Integer limit);

    String selectActionByUsername(String username, Integer offset, Integer limit);

    String selectActionByUserId(String userId, Integer offset, Integer limit);

    String selectActionByActionName(String actionName, Integer offset, Integer limit);

    String selectActionByTimeGap(Long pre, Long least, Integer offset, Integer limit);
}
