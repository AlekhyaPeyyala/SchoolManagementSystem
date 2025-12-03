package dao;

import java.sql.*;

import dbconn.DBConnection;

public class StudentClassDAO {

    public void assignStudent(int studentId, int classId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO student_class (student_id, class_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, classId);
            ps.executeUpdate();
            System.out.println("Student Assigned to Class!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
