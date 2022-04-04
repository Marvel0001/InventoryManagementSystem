package com.ism.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ism.common.service.Interface.PeopleManagement;
import com.ism.common.util.Response;
import com.ism.dao.AdminMapper;
import com.ism.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                response.success();
            }catch (Exception e){
                response.failure();
                response.setData("参数不足");
            }
        }
        else {
            response.failure();
            response.setData("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String selectAdminById(Integer adminId) {
        List<Admin> admins = adminMapper.selectAdminById(adminId);
        return selectCommon(admins);
    }

    public String selectAdminByName(String name, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Admin> admins = adminMapper.selectAdminByName(name);
        return selectCommon(admins);
    }

    public String selectAdminByStorehouseId(Integer storehouseId, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Admin> admins = adminMapper.selectAdminByStorehouseId(storehouseId);
        return selectCommon(admins);
    }

    @Override
    public String selectAllAdmin(Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        List<Admin> admins = adminMapper.selectAllAdmin();
        return selectCommon(admins);
    }

    public String selectCommon(List<Admin> admins){
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
            response.failure();
            response.setData("未找到管理员");
        }
        return response.toJSONString();
    }

    @Override
    public String modifyAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(admin != null){
            try{
                adminMapper.modifyAdmin(admin);
                response.success();
            }catch (Exception e){
                response.failure();
                response.setData("修改失败");
            }
        }
        else{
            response.failure();
            response.setData("参数不足");
        }
        return response.toJSONString();
    }

    @Override
    public String deleteAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(admin != null){
            try {
                adminMapper.deleteAdmin(admin);
                response.success();
            }catch (Exception e){
                response.failure();
                response.setData("删除失败");
            }
        }
        else{
            response.failure();
            response.setData("参数不足");
        }
        return response.toJSONString();
    }
}
