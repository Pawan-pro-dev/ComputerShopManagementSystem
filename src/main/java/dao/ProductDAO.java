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
import model.Product;

/**
 *
 * @author USER
 */
public class ProductDAO {
    
    public boolean addProduct(Product product) throws Exception {
        String sql = "INSERT INTO product (category_id, product_name, brand, model, buying_price, selling_price, stock_quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, product.getCategoryId());
        pstm.setString(2, product.getProductName());
        pstm.setString(3, product.getBrand());
        pstm.setString(4, product.getModel());
        pstm.setDouble(5, product.getBuyingPrice());
        pstm.setDouble(6, product.getSellingPrice());
        pstm.setInt(7, product.getStockQuantity());
        return pstm.executeUpdate() > 0;
    }

    public boolean updateProduct(Product product) throws Exception {
        String sql = "UPDATE product SET category_id=?, product_name=?, brand=?, model=?, buying_price=?, selling_price=?, stock_quantity=? WHERE product_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, product.getCategoryId());
        pstm.setString(2, product.getProductName());
        pstm.setString(3, product.getBrand());
        pstm.setString(4, product.getModel());
        pstm.setDouble(5, product.getBuyingPrice());
        pstm.setDouble(6, product.getSellingPrice());
        pstm.setInt(7, product.getStockQuantity());
        pstm.setInt(8, product.getProductId());
        return pstm.executeUpdate() > 0;
    }

    public boolean deleteProduct(int productId) throws Exception {
        String sql = "DELETE FROM product WHERE product_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, productId);
        return pstm.executeUpdate() > 0;
    }

    public List<Product> getAllProducts() throws Exception {
        String sql = "SELECT * FROM product";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Product(
                rs.getInt("product_id"),
                rs.getInt("category_id"),
                rs.getString("product_name"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getDouble("buying_price"),
                rs.getDouble("selling_price"),
                rs.getInt("stock_quantity")
            ));
        }
        return list;
    }

    public boolean updateStock(int productId, int qty) throws Exception {
        String sql = "UPDATE product SET stock_quantity = stock_quantity - ? WHERE product_id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, qty);
        pstm.setInt(2, productId);
        return pstm.executeUpdate() > 0;
    }
    
}
