package com.bestcode.study.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = {"com.bestcode.study.shiro.mapper"})
public class ShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);
	}
}
