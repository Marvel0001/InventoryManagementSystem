package com.ims.common.service.Interface;

import com.ims.domain.Good;

import java.util.ArrayList;
import java.util.HashMap;


public interface GoodManagement {
    /**
     * 添加货物信息
     * @param good 待添加的货物信息实例，除id外其他属性必须赋值
     * @return 添加结果
     */
    String addGood(Good good);

    /**
     * 通过货物id查询
     * @param id 货物id
     * @return 查询结果
     */
    String selectGoodById(Integer id);

    /**
     * 通过货物名称查询
     * @param name 货物名称
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectGoodByName(String name, Integer offset, Integer limit);

    /**
     * 通过货物类型查询
     * @param type 货物类型
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectGoodByType(String type, Integer offset, Integer limit);

    /**
     * 通过货物价值查询
     * @param value 货物价值
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectGoodByValue(Float value, Integer offset, Integer limit);

    /**
     * 选择价格比某个数多的货物
     * @param value 价值
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectGoodMoreThan(Float value, Integer offset, Integer limit);

    /**
     * 查询数量比某个数少的货物
     * @param value 价值
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectGoodLessThan(Float value, Integer offset, Integer limit);

    /**
     * 查询所有货物
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAllGood(Integer offset, Integer limit);

    /**
     * 查询所有货物名称
     * @return id:name的映射
     */
    HashMap<Integer, String> _selectAllName();

    /**
     * 通用的查询结果处理方法
     * @param goods 查询到的货物实例
     * @return 查询结果
     */
    String _selectCommon(ArrayList<Good> goods);

    /**
     * 修改货物
     * @param good 待修改的货物实例，id为必须，将其他值写入数据库
     * @return 修改结果
     */
    String modifyGood(Good good);

    /**
     * 删除货物
     * @param good 待删除的货物实例，只需id即可
     * @return 删除结果
     */
    String deleteGood(Good good);
}
