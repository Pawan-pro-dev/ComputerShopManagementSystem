/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PurchaseItem;

/**
 *
 * @author USER
 */
public class PurchaseItemDAO {
    
    public List<PurchaseItem> getItemsByPurchaseId(int purchaseId) throws Exception {
        String sql = "SELECT * FROM purchase_item WHERE purchase_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, purchaseId);
        ResultSet rs = pstm.executeQuery();
        
        List<PurchaseItem> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new PurchaseItem(
                rs.getInt("purchase_item_id"),
                rs.getInt("purchase_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity"),
                rs.getDouble("unit_price"),
                rs.getDouble("subtotal")
            ));
        }
        return list;
    }
    
}
