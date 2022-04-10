package com.ims.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.ims.common.service.Interface.PeopleManagement;
import com.ims.common.util.Response;
import com.ims.dao.AdminMapper;
import com.ims.dao.StorehouseMapper;
import com.ims.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PeopleManagementService implements PeopleManagement {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    StorehouseMapper storehouseMapper;

    final String SELECT = "SELECT";
    final String INSERT = "INSERT";
    final String DELETE = "DELETE";
    final String MODIFY = "MODIFY";

    @Override
    public String addAdmin(Admin admin) {
        Response response = Response.generateResponse();
        if(_verification(admin, response, INSERT)){
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
        return _selectCommon(admins);
    }

    @Override
    public String selectAdminByName(String name, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAdminByName(name);
        return _selectCommon(admins);
    }

    @Override
    public String selectAdminByStorehouseId(Integer storehouseId, Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAdminByStorehouseId(storehouseId);
        return _selectCommon(admins);
    }

    @Override
    public String selectAllAdmin(Integer offset, Integer limit){
        if(offset >= 0 && limit > 0)
            PageHelper.offsetPage(offset, limit);
        ArrayList<Admin> admins = adminMapper.selectAllAdmin();
        return _selectCommon(admins);
    }

    @Override
    public String _selectCommon(ArrayList<Admin> admins){
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
        if(_verification(admin, response, MODIFY)){
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
        if(_verification(admin, response, DELETE)){
            try {
                adminMapper.deleteAdmin(admin);
                response.success();
            }catch (Exception e){
                response.exception("删除失败");
            }
        }
        return response.toJSONString();
    }

    private boolean _verification(Admin admin, Response response, String operation){
        if(admin == null){
            response.exception("参数不能为空");
            return false;
        }
        switch (operation){
            case INSERT:
            case MODIFY:
                if(admin.getName() != null){
                    if(adminMapper.selectAdminByName(admin.getName()) != null){
                        response.exception("数据库已存在重名管理员");
                        return false;
                    }
                }
                return _verification_rolesAndStorehouse(admin, response);
            case SELECT:
            case DELETE:
                if(admin.getId() == 0){
                    response.exception("id不能为空");
                    return false;
                }
        }
        return true;
    }

    public boolean _verification_rolesAndStorehouse(Admin admin, Response response){
        if(admin.getRole() != null){
            if (!admin.getRole().equals("systemAdmin") && !admin.getRole().equals("commonAdmin")) {
                response.exception("权限设置错误");
                return false;
            }
        }
        if(admin.getStorehouseId() != null){
            ArrayList<Integer> storehouseIds = storehouseMapper.selectAllStorehouseId();
            if(!storehouseIds.contains(admin.getStorehouseId())){
                response.exception("仓库设置错误");
                return false;
            }
        }
        return true;
    }

    @Override
    public Admin _selectByUsername(String name){
        return adminMapper.selectAdminByName(name).get(0);
    }
}
