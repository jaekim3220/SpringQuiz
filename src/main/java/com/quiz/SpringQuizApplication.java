package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuizApplication.class, args);
	}

}
