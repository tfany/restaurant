package com.codeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.codeorder.mapper")
public class RestaurantApplication{

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

}
