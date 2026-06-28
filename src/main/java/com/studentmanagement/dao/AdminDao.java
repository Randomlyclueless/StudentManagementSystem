package com.studentmanagement.dao;

import com.studentmanagement.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    public boolean login(String username, String password) {

        try {
            Connection connection = DBConnection.getConnection();

            String loginQuery = """
                    SELECT * FROM admin
                    WHERE username = ? AND password = ?
                    """;

            PreparedStatement ps = connection.prepareStatement(loginQuery);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();

            boolean isLoggedIn = resultSet.next();

            resultSet.close();
            ps.close();
            connection.close();

            return isLoggedIn;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}