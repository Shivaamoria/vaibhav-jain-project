package com.Food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class FriendsFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsFoodApplication.class, args);
	}

}
