
//StudentDAO is responsible for all database operations related to students.


package com.studentmanagement.dao;
//import com.mysql.cj.protocol.Resultset;
import com.studentmanagement.config.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;

public class DatabaseInitializer {

    public static void initialize() {
//        This method will be responsible for initializing the database when the application starts.
//
//                Later it will:
//
//        Get a database connection.
//        Create the admin table.
//        Create the students table.
//        Insert a default admin if one doesn't exist.
        try{
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String createStudentTable = """
                    CREATE TABLE IF NOT EXISTS students(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        roll_no VARCHAR(20) UNIQUE NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        dept VARCHAR(50) NOT NULL,
                        email VARCHAR(100) UNIQUE NOT NULL,
                        phone VARCHAR(15),
                        marks DOUBLE
                    )
                    """;
            statement.executeUpdate(createStudentTable);
            System.out.println("Students table created successfully!");

            String createAdminTable = """
                    CREATE TABLE IF NOT EXISTS admin (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(100) NOT NULL
                    )
                    """;

            statement.executeUpdate(createAdminTable);
            System.out.println("Admin table created successfully!");
            System.out.println("Database initialized successfully!");

            String checkAdminQuery  = """
                    SELECT * FROM admin WHERE username = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(checkAdminQuery);

            ps.setString(1,"admin");
            ResultSet resultSet = ps.executeQuery();
            statement.close();

            if(!resultSet.next()){
                String addAdmin = """
                            INSERT INTO admin(username,password) VALUES(?,?)
                            """;
                PreparedStatement insertPS = connection.prepareStatement(addAdmin);
                insertPS.setString(1, "admin");
                insertPS.setString(2, "admin123");

                insertPS.executeUpdate();
                System.out.println("Default admin inserted successfully!");

            }




            connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}