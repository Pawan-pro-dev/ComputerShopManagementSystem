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
import model.SaleItem;

/**
 *
 * @author USER
 */
public class SaleItemDAO {
    
    public List<SaleItem> getItemsBySaleId(int saleId) throws Exception {
        String sql = "SELECT * FROM sale_item WHERE sale_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, saleId);
        ResultSet rs = pstm.executeQuery();
        
        List<SaleItem> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new SaleItem(
                rs.getInt("sale_item_id"),
                rs.getInt("sale_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity"),
                rs.getDouble("unit_price"),
                rs.getDouble("subtotal")
            ));
        }
        return list;
    }
    
}
