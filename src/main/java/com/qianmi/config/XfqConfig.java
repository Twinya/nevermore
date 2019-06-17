package com.qianmi.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
public class XfqConfig {


    /**
     * 数据源对象
     * @return
     */
    @Bean
    @ConfigurationProperties("xfq.datasource")
    public DataSource xfqDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "xfqTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(xfqDataSource());
    }

}
