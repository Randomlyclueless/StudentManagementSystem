package com.studentmanagement;

import com.studentmanagement.dao.DatabaseInitializer;
import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.model.Student;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();
        Student student = new Student();
        student.setRollNo("101");
        student.setName("Kimaya");
        student.setDept("AIDS");
        student.setEmail("example@gmail.com");
        student.setPhone("9876543210");
        student.setMarks(70);

//        StudentDao studentDao = new StudentDao();
//        studentDao.insertStudent(student);
//          studentDao.viewAllStudents();

//        Student student2 = studentDao.searchStudent("101");
//        if (student2 != null) {
//            System.out.println(student);
//        } else {
//            System.out.println("Student not found!");
//        }

        Student student2 = new Student();

        student2.setRollNo("101");
        student2.setName("Kimaya");
        student2.setDept("AIDS");
        student2.setEmail("example@gmail.com");
        student2.setPhone("9876543210");
        student2.setMarks(90);

        StudentDao studentDao = new StudentDao();
        studentDao.updateStudent(student2);
//        studentDao.viewAllStudents();
        studentDao.deleteStudent("101");
        studentDao.viewAllStudents();


    }
}