package com.lxj.manage.service;

import com.lxj.manage.bean.Permission;
import com.lxj.manage.bean.SysRole;
import com.lxj.manage.bean.SysUser;
import com.lxj.manage.dao.PermissionDao;
import com.lxj.manage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaojie
 *
 * 将用户权限交给springsecurity管控(UserDetailsService自定义接口)
 * */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    //重写loadUserByUsername方法获取 userdetails 类型用户
    @Override
    public UserDetails loadUserByUsername(String name) {
        SysUser user = userDao.findByUserName(name);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //将权限信息添加到 GrantedAuthority 对象中，在后面进行权限验证时会用 GrantedAuthority 此对象
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        }else {
            throw new UsernameNotFoundException("admin"+name+"do not exist!");
        }
    }
}
