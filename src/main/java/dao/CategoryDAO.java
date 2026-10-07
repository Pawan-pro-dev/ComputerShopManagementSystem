/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author USER
 */
public class CategoryDAO {
    
    public boolean addCategory(Category category) throws Exception {
        String sql = "INSERT INTO category (category_name, description) VALUES (?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, category.getCategoryName());
        pstm.setString(2, category.getDescription());
        return pstm.executeUpdate() > 0;
    }

    public boolean updateCategory(Category category) throws Exception {
        String sql = "UPDATE category SET category_name=?, description=? WHERE category_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, category.getCategoryName());
        pstm.setString(2, category.getDescription());
        pstm.setInt(3, category.getCategoryId());
        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCategory(int categoryId) throws Exception {
        String sql = "DELETE FROM category WHERE category_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, categoryId);
        return pstm.executeUpdate() > 0;
    }

    public List<Category> getAllCategories() throws Exception {
        String sql = "SELECT * FROM category";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Category> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Category(
                rs.getInt("category_id"),
                rs.getString("category_name"),
                rs.getString("description")
            ));
        }
        return list;
    }
    
}
