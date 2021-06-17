package com.example.springbootwebadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan(basePackages = "com.example.springbootwebadmin")
@MapperScan("com.example.springbootwebadmin.mapper")
@SpringBootApplication
public class SpringBootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebAdminApplication.class, args);
    }

}
