package com.lxj.manage.dao;

import com.lxj.manage.bean.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lxj
 *
 * 权限管理Dao接口
 * */
@Repository
public interface PermissionDao {
    List<Permission> findAll();  //查询所有权限
    List<Permission> findByAdminUserId (Integer userId);  //根据用户id查询相应权限
}
