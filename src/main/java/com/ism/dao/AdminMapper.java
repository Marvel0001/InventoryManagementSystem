package com.ism.dao;

import com.ism.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    void addAdmin(Admin admin);

    Admin selectAdminById(Integer adminId);

    List<Admin> selectAllAdmin();

    void modifyAdmin(Admin admin);

    void deleteAdmin(Admin admin);
}
