package com.studentmanagement.ui;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.AdminService;
import com.studentmanagement.service.StudentService;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final AdminService adminService = new AdminService();

    public void start() {

        login();

        while (true) {

            System.out.println("\n========== Student Management System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    studentService.viewAllStudents();
                    break;

                case 3:
                    searchMenu();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private void login() {

        while (true) {

            System.out.println("\n========== Admin Login ==========");

            System.out.print("Username: ");
            String username = scanner.next();

            System.out.print("Password: ");
            String password = scanner.next();

            if (adminService.login(username, password)) {
                System.out.println("\nLogin Successful!");
                break;
            }

            System.out.println("Invalid Username or Password!");
        }
    }

    private void addStudent() {

        Student student = new Student();

        System.out.print("Enter Roll No: ");
        student.setRollNo(scanner.next());

        scanner.nextLine();

        System.out.print("Enter Name: ");
        student.setName(scanner.nextLine());

        if (student.getName().isBlank()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter Department: ");
        student.setDept(scanner.nextLine());

        System.out.print("Enter Email: ");
        student.setEmail(scanner.nextLine());

        if (!student.getEmail().contains("@")) {
            System.out.println("Invalid email.");
            return;
        }

        System.out.print("Enter Phone: ");
        student.setPhone(scanner.nextLine());

        if (student.getPhone().length() != 10) {
            System.out.println("Phone number must contain exactly 10 digits.");
            return;
        }

        System.out.print("Enter Marks: ");
        student.setMarks(scanner.nextDouble());

        if (student.getMarks() < 0 || student.getMarks() > 100) {
            System.out.println("Marks should be between 0 and 100.");
            return;
        }

        studentService.addStudent(student);
    }

    private void searchStudent() {

        System.out.print("Enter Roll No: ");
        String rollNo = scanner.next();

        Student student = studentService.searchStudent(rollNo);

        if (student != null) {
            System.out.println("\n----------- Student Details -----------");
            System.out.println("Roll No    : " + student.getRollNo());
            System.out.println("Name       : " + student.getName());
            System.out.println("Department : " + student.getDept());
            System.out.println("Email      : " + student.getEmail());
            System.out.println("Phone      : " + student.getPhone());
            System.out.println("Marks      : " + student.getMarks());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Student not found!");
        }
    }

    private void updateStudent() {

        System.out.print("Enter Roll No: ");
        String rollNo = scanner.next();
        Student existingStudent = studentService.searchStudent(rollNo);

        if (existingStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        while (true) {

            System.out.println("\n========== Update Student ==========");
            System.out.println("1. Update Name");
            System.out.println("2. Update Department");
            System.out.println("3. Update Email");
            System.out.println("4. Update Phone");
            System.out.println("5. Update Marks");
            System.out.println("6. Update All Details");
            System.out.println("7. Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();

                    studentService.updateName(rollNo, name);
                    break;

                case 2:

                    System.out.print("Enter New Department: ");
                    String dept = scanner.nextLine();

                    studentService.updateDepartment(rollNo, dept);
                    break;

                case 3:

                    System.out.print("Enter New Email: ");
                    String email = scanner.nextLine();

                    studentService.updateEmail(rollNo, email);
                    break;

                case 4:

                    System.out.print("Enter New Phone: ");
                    String phone = scanner.nextLine();

                    studentService.updatePhone(rollNo, phone);
                    break;

                case 5:

                    System.out.print("Enter New Marks: ");
                    double marks = scanner.nextDouble();

                    studentService.updateMarks(rollNo, marks);
                    break;

                case 6:

                    Student student = new Student();

                    student.setRollNo(rollNo);

                    System.out.print("Enter New Name: ");
                    student.setName(scanner.nextLine());

                    System.out.print("Enter New Department: ");
                    student.setDept(scanner.nextLine());

                    System.out.print("Enter New Email: ");
                    student.setEmail(scanner.nextLine());

                    System.out.print("Enter New Phone: ");
                    student.setPhone(scanner.nextLine());

                    System.out.print("Enter New Marks: ");
                    student.setMarks(scanner.nextDouble());

                    studentService.updateStudent(student);
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void deleteStudent() {

        System.out.print("Enter Roll No: ");
        String rollNo = scanner.next();

        System.out.print("Are you sure you want to delete this student? (Y/N): ");

        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'Y') {
            studentService.deleteStudent(rollNo);
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }
    private void searchMenu() {

        while (true) {

            System.out.println("\n========== Search Student ==========");
            System.out.println("1. Search by Roll Number");
            System.out.println("2. Search by Department");
            System.out.println("3. Search by Marks");
            System.out.println("4. Search by First Letter of Name");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    searchStudent();
                    break;

                case 2:

                    System.out.print("Enter Department: ");
                    scanner.nextLine();
                    String dept = scanner.nextLine();

                    var departmentStudents = studentService.searchByDepartment(dept);

                    if (departmentStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        departmentStudents.forEach(System.out::println);
                    }

                    break;

                case 3:

                    System.out.print("Enter Minimum Marks: ");
                    double marks = scanner.nextDouble();

                    var marksStudents = studentService.searchByMarks(marks);

                    if (marksStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        marksStudents.forEach(System.out::println);
                    }

                    break;

                case 4:

                    System.out.print("Enter First Letter: ");
                    char letter = scanner.next().charAt(0);

                    var nameStudents = studentService.searchByFirstLetter(letter);

                    if (nameStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        nameStudents.forEach(System.out::println);
                    }

                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}