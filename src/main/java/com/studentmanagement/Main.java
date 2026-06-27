package com.studentmanagement;

import com.studentmanagement.model.Admin;
import com.studentmanagement.model.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("kimaya");
        System.out.println(s1);
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin123");
        System.out.println(admin);
        }
    }
