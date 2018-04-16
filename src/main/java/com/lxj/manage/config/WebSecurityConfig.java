package com.lxj.manage.config;

import com.lxj.manage.service.CustomUserService;
import com.lxj.manage.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author lxj
 *
 * 管理控制用户登录权限
 * */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    //注册UserDetailsService中的bean
    @Bean
    public UserDetailsService customUserService(){
        return new CustomUserService();
    }

    //验证UserDetailService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/css/**").permitAll()  //允许所有用户访问"/"和"/index",css文件不被拦截
                .anyRequest().authenticated()  //任何请求,登录后都可以访问
                .and()
                .formLogin()
                .loginPage("/login")  //指定登录页面是"/login"
                .failureUrl("/login?error")
                .permitAll()  //登录页面任何用户都可以访问
                .and()
                .logout()
                .permitAll();
        httpSecurity.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
