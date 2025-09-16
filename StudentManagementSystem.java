package std.management;

import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root"; // your MySQL username
    static final String PASS = "root"; // your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(sc); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(sc); break;
                case 4: deleteStudent(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    // Add Student
    public static void addStudent(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            System.out.print("Enter grade: ");
            String grade = sc.next();

            String query = "INSERT INTO students(name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public static void viewStudents() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public static void updateStudent(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter student ID to update: ");
            int id = sc.nextInt();
            System.out.print("Enter new grade: ");
            String grade = sc.next();

            String query = "UPDATE students SET grade=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, grade);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public static void deleteStudent(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
