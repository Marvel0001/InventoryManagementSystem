package com.ims.common.service.Interface;

public interface StockManagement {

    /**
     * 选择全部货物
     * @param storehouseId 仓库id
     * @param limit        选择的数量
     * @param offset        偏移值
     * @return  json字符串
     */
    String selectAll(Integer storehouseId, Integer limit, Integer offset);

    /**
     * 根据id选择货物
     * @param goodId        货物id
     * @param storehouseId  仓库id
     * @param limit         选择的数量
     * @param offset        偏移值
     * @return json字符串
     */
    String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset);

    /**
     * 根据名称选择货物
     * @param goodName      货物名称
     * @param storehouseId  仓库id
     * @param limit         选择的数量
     * @param offset        偏移值
     * @return json字符串
     */
    String selectByGoodName(String goodName, Integer storehouseId, Integer limit, Integer offset);

    /**
     * 根据类型选择货物
     * @param  goodType     货物类型
     * @param storehouseId  仓库id
     * @param limit         选择的数量
     * @param offset        偏移值
     * @return json字符串
     */
    String selectByGoodType(String goodType, Integer storehouseId, Integer limit, Integer offset);

    String stockIn(Integer goodId, Integer storehouseId, Integer amount);

    String stockOut(Integer goodId, Integer storehouseId, Integer amount);

    String addStorehouse(String address, Integer status);
}
