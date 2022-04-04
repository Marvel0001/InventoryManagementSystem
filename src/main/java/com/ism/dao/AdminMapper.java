package com.ism.dao;

import com.ism.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    void addAdmin(Admin admin);

    List<Admin> selectAdminById(@Param("adminId") Integer adminId);

    List<Admin> selectAdminByName(@Param("name")String name);

    List<Admin> selectAdminByStorehouseId(@Param("storehouseId")Integer storehouseId);

    List<Admin> selectAllAdmin();

    void modifyAdmin(Admin admin);

    void deleteAdmin(Admin admin);
}
