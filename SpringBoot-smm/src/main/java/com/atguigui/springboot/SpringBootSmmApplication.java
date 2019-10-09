package com.atguigui.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.atguigui.springboot.mapper")//指定包扫描mapper
public class SpringBootSmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmmApplication.class, args);
	}

}
