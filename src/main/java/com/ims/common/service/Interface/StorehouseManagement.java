package com.ims.common.service.Interface;

import com.ims.domain.Storehouse;

import java.util.ArrayList;

public interface StorehouseManagement {
    /**
     * 添加仓库
     * @param storehouse 待添加的实例，除id外都不为空
     * @return 添加结果
     */
    String addStorehouse(Storehouse storehouse);

    /**
     * 通过id查询仓库
     * @param storehouseId  仓库的id
     * @return 查询结果
     */
    String selectStorehouseById(Integer storehouseId);

    /**
     * 通过地区查询仓库 （模糊查询）
     * @param region 地区
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectStorehouseByRegion(String region, Integer offset, Integer limit);

    /**
     * 查询可用的仓库
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectStorehouseEnabled(Integer offset, Integer limit);

    /**
     * 查询不可用的仓库
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectStorehouseDisabled(Integer offset, Integer limit);

    /**
     * 查询所有仓库
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAllStorehouse(Integer offset, Integer limit);

    /**
     * 通用的查询结果处理方法
     * @param storehouses 待处理的仓库实例
     * @return 查询结果
     */
    String _selectCommon(ArrayList<Storehouse> storehouses);

    /**
     * 修改仓库
     * @param storehouse 待修改的仓库实例， id不能为空
     * @return 修改结果
     */
    String modifyStorehouse(Storehouse storehouse);

    /**
     * 删除仓库
     * @param storehouse 待删除的仓库实例，id不为空即可
     * @return 删除结果
     */
    String deleteStorehouse(Storehouse storehouse);
}
