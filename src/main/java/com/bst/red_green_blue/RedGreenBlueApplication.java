package com.bst.red_green_blue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bst.red_green_blue.dao")
public class RedGreenBlueApplication {


	public static void main(String[] args) {
		SpringApplication.run(RedGreenBlueApplication.class, args);
	}
}
