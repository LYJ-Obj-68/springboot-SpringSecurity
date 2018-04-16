package com.lxj.manage.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author lxj
 *
 * 扫描mapper.xml文件
 * */
@Configuration
@ComponentScan
public class MyBatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
        return sqlSessionFactory;
    }
}
