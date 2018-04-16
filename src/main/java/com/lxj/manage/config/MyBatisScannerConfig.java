package com.lxj.manage.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ljx
 *
 * dao扫描器
 * */
@Configuration
public class MyBatisScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer () {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.lxj.manage.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }
}
