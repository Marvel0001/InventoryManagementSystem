package com.ims.security.realm;

import com.ims.dao.UserMapper;
import com.ims.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = getName();
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String principal = usernamePasswordToken.getUsername();
        User user = userMapper.selectUserByUserid(principal);
        return new SimpleAuthenticationInfo(principal, user.getPassword(), name);
    }
}
