package com.ims.common.service.Interface;

import com.ims.domain.Supplier;

import java.util.ArrayList;

public interface SupplierManagement {
    /**
     * 添加供应商
     * @param Supplier 待添加的供应商实例，除id外其他值不能为空
     * @return 添加结果
     */
    String addSupplier(Supplier Supplier);

    /**
     * 通用的查询结果处理方法
     * @param Suppliers 待处理的供应商实例
     * @return 查询结果
     */
    String _selectCommon(ArrayList<Supplier> Suppliers);

    /**
     * 通过供应商id查询
     * @param id 供应商id
     * @return 查询结果
     */
    String selectSupplierById(Integer id);

    /**
     * 通过公司名称查询
     * @param company 公司名称
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectSupplierByCompany(String company, Integer offset, Integer limit);

    /**
     * 通过联系人拆线呢
     * @param person 联系人名字
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectSupplierByPerson(String person, Integer offset, Integer limit);

    /**
     * 查询所有供应商
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 查询结果
     */
    String selectAllSupplier(Integer offset, Integer limit);

    /**
     * 修改供应商
     * @param supplier 待修改的供应商， id不能为空
     * @return 修改结果
     */
    String modifySupplier(Supplier supplier);

    /**
     * 删除供应商
     * @param supplier 待删除的供应商， id不为空即可
     * @return 删除结果
     */
    String deleteSupplier(Supplier supplier);
}
