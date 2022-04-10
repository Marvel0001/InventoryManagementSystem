package com.ims.common.service.Interface;

import com.ims.domain.Customer;

import java.util.ArrayList;


public interface CustomerManagement {
    /**
     * 添加顾客信息
     * @param customer 要添加的顾客对象 除了预定货物与id之外的属性必须赋值
     * @return 添加结果
     */
    String addCustomer(Customer customer);

    /**
     * 通用结果处理方法
     * @param customers 要处理的结果
     * @return 处理后的json字符串
     */
    String _selectCommon(ArrayList<Customer> customers);

    /**
     * 通过顾客id查询
     * @param id 用户id
     * @return 处理方法处理后的结果
     */
    String selectCustomerById(Integer id);

    /**
     * 通过公司名称查询
     * @param company 公司名称
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 处理方法处理后的结果
     */
    String selectCustomerByCompany(String company, Integer offset, Integer limit);

    /**
     * 通过联系人姓名查询
     * @param person 联系人姓名
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 处理方法处理后的结果
     */
    String selectCustomerByPerson(String person, Integer offset, Integer limit);

    /**
     * 查询全部顾客
     * @param offset 偏移量
     * @param limit 查询数量
     * @return 处理方法处理后的结果
     */
    String selectAllCustomer(Integer offset, Integer limit);

    /**
     * 修改顾客属性
     * @param customer 待修改的顾客实例，会将赋值之后的属性提交至数据库，id除外，id为必须
     * @return 修改结果
     */
    String modifyCustomer(Customer customer);

    /**
     * 删除顾客
     * @param customer 顾客实例，仅赋值id即可
     * @return 删除结果
     */
    String deleteCustomer(Customer customer);

}
