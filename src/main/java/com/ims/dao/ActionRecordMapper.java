package com.ims.dao;

import com.ims.domain.ActionRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ActionRecordMapper {
    ArrayList<ActionRecord> selectAllRecord();

    void insertRecord(ActionRecord actionRecord);
}
