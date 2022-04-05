package com.ims.common.service.Interface;

import com.ims.domain.Admin;

public interface PeopleManagement {
    String addAdmin(Admin admin);

    String selectAdminById(Integer adminId);

    String selectAdminByStorehouseId(Integer storehouseId, Integer offset, Integer limit);

    String selectAdminByName(String name, Integer offset, Integer limit);

    String selectAllAdmin(Integer offset, Integer limit);

    String modifyAdmin(Admin admin);

    String deleteAdmin(Admin admin);
}
