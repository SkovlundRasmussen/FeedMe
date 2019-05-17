package com.test_project.demo;

import Generators.UserGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingSpringApplication {

	// test
	public static void main(String[] args) {
	    SpringApplication.run(TestingSpringApplication.class, args);
        UserGenerator userGenerator = new UserGenerator();
        try {
            userGenerator.GenerateNameList();
            userGenerator.generateUser(99);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
//Hej med dig jeg