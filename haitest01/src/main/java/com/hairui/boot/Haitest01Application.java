package com.hairui.boot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@MapperScan("com.hairui.boot.mapper")
//@Import(FdfsClientConfig.class)
@SpringBootApplication
public class Haitest01Application {

    public static void main(String[] args) {
        SpringApplication.run(Haitest01Application.class, args);
    }

}
