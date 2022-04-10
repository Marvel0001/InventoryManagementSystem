package com.ims.dao;

import com.ims.domain.ActionRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ActionRecordMapper {
    ArrayList<ActionRecord> selectAllRecord();

    ArrayList<ActionRecord> selectActionByUsername(@Param("username")String username);

    ArrayList<ActionRecord> selectActionByUserId(@Param("userId")String userId);

    ArrayList<ActionRecord> selectActionByActionName(@Param("actionName")String actionName);

    ArrayList<ActionRecord> selectActionByTimeGap(@Param("pre")Long pre, @Param("least")Long least);

    void insertRecord(ActionRecord actionRecord);
}
