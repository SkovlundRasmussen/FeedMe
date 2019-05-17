package com.test_project.demo;

import Generators.UserGenerator;
import com.test_project.demo.model.User;
import com.test_project.demo.service.DatabaseService;
import com.test_project.demo.service.UserService;
import com.test_project.demo.service.UserServiceImplement;
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

            for (int i = 0; i < userGenerator.userList.size(); i++) {
                User newUser = (User) userGenerator.userList.get(i);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        DatabaseService dbService = new DatabaseService();
        dbService.databaseConnection();
	}
}
//Hej med dig jeg