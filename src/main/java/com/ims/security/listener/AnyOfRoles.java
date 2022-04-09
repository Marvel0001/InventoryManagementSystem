package com.ims.security.listener;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AnyOfRoles extends RolesAuthorizationFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        Subject subject = getSubject(request, response);
        String[] roles = (String[]) mappedValue;
        if(roles == null || roles.length == 0)
            return true;
        for(String role: roles)
            if(subject.hasRole(role))
                return true;
        return false;
    }

}
