package com.studentmanagement.dao;
import java.sql.*;

import com.studentmanagement.config.DBConnection;
import com.studentmanagement.model.Student;

import java.sql.Connection;

public class StudentDao {
    public void insertStudent(Student student){
            try{
                Connection connection = DBConnection.getConnection();
                String insertQuery = """
                    INSERT INTO students
                    (roll_no, name, dept, email, phone, marks)
                    VALUES (?, ?, ?, ?, ?, ?)
                    """;
                PreparedStatement ps = connection.prepareStatement(insertQuery);
                ps.setString(1, student.getRollNo());
                ps.setString(2, student.getName());
                ps.setString(3, student.getDept());
                ps.setString(4, student.getEmail());
                ps.setString(5, student.getPhone());
                ps.setDouble(6, student.getMarks());

                int rowsAffected = ps.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("Student data inserted successfully");
                }

                ps.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();            }
    }
    public void viewAllStudents(){
        try{
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = """
                    SELECT * FROM students
                    """;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("Roll No: " + resultSet.getString("roll_no"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Department: " + resultSet.getString("dept"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Marks: " + resultSet.getDouble("marks"));
                System.out.println("---------------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();

    } catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void updateStudent(Student student){
        try{
            Connection connection = DBConnection.getConnection();

            String updateQuery = """
                UPDATE students
                SET name=?, dept=?, email=?, phone=?, marks=?
                WHERE roll_no=?
                """;
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, student.getName());
            ps.setString(2, student.getDept());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setDouble(5, student.getMarks());
            ps.setString(6, student.getRollNo());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Student updated successfully!");
            }else{
                System.out.println("Student not found!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteStudent(String rollNo) {

        try {
            Connection connection = DBConnection.getConnection();

            String deleteQuery = """
                DELETE FROM students
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(deleteQuery);

            ps.setString(1, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student searchStudent(String rollNo) {
        try{
            Connection connection   = DBConnection.getConnection();
            String  searchStudentQuery = """
                    SELECT * from students WHERE roll_no = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(searchStudentQuery);
            ps.setString(1,rollNo);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setMarks(resultSet.getDouble("marks"));

                return student;

            }
            resultSet.close();
            ps.close();
            connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
