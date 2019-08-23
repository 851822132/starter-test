package com.ysh.jdbcstarter;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author ysh
 */
@Configuration
@ConditionalOnProperty(prefix = "myDataSource", value = "enabled", havingValue = "true")
@EnableConfigurationProperties(JdbcProerties.class)
public class JdbcAutoConfigrution {

    @Bean
    public DataSource dataSource(JdbcProerties jdbcProerties){
        System.out.println("初始化一个druid连接池");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcProerties.getUrl());
        dataSource.setUsername(jdbcProerties.getUsername());
        dataSource.setPassword(jdbcProerties.getPassword());
        dataSource.setDriverClassName(jdbcProerties.getDriverClassName());
        return dataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate();
//    }
}
