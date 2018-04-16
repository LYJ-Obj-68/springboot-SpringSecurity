package com.lxj.manage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author lxj
 *
 * 用户表  sys_user
 * */
public class SysUser implements Serializable {
    private Integer id;  //主键id
    private String username;  //用户名
    private String password;  //密码

    private List<SysRole> roles;

    public SysUser() {}

    public SysUser(String username, String password, List<SysRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
