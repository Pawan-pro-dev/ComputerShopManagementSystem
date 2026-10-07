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
import model.Purchase;
import model.PurchaseItem;

/**
 *
 * @author USER
 */
public class PurchaseDAO {
    
    public boolean savePurchaseTransaction(Purchase purchase, List<PurchaseItem> items) throws Exception {
        Connection conn = null;
    PreparedStatement stmtPurchase = null;
    PreparedStatement stmtItem = null;
    PreparedStatement stmtStock = null;
    ResultSet rs = null;

    String insertPurchaseSql = "INSERT INTO purchase (supplier_id, user_id, total_amount, payment_method, payment_status) VALUES (?, ?, ?, ?, ?)";
    String insertItemSql = "INSERT INTO purchase_item (purchase_id, product_id, quantity, unit_price, subtotal) VALUES (?, ?, ?, ?, ?)";
    String updateStockSql = "UPDATE product SET stock_quantity = stock_quantity + ? WHERE product_id = ?";

    try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false);

        stmtPurchase = conn.prepareStatement(insertPurchaseSql, Statement.RETURN_GENERATED_KEYS);
        stmtPurchase.setInt(1, purchase.getSupplierId());
        stmtPurchase.setInt(2, purchase.getUserId());
        stmtPurchase.setDouble(3, purchase.getTotalAmount());
        stmtPurchase.setString(4, purchase.getPaymentMethod());
        stmtPurchase.setString(5, purchase.getPaymentStatus());

        int affectedRows = stmtPurchase.executeUpdate();
        if (affectedRows == 0) {
            conn.rollback();
            return false;
        }

        int purchaseId = 0;
        rs = stmtPurchase.getGeneratedKeys();
        if (rs.next()) {
            purchaseId = rs.getInt(1);
        }

        stmtItem = conn.prepareStatement(insertItemSql);
        stmtStock = conn.prepareStatement(updateStockSql);

        for (PurchaseItem item : items) {
           
            stmtItem.setInt(1, purchaseId);
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
        e.printStackTrace();
        return false;
    } finally {

        try {
            if (rs != null) rs.close();
            if (stmtPurchase != null) stmtPurchase.close();
            if (stmtItem != null) stmtItem.close();
            if (stmtStock != null) stmtStock.close();
            if (conn != null) conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
}
