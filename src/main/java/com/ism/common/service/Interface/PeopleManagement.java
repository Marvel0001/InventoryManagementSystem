package com.ism.common.service.Interface;

import com.ism.domain.Admin;

public interface PeopleManagement {
    String addAdmin(Admin admin);

    String selectAdminById(Integer adminId);

    String selectAllAdmin();

    String modifyAdmin(String type, String param, Integer adminId);

    String deleteAdmin(Admin admin);
}
