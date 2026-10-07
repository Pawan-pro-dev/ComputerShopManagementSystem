/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author USER
 */
public class UserDAO {
    
    public boolean addUser(User user) throws Exception {
        String sql = "INSERT INTO user (name, username, password, role) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setString(2, user.getUsername());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, user.getRole());
        return pstm.executeUpdate() > 0;
    }

    public boolean updateUser(User user) throws Exception {
        String sql = "UPDATE user SET name=?, username=?, password=?, role=? WHERE user_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user.getName());
        pstm.setString(2, user.getUsername());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, user.getRole());
        pstm.setInt(5, user.getUserId());
        return pstm.executeUpdate() > 0;
    }

    public boolean deleteUser(int userId) throws Exception {
        String sql = "DELETE FROM user WHERE user_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, userId);
        return pstm.executeUpdate() > 0;
    }

    public List<User> getAllUsers() throws Exception {
        String sql = "SELECT * FROM user";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new User(
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            ));
        }
        return list;
    }
    
    public boolean login(String username, String password) throws SQLException {

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        }
    }
    
}
