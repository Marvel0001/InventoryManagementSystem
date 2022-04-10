package com.ims.common.service.Interface;

import com.ims.domain.ActionRecord;

import java.util.ArrayList;


public interface ActionRecordSelect {
    /**
     * 处理查询结果
     * @param actionRecords 待处理结果
     * @return json字符串
     */
    String _selectCommon(ArrayList<ActionRecord> actionRecords);

    /**
     * 选择全部记录
     * @param offset 偏移量
     * @param limit  查询数量
     * @return 返回处理查询结果方法处理后的结果
     */
    String selectAllRecord(Integer offset, Integer limit);

    /**
     * 通过用户名查询
     * @param username 用户名
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 返回处理查询结果方法处理后的结果
     */
    String selectActionByUsername(String username, Integer offset, Integer limit);

    /**
     * 通过用户id查询
     * @param userId 用户id
     * @param offset  偏移量
     * @param limit 查询数量
     * @return 返回处理查询结果方法处理后的结果
     */
    String selectActionByUserId(String userId, Integer offset, Integer limit);

    /**
     * 通过操作名称查询
     * @param actionName 操作名称
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 返回处理查询结果方法处理后的结果
     */
    String selectActionByActionName(String actionName, Integer offset, Integer limit);

    /**
     * 通过时间间隔查询
     * @param pre 起始时间
     * @param least 截止时间
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 返回处理查询结果方法处理后的结果
     */
    String selectActionByTimeGap(Long pre, Long least, Integer offset, Integer limit);
}
