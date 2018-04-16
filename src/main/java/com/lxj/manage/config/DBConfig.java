package com.lxj.manage.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * @author  lxj
 *
 * 连接mysql数据库
 * */
@Configuration
public class DBConfig {
    @Autowired
    private Environment environment;  //获取配置文件中的mysql连接信息

    //设置数据源
    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("ms.db.driverClassName"));
        dataSource.setJdbcUrl(environment.getProperty("ms.db.url"));
        dataSource.setUser(environment.getProperty("ms.db.username"));
        dataSource.setPassword(environment.getProperty("ms.db.password"));

        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(5);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(300);
        dataSource.setAcquireIncrement(5);
        dataSource.setIdleConnectionTestPeriod(60);

        return  dataSource;
    }
}
