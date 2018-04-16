package com.lxj.manage.dao;

import com.lxj.manage.bean.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author lxj
 *
 * UserDao接口
 * */
@Repository
public interface UserDao {
    public SysUser findByUserName(String username);
}
