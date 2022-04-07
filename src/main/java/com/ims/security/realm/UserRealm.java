package com.ims.security.realm;

import com.ims.dao.UserMapper;
import com.ims.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        HashSet<String> set = new HashSet<>();
        set.add("admin");
        return new SimpleAuthorizationInfo(set);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = getName();
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String principal = usernamePasswordToken.getUsername();
        User user = userMapper.selectUserByUsername(principal);
        return new SimpleAuthenticationInfo(principal, user.getPassword(), name);
    }
}
