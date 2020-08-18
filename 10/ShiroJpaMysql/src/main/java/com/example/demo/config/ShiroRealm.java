package com.example.demo.config;

import com.example.demo.entity.Admin;
import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRole;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Tang on 2020/8/18
 */
public class ShiroRealm extends AuthorizingRealm {

    //权限授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //拿到用户信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin adminInfo = (Admin) principals.getPrimaryPrincipal();

        for (SysRole role : adminInfo.getRoleList()) {
            //将角色放入SimpleAuthorizationInfo
            info.addRole(role.getRole());
            //用户拥有的权限
            for (SysPermission p : role.getPermissions()) {
                info.addStringPermission(p.getPermission());
            }
        }
        return info;

    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的账号
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库查找User对象
        //Shiro有时间间隔机制,两分钟内不会重复执行该方法
        //获取用户信息

        return null;
    }
}
