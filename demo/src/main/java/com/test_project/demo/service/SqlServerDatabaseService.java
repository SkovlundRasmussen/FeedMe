package com.test_project.demo.service;


import Generators.UserGenerator;
import com.test_project.demo.model.CustomerInfo;
import com.test_project.demo.model.Role;
import com.test_project.demo.model.User;
import com.test_project.demo.model.Users;

import java.sql.*;
import java.util.Set;

public class SqlServerDatabaseService {

    String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=FeedMe;user=sa;password=Test1234";
    String SQL;
    ResultSet rs;

    public void databaseConnection() {
        UserGenerator ug = new UserGenerator();
        System.out.println("------------------------dasdsadasda" );
        UserGenerator userGenerator = new UserGenerator();
        try {
            userGenerator.GenerateNameList();
            userGenerator.generateUser(99);

            System.out.println("------------------------dasdsadasda" );
            for (int i = 0; i < userGenerator.userList.size()-1; i++) {
                Users newUser = (Users) userGenerator.userList.get(i);
                CustomerInfo customerInfo = (CustomerInfo) userGenerator.addressList.get(i);
                System.out.println(newUser.firstName + "----" + customerInfo.getStreetName());
                createUser(newUser, customerInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getUsersRoles() {
        try (Connection connection = DriverManager.getConnection(connectionURL); Statement stmt = connection.createStatement();) {
            SQL = "SELECT * FROM UsersRole";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("role_id") + " " + rs.getString("role_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for creating a new user in the
    public void createUser(Users nu, CustomerInfo info) {

        try (Connection connection = DriverManager.getConnection(connectionURL);) {

            // Query string for inserting a new user.
            String query = "INSERT INTO Users(firstname, lastname, email, password, role_id) VALUES(?, ?, ?, ?, ? ); SELECT SCOPE_IDENTITY();";
            // Preparing the statement.
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nu.firstName);
            preparedStatement.setString(2, nu.lastName);
            preparedStatement.setString(3, nu.email);
            preparedStatement.setString(4, nu.password);
            preparedStatement.setInt(5, nu.roleId);

            // Executing the prepared statement.
            preparedStatement.execute();

            String query2 = "INSERT INTO CustomerInfo(street_name, street_number, postal_code, city, user_id) VALUES (?,?,?,?, @@IDENTITY)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setString(1, info.getStreetName());
            preparedStatement2.setString(2, info.getStreetNumber());
            preparedStatement2.setInt(3, info.getPostalCode());
            preparedStatement2.setString(4,info.getCity());
            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createAddress() {

    }
}
