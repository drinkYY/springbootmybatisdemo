package com.example.springbootMybatisdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootMybatisdemo2.mapper")
public class SpringbootMybatisdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisdemo2Application.class, args);
	}

}
