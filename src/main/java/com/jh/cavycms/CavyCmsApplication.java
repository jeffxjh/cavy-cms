package com.jh.cavycms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com.jh.cavycms.mapper"})
@SpringBootApplication
public class CavyCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CavyCmsApplication.class, args);
    }

}
