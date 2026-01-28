# 📚 Library Management System (Java + JDBC)

A console-based Library Management System developed using **Core Java**, **JDBC**, and **MySQL**.  
This application supports **Library Member** and **Librarian** roles with authentication, CRUD operations, and OTP-based login.

---

## 🔧 Technologies Used
- Java (Core Java, OOPS)
- JDBC
- MySQL
- SQL
- Eclipse / IntelliJ
- Git & GitHub

---

## 👥 Roles & Features

### 👤 Library Member
- Register as a new member
- Login using Email & Password
- Login using Mobile Number with OTP verification

### 👨‍🏫 Librarian (Admin)
- Login using Email & Password
- Login using Mobile Number with OTP
- View all registered members
- Find member using mobile number
- Delete member using email

---

## 🏗 Project Structure
LibraryManagementSystem
│
├── DatabaseConnection.java // Database utility
├── LibraryMember.java // Member entity
├── Librarian.java // Admin operations
├── MemberActions.java // Member operations
└── MainClass.java // Application entry point


---

## 🛢 Database Details
- Database: `jdbc_test`
- Tables:
  - `user`   (library members)
  - `admin`  (librarian details)

---

## ▶ How to Run the Project
1. Clone the repository
   ```bash
   git clone https://github.com/your-username/LibraryManagementSystem.git
