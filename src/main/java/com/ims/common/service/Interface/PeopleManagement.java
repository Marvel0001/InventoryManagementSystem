package com.ims.common.service.Interface;

import com.ims.domain.Admin;

import java.util.ArrayList;

public interface PeopleManagement {
    /**
     * 添加管理员
     * @param admin 待添加的管理员实例，除id外必须赋值，role只能为systemAdmin或commonAdmin
     * @return 添加结果
     */
    String addAdmin(Admin admin);

    /**
     * 通过id查询管理员
     * @param adminId 管理员id
     * @return 查询结果
     */
    String selectAdminById(Integer adminId);

    /**
     * 通过仓库id查询管理员
     * @param storehouseId 仓库id
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAdminByStorehouseId(Integer storehouseId, Integer offset, Integer limit);

    /**
     * 通过名字查询管理员
     * @param name 名字
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAdminByName(String name, Integer offset, Integer limit);

    /**
     * 选择所有管理员
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAllAdmin(Integer offset, Integer limit);

    /**
     * 通用查询结果处理方法
     * @param admins 待处理的管理员实例
     * @return 查询结果
     */
    String _selectCommon(ArrayList<Admin> admins);

    /**
     * 修改管理员
     * @param admin 待修改的管理员实例，id不能为空
     * @return 修改结果
     */
    String modifyAdmin(Admin admin);

    /**
     * 删除管理员
     * @param admin 待删除的管理员，id不为空即可
     * @return 删除结果
     */
    String deleteAdmin(Admin admin);

    /**
     * 通过名字查询单个管理员，用于登录
     * @param name 管理员名字
     * @return 管理员实例
     */
    Admin _selectByUsername(String name);
}
