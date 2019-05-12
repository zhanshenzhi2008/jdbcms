package com.orjrs.jdbcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.orjrs.jdbcms.mapper")
public class JdbcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcmsApplication.class, args);
    }

}
