package javaprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDatabaseExample {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ise123";

    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Insert data into Student table
            insertData(conn, "John", 22, "CS");
            insertData(conn, "Alice", 21, "Math");
            insertData(conn, "Bob", 23, "Physics");

            // Update data in Student table
            updateData(conn, "John", 23);

            // Delete data from Student table
            deleteData(conn, "Alice");

         // Search for data in Student table
            searchStudent(conn, "Bob");
            // Close connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static void insertData(Connection conn, String name, int age, String      major) throws SQLException {
  String query = "INSERT INTO Student (name, age, major) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.setString(3, major);
        pstmt.executeUpdate();
    pstmt.close();
    }

public static void updateData(Connection conn, String name, int newAge)               throws SQLException {
        String query = "UPDATE Student SET age = ? WHERE name = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, newAge);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        pstmt.close();
    }

public static void deleteData(Connection conn, String name) throws  SQLException {
        String query = "DELETE FROM Student WHERE name = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        pstmt.close();
    }
public static void searchStudent(Connection conn, String name) throws                                                                       SQLException {
        String query = "SELECT * FROM Student WHERE name = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String studentName = rs.getString("name");
            int age = rs.getInt("age");
            String major = rs.getString("major");
System.out.println("ID: " + id + ", Name: " + studentName + ", Age: " +    age + ", Major: " + major);
        }
        rs.close();
        pstmt.close();
    }
}

CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    major VARCHAR(50) NOT NULL
);

//

use studentdb;
select * from student;

