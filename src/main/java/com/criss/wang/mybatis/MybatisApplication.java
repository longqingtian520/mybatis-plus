package com.criss.wang.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.criss.wang.mybatis.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class) // mybatisplus配置动态数据源时，切记需要关闭自带的自动数据源配置
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
