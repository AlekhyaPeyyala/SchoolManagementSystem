package dao;

import java.sql.*;

import dbconn.DBConnection;

public class TeacherDAO {

    public void addTeacher(String name, String subject) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.executeUpdate();
            System.out.println("Teacher Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewTeachers() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM teachers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + 
                                   rs.getString("name") + " | " + 
                                   rs.getString("subject"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
