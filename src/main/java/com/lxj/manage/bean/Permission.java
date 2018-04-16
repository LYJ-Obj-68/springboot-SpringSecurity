package com.lxj.manage.bean;

import java.io.Serializable;

/**
 * @author lxj
 *
 * 权限管理表 Sys_Permission
 * */
public class Permission implements Serializable {
    private Integer id;  //主键id
    private String name;  //权限名称
    private String description;  //权限描述
    private String url;  //授权链接
    private Integer pid;  //父节点id

    public Permission () {

    }

    public Permission(String name, String description, String url, Integer pid) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "PermissionDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
