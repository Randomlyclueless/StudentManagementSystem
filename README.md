# Student Management System

A console-based Student Management System developed using **Java, JDBC, and MySQL**. The application allows an administrator to securely log in and perform CRUD operations on student records through a menu-driven interface.

---

## Features

### Admin Login
- Secure admin authentication
- Default credentials stored in the database

### Student Management
- Add Student
- View All Students
- Search Student
  - By Roll Number
  - By Department
  - By Minimum Marks
  - By First Letter of Name
- Update Student
  - Update Name
  - Update Department
  - Update Email
  - Update Phone
  - Update Marks
  - Update All Details
- Delete Student

### Additional Features
- Input Validation
- Duplicate Roll Number/Email Handling
- Confirmation before deleting a student
- Formatted table view for student records

---

## Technologies Used

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA
- Git & GitHub

---

## Project Structure

```
StudentManagementSystem
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.studentmanagement
│   │   │       ├── config
│   │   │       ├── dao
│   │   │       ├── model
│   │   │       ├── service
│   │   │       ├── ui
│   │   │       └── Main.java
│   │   └── resources
│   │       └── db.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## Database Schema

### students

| Column | Type |
|---------|------|
| id | INT (Primary Key, Auto Increment) |
| roll_no | VARCHAR(20) UNIQUE |
| name | VARCHAR(100) |
| dept | VARCHAR(50) |
| email | VARCHAR(100) UNIQUE |
| phone | VARCHAR(15) |
| marks | DOUBLE |

### admin

| Column | Type |
|---------|------|
| id | INT (Primary Key, Auto Increment) |
| username | VARCHAR(50) UNIQUE |
| password | VARCHAR(100) |

---

## Default Admin Credentials

```
Username : admin
Password : admin123
```

These credentials are automatically inserted into the database during initialization if no admin account exists.

---

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/StudentManagementSystem.git
```

### 2. Create the MySQL Database

```sql
CREATE DATABASE studentmanagementsystemdb;
```

### 3. Configure Database

Update `db.properties`

```properties
db.url=jdbc:mysql://localhost:3306/studentmanagementsystemdb
db.username=root
db.password=your_password
```

### 4. Run the Project

Open the project in IntelliJ IDEA and run:

```
Main.java
```

---

## Application Workflow

```
Application Start
        │
        ▼
 Admin Login
        │
        ▼
 Student Management Menu
        │
 ┌──────┼──────────────────────────┐
 │      │      │      │      │      │
 ▼      ▼      ▼      ▼      ▼      ▼
Add   View   Search Update Delete Exit
```

---

## Screenshots

### Login

_Add screenshot here_

### Main Menu

_Add screenshot here_

### Add Student

_Add screenshot here_

### View Students

_Add screenshot here_

### Search Student

_Add screenshot here_

### Update Student

_Add screenshot here_

### Delete Student

_Add screenshot here_

---

## Future Enhancements

- Password Encryption
- Student Login
- Attendance Management
- Course & Enrollment Modules
- Export Student Data to CSV
- Java Swing GUI
- Spring Boot REST API
- React Frontend

---

## Learning Outcomes

This project helped in understanding:

- Object-Oriented Programming
- JDBC Connectivity
- MySQL Database Operations
- CRUD Operations
- Layered Architecture (DAO → Service → UI)
- Exception Handling
- Input Validation
- Git & GitHub Workflow

---

## Author

**Kimaya Chavan**

B.Tech Artificial Intelligence & Data Science

---

## License

This project is created for learning and educational purposes.
