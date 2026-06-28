package com.studentmanagement.dao;
import java.sql.*;

import com.studentmanagement.config.DBConnection;
import com.studentmanagement.model.Student;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

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
                if (e.getMessage().contains("Duplicate entry")) {
                    System.out.println("Student already exists!");
                } else {
                    System.out.println("Unable to insert student.");
                }
            }
    }
    public void viewAllStudents() {

        try {

            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM students";

            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.isBeforeFirst()) {
                System.out.println("\nNo students found.\n");

                resultSet.close();
                statement.close();
                connection.close();
                return;
            }

            System.out.println("\n========================================================================================================");
            System.out.printf("%-10s %-20s %-15s %-30s %-15s %-8s%n",
                    "Roll No", "Name", "Department", "Email", "Phone", "Marks");
            System.out.println("========================================================================================================");

            while (resultSet.next()) {

                System.out.printf("%-10s %-20s %-15s %-30s %-15s %-8.2f%n",
                        resultSet.getString("roll_no"),
                        resultSet.getString("name"),
                        resultSet.getString("dept"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getDouble("marks"));
            }

            System.out.println("========================================================================================================");

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to fetch student records.");
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
    public List<Student> searchByDepartment(String dept) {

        List<Student> students = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                SELECT * FROM students
                WHERE dept = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, dept);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setMarks(resultSet.getDouble("marks"));

                students.add(student);
            }

            resultSet.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to search by department.");
        }

        return students;
    }
    public List<Student> searchByMarks(double marks) {

        List<Student> students = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            String query = """
                SELECT * FROM students
                WHERE marks >= ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, marks);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setMarks(resultSet.getDouble("marks"));

                students.add(student);
            }

            resultSet.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to search by marks.");
        }

        return students;
    }
    public List<Student> searchByFirstLetter(char letter) {

        List<Student> students = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            String query = """
                SELECT * FROM students
                WHERE name LIKE ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, letter + "%");

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setMarks(resultSet.getDouble("marks"));

                students.add(student);
            }

            resultSet.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to search by first letter.");
        }

        return students;
    }
    public void updateName(String rollNo, String name) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                UPDATE students
                SET name = ?
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Name updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to update name.");
        }
    }
    public void updateDepartment(String rollNo, String dept) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                UPDATE students
                SET dept = ?
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, dept);
            ps.setString(2, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Department updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to update department.");
        }
    }
    public void updateEmail(String rollNo, String email) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                UPDATE students
                SET email = ?
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Email updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to update email.");
        }
    }
    public void updatePhone(String rollNo, String phone) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                UPDATE students
                SET phone = ?
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, phone);
            ps.setString(2, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Phone updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to update phone.");
        }
    }
    public void updateMarks(String rollNo, double marks) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = """
                UPDATE students
                SET marks = ?
                WHERE roll_no = ?
                """;

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setDouble(1, marks);
            ps.setString(2, rollNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Marks updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            ps.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Unable to update marks.");
        }
    }
}
