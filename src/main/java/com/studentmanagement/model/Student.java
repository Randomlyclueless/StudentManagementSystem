package com.studentmanagement.model;

public class Student {
    private int id;
    private String name;
    private String dept;
    private String email;
    private String phone;
    private String rollNo;
    private double marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Student(String rollNo,String name,String dept , String email,String phone,double marks){
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
        this.dept = dept;

    }
    public Student(){

    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", rollno='" + rollNo + '\'' +
                ", marks=" + marks +
                '}';
    }
}
