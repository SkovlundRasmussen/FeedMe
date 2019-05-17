package com.test_project.demo.service;


import com.test_project.demo.model.Role;
import com.test_project.demo.model.User;
import com.test_project.demo.model.Users;

import java.sql.*;
import java.util.Set;

public class DatabaseService {

    String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=FeedMe;user=sa;password=Test1234";
    String SQL;
    ResultSet rs;

    public void databaseConnection() {
        Users user = new Users();
        user.setFirstName("Casper");
        user.setLastName("Larsen");
        user.setEmail("casper.larsen@gmail.com");
        user.setPassword("Test123");
        user.setRoleId(1);
        createUser(user);
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

    void createUser(Users nu) {

        try (Connection connection = DriverManager.getConnection(connectionURL);) {
            String query = "INSERT INTO Users(firstname, lastname, email, password, role_id) VALUES(?, ?, ?, ?, ? )";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nu.firstName);
            preparedStatement.setString(2, nu.lastName);
            preparedStatement.setString(3, nu.email);
            preparedStatement.setString(4, nu.password);
            preparedStatement.setInt(5, nu.roleId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
