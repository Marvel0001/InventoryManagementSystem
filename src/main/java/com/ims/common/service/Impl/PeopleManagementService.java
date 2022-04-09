package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.PeopleManagement;
import com.ims.common.util.Response;
import com.ims.dao.AdminMapper;
import com.ims.domain.Admin;
import com.ims.util.aop.UserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Scope
public class PeopleManagementService implements PeopleManagement {
    @Autowired
    AdminMapper adminMapper;

    final String SELECT = "SELECT";
    final String INSERT = "INSERT";
    final String DELETE = "DELETE";
    final String MODIFY = "MODIFY";

    @Override
    public String addAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(verification(admin, response, INSERT)){
            try {
                adminMapper.addAdmin(admin);
                response.success();
            }catch (Exception e){
                response.exception("参数不足");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String selectAdminById(Integer adminId) {
        ArrayList<Admin> admins = adminMapper.selectAdminById(adminId);
        return selectCommon(admins);
    }

    public String selectAdminByName(String name, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAdminByName(name);
        return selectCommon(admins);
    }

    public String selectAdminByStorehouseId(Integer storehouseId, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAdminByStorehouseId(storehouseId);
        return selectCommon(admins);
    }

    @Override
    @UserOperation(value = "selectAllAdmin")
    public String selectAllAdmin(Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAllAdmin();
        return selectCommon(admins);
    }

    public String selectCommon(ArrayList<Admin> admins){
        Response response = Response.generateResponse();
        int length = admins.size();
        if(length > 0){
            ArrayList<String> data =new ArrayList<>();
            for(Admin admin : admins){
                data.add(admin.toString());
            }
            response.success();
            response.setData(data.toString());
            response.setLength(length);
        }
        else{
            response.exception("找不到该管理员");
        }
        return response.toJSONString();
    }

    @Override
    public String modifyAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(verification(admin, response, MODIFY)){
            try{
                adminMapper.modifyAdmin(admin);
                response.success();
            }catch (Exception e){
                response.exception("修改失败");
            }
        }
        return response.toJSONString();
    }

    @Override
    public String deleteAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(verification(admin, response, DELETE)){
            try {
                adminMapper.deleteAdmin(admin);
                response.success();
            }catch (Exception e){
                response.exception("删除失败");
            }
        }
        return response.toJSONString();
    }

    private boolean verification(Admin admin, Response response, String operation){
        if(admin == null){
            response.exception("参数不能为空");
            return false;
        }
        switch (operation){
            case INSERT:
            case SELECT:
                break;
            case MODIFY:
            case DELETE:
                if(admin.getId() == 0){
                    response.exception("id不能为空");
                    return false;
                }
        }
        return true;
    }

    @Override
    @UserOperation(value = "selectByUsername")
    public Admin _selectByUsername(String name){
        return adminMapper.selectAdminByName(name).get(0);
    }
}
