package com.lxj.manage.bean;

import java.io.Serializable;

/**
 * @author lxj
 *
 * 角色表  sys_role
 * */
public class SysRole implements Serializable {
    private Integer id;  //主键id
    private String name;  //角色名

    public SysRole () {}

    public SysRole(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
