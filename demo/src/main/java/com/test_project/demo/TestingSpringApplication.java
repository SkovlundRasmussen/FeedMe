package com.test_project.demo;

import Generators.UserGenerator;
import com.test_project.demo.model.MenuItem;
import com.test_project.demo.model.RestaurantAddress;
import com.test_project.demo.model.RestaurantMenu;
import com.test_project.demo.model.User;
import com.test_project.demo.service.SqlServerDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestingSpringApplication {

	public static void main(String[] args) {
	    SpringApplication.run(TestingSpringApplication.class, args);
        SqlServerDatabaseService dbService = new SqlServerDatabaseService();
        dbService.databaseConnection();

		MenuItem test1Item = new MenuItem(1,"Margherita", 48.00, "pizza");
		MenuItem test2Item = new MenuItem(2, "Vesuvio", 54.00, "pizza");

		List testMenu = new ArrayList<MenuItem>();
		testMenu.add(test1Item);
		testMenu.add(test2Item);

		dbService.databaseConnection();

	}
}