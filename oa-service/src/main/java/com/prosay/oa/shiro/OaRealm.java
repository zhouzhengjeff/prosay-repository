package com.prosay.oa.shiro;

import com.prosay.oa.domain.User;
import com.prosay.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OaRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public String getName() {
        return "OaRealm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String) authenticationToken.getPrincipal();
        User user = this.userService.findUserByName(name);
        if (user == null) {
            return null;
        }

        String password = user.getUserPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, password, this.getName());

        return simpleAuthenticationInfo;
    }

    /*@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        List<String> roleNameList = new ArrayList<>();

        String name = (String) principalCollection.getPrimaryPrincipal();
        List<Role> roleList = this.userService.findAllRoleListByName(name);
        if (CollectionUtils.isNotEmpty(roleList)) {
            for (Role role : roleList) {
                roleNameList.add(role.getRoleName());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleNameList);


        return simpleAuthorizationInfo;
    }*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        List<String> privilegeCodeList = new ArrayList<>();

        // 获取主身份信息
        String loginName = (String) principalCollection.getPrimaryPrincipal();

        // 根据身份信息查询该用户的所有的权限信息
        privilegeCodeList = this.userService.findAllPrivilegeCodeListByLoginName(loginName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(privilegeCodeList);

        return simpleAuthorizationInfo;
    }

    /**
     * 提供一个清空缓存的方法
     */
    public void clearCache() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }
}
