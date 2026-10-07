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
import java.util.List;
import model.Sale;
import model.SaleItem;

/**
 *
 * @author USER
 */
public class SaleDAO {
    
    public boolean saveSaleTransaction(Sale sale, List<SaleItem> items) throws Exception {
        Connection conn = null;
        PreparedStatement stmtSale = null;
        PreparedStatement stmtItem = null;
        PreparedStatement stmtStock = null;
        ResultSet rs = null;

        String insertSaleSql = "INSERT INTO sale (customer_id, user_id, total_amount, payment_method, payment_status) VALUES (?, ?, ?, ?, ?)";
        String insertItemSql = "INSERT INTO sale_item (sale_id, product_id, quantity, unit_price, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        String updateStockSql = "UPDATE product SET stock_quantity = stock_quantity - ? WHERE product_id = ?";

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            stmtSale = conn.prepareStatement(insertSaleSql, Statement.RETURN_GENERATED_KEYS);
            stmtSale.setInt(1, sale.getCustomerId());
            stmtSale.setInt(2, sale.getUserId());
            stmtSale.setDouble(3, sale.getTotalAmount());
            stmtSale.setString(4, sale.getPaymentMethod());
            stmtSale.setString(5, sale.getPaymentStatus());

            int affectedRows = stmtSale.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            int saleId = 0;
            rs = stmtSale.getGeneratedKeys();
            if (rs.next()) {
                saleId = rs.getInt(1);
            }

            stmtItem = conn.prepareStatement(insertItemSql);
            stmtStock = conn.prepareStatement(updateStockSql);

            for (SaleItem item : items) {
               
                stmtItem.setInt(1, saleId);
                stmtItem.setInt(2, item.getProductId());
                stmtItem.setInt(3, item.getQuantity());
                stmtItem.setDouble(4, item.getUnitPrice());
                stmtItem.setDouble(5, item.getSubtotal());
                stmtItem.addBatch();

                
                stmtStock.setInt(1, item.getQuantity());
                stmtStock.setInt(2, item.getProductId());
                stmtStock.addBatch();
            }

            stmtItem.executeBatch();
            stmtStock.executeBatch();

            conn.commit(); 
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e; 
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtSale != null) stmtSale.close();
                if (stmtItem != null) stmtItem.close();
                if (stmtStock != null) stmtStock.close();
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
            }
        }
    }
    
    
}
