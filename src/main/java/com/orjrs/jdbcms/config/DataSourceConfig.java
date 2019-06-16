package com.orjrs.jdbcms.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liujun22
 * CreateDate:2019/3/10 19:24
 */
@Configuration
// 以前版本是不用配PropertySource的，自动根据application-后缀.yml来自动读取 但这里添加无效。 我暂时使用spring.profile.include
// @PropertySource(value = {"classpath:application-db.yml"}, ignoreResourceNotFound = true)
public class DataSourceConfig {

    //    /**
//     * 初始化 主库数据源配置 这种方法需要引入com.h2database包
//     *
//     * @return DataSourceProperties
//     */
//    @Primary
//    @Bean(name = "masterDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
//    public DataSourceProperties masterDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    /**
//     * 第一种方法来初始化 主库数据源 建议用第二种 省事儿
//     *
//     * @return DataSource
//     */
//    @Primary
//    @Bean(name = "masterDataSource")
//    public DataSource masterDataSource() {
//        return masterDataSourceProperties().initializeDataSourceBuilder().build();
//    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource() {
        //return DataSourceBuilder.create().type(HikariDataSource.class).build();
        return DataSourceBuilder.create().build();
    }

    /**
     * 第二种方法来初始化 从库数据源
     *
     * @return DataSource
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        //return DataSourceBuilder.create().type(HikariDataSource.class).build();
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slaveDataSource") DataSource slave1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        // DBTypeEnum.MASTER
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        routingDataSource.setTargetDataSources(targetDataSources);
        return routingDataSource;
    }
}
