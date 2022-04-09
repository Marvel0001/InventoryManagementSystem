package com.ims.security.service;

import com.ims.dao.ActionMapper;
import com.ims.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FilterChainBuilder {

    @Autowired
    ActionMapper actionMapper;

    public LinkedHashMap<String, String> builder(){
        LinkedHashMap<String, String> permission = new LinkedHashMap<>();
        permission.put("/js/**", "anon");
        permission.put("/Page/**", "anon");
        ArrayList<Action> actions = actionMapper.selectAllAction();
        for(Action action: actions){
            if(action.getPermission().equals("1")){
                permission.put(action.getKeyword() + "/**", "authc,roles[systemAdmin]");
            }
            else{
                permission.put(action.getKeyword() + "/**","authc,roles[systemAdmin, commonAdmin]");
            }
        }
        permission.put("/", "authc");
        return permission;
    }
}
