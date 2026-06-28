package com.studentmanagement.service;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDao();
    }

    // Create
    public void addStudent(Student student) {
        studentDao.insertStudent(student);
    }

    // Read
    public void viewAllStudents() {
        studentDao.viewAllStudents();
    }

    public Student searchStudent(String rollNo) {
        return studentDao.searchStudent(rollNo);
    }

    public List<Student> searchByDepartment(String dept) {
        return studentDao.searchByDepartment(dept);
    }

    public List<Student> searchByMarks(double marks) {
        return studentDao.searchByMarks(marks);
    }

    public List<Student> searchByFirstLetter(char letter) {
        return studentDao.searchByFirstLetter(letter);
    }

    // Update
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void updateName(String rollNo, String name) {
        studentDao.updateName(rollNo, name);
    }

    public void updateDepartment(String rollNo, String dept) {
        studentDao.updateDepartment(rollNo, dept);
    }

    public void updateEmail(String rollNo, String email) {
        studentDao.updateEmail(rollNo, email);
    }

    public void updatePhone(String rollNo, String phone) {
        studentDao.updatePhone(rollNo, phone);
    }

    public void updateMarks(String rollNo, double marks) {
        studentDao.updateMarks(rollNo, marks);
    }

    // Delete
    public void deleteStudent(String rollNo) {
        studentDao.deleteStudent(rollNo);
    }
}