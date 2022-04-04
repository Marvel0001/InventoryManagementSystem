package com.ism.common.service.Impl;

import com.ism.common.service.Interface.PeopleManagement;
import com.ism.common.util.Response;
import com.ism.dao.AdminMapper;
import com.ism.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleManagementService implements PeopleManagement {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public String addAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(admin != null){
            try {
                adminMapper.addAdmin(admin);
                response.setResult("success");
            }catch (Exception e){
                response.setResult("failure");
            }
        }
        else
            response.setResult("failure");
        return response.toJSONString();
    }

    @Override
    public String selectAdminById(Integer adminId) {
        return null;
    }

    @Override
    public String selectAllAdmin(){
        return null;
    }

    @Override
    public String modifyAdmin(String type, String param, Integer adminId) {
        return null;
    }

    @Override
    public String deleteAdmin(Admin admin) {
        return null;
    }
}
