package com.lxj.manage.service;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author lxj
 *
 *  获取用户权限信息
 * */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     * 通过传递的参数来决定用户是否有访问对应受保护对象的权限
     *
     * @param authentication 当前正在请求受保护对象的Authentication。
     *       是将CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
     *
     * @param object 受保护对象，其可以是一个MethodInvocation、JoinPoint或FilterInvocation。
     *       包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
     *
     * @param configAttributes 与正在请求的受保护对象相关联的配置属性
     *       为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，
     *       此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。
     *       如果不在权限表中则放行。
     * */

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null || configAttributes.size()<=0) {
            return;
        }
        ConfigAttribute ca;
        String needRole;
        for (Iterator<ConfigAttribute> iter = configAttributes.iterator();iter.hasNext();) {
            ca = iter.next();
            needRole = ca.getAttribute();
            //authentication 是CustomUserService中设置好的，将它循环添加到 GrantedAuthority 对象中的权限信息集合
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    /**
     * 表示当前AccessDecisionManager是否支持对应的ConfigAttribute
     * */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 表示当前AccessDecisionManager是否支持对应的受保护对象类型
     * */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
