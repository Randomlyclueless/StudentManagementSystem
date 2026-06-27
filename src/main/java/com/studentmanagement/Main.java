package com.studentmanagement;

import com.studentmanagement.config.DBConnection;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Database Connection Failed!");
        }

    }
}