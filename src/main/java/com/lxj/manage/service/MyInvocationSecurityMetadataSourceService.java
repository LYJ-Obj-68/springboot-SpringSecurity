package com.lxj.manage.service;

import com.lxj.manage.bean.Permission;
import com.lxj.manage.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lxj
 *
 * 拦截用户信息
 * */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionDao permissionDao;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有权限
     * */
    public void loadResourceDefine () {
        map = new HashMap<>();
        Collection<ConfigAttribute> collection;
        ConfigAttribute configAttribute;
        List<Permission> permissionList = permissionDao.findAll();
        for (Permission permission : permissionList) {
            collection = new ArrayList<>();
            /**
             * 此处只添加了用户的名字，其实还可以添加更多权限的信息，
             * 例如请求方法到ConfigAttribute的集合中去；此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
             * */
            configAttribute = new SecurityConfig(permission.getName());
            collection.add(configAttribute);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getUrl(),collection);
        }
    }

   /**
    * 此方法是为了判定用户请求的url 是否在权限表中，
    * 如果在权限表中，则返回给 decide 方法，
    * 用来判定用户是否有此权限。如果不在权限表中则放行。
    * */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map==null) {
            loadResourceDefine();
        }
        //object中包含了用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iterator = map.keySet().iterator();iterator.hasNext();) {
            resUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
