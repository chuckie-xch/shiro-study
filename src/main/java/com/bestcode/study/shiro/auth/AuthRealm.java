package com.bestcode.study.shiro.auth;

import com.bestcode.study.shiro.model.Permission;
import com.bestcode.study.shiro.model.Role;
import com.bestcode.study.shiro.model.User;
import com.bestcode.study.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xch
 * @create 2018-01-09 21:50
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions = new ArrayList<String>();
        List<String> roleNames = new ArrayList<String>();
        Set<Role> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Role role : roles) {
                roleNames.add(role.getName());
               Set<Permission> permissionSet = role.getPermissions();
               for (Permission permission :permissionSet) {
                   permissions.add(permission.getName());
               }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRoles(roleNames);
        return info;
    }

    /**
     * 认证登录
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(), getClass().getName());
    }
}
