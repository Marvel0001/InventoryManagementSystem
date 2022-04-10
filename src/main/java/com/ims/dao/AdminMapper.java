package com.ims.dao;

import com.ims.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface AdminMapper {
    void addAdmin(Admin admin);

    ArrayList<Admin> selectAdminById(@Param("adminId") Integer adminId);

    ArrayList<Admin> selectAdminByName(@Param("name")String name);

    ArrayList<Admin> selectAdminByStorehouseId(@Param("storehouseId")Integer storehouseId);

    ArrayList<Admin> selectAllAdmin();

    void modifyAdmin(Admin admin);

    void deleteAdmin(Admin admin);
}
