# 🎓 Student Management System (Java + JDBC + MySQL)

## 📌 Project Overview
This is a simple **console-based Student Management System** built using **Core Java, JDBC, and MySQL**.  
It performs basic **CRUD operations** (Create, Read, Update, Delete) on student records stored in a MySQL database.  

This project is designed for **beginners in Java and database integration**, and it helped me strengthen my understanding of:
- Java OOPs
- JDBC (Java Database Connectivity)
- SQL queries and database design
- Exception Handling

---

## 🚀 Features
- ➕ Add Student  
- 📜 View Students  
- ✏️ Update Student (Grade)  
- ❌ Delete Student  

---

## 🛠 Tech Stack
- **Language:** Java  
- **Database:** MySQL  
- **Connector:** MySQL JDBC Driver  

---

## 🗄 Database Setup
Run the following SQL commands in MySQL Workbench or CLI:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10)
);
