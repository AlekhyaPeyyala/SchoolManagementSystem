package dao;

import java.sql.*;

import dbconn.DBConnection;

public class ClassDAO {

    public void addClass(String className, int teacherId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO classes (class_name, teacher_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, className);
            ps.setInt(2, teacherId);
            ps.executeUpdate();
            System.out.println("Class Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewClasses() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = 
            "SELECT c.id, c.class_name, t.name AS teacher " +
            "FROM classes c JOIN teachers t ON c.teacher_id = t.id";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("class_name") + " | Teacher: " +
                                   rs.getString("teacher"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
