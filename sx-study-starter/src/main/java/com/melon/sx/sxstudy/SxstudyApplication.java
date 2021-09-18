package com.melon.sx.sxstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.melon.sx.study.mapper")
@SpringBootApplication(scanBasePackages="com.melon")
public class SxstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SxstudyApplication.class, args);
	}

}
