package dao;

import java.sql.*;
import java.util.*;

import dbconn.DBConnection;

public class StudentDAO {

    public void addStudent(String name, int age, String grade) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + 
                                   rs.getString("name") + " | " + 
                                   rs.getInt("age") + " | Grade: " + 
                                   rs.getString("grade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

