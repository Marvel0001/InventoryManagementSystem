package com.ims.security.realm;

import com.ims.common.service.Interface.GoodManagement;
import com.ims.common.service.Interface.PeopleManagement;
import com.ims.domain.Admin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service(value = "userRealm")
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private PeopleManagement peopleManagement;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        HashSet<String> role = new HashSet<>();
        Admin admin = peopleManagement._selectByUsername(principalCollection.getPrimaryPrincipal().toString());
        if(admin != null)
            role.add(admin.getRole());
        return new SimpleAuthorizationInfo(role);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = getName();
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String principal = usernamePasswordToken.getUsername();
        Admin admin = peopleManagement._selectByUsername(principal);
        return new SimpleAuthenticationInfo(principal, admin.getPassword(), name);
    }
}
