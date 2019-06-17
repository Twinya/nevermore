package com.qianmi.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by qianmi on 2017-06-16.
 * 第二个数据源配置
 */
@Configuration
@EnableTransactionManagement
public class FirstConfig {


    @Bean
    @ConfigurationProperties("first.datasource")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="gxTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(firstDataSource());
    }


}
