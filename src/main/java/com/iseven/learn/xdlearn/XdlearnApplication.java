package com.iseven.learn.xdlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.iseven.learn.xdlearn.mapper")
@EnableTransactionManagement
public class XdlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdlearnApplication.class, args);
    }

}
