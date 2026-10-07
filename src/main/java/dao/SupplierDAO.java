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
import model.Supplier;

/**
 *
 * @author USER
 */
public class SupplierDAO {
    
    public boolean addSupplier(Supplier supplier) throws Exception {
        String sql = "INSERT INTO supplier (name, company_name, phone, email, address) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, supplier.getName());
        pstm.setString(2, supplier.getCompanyName());
        pstm.setString(3, supplier.getPhone());
        pstm.setString(4, supplier.getEmail());
        pstm.setString(5, supplier.getAddress());
        return pstm.executeUpdate() > 0;
    }

    public boolean updateSupplier(Supplier supplier) throws Exception {
        String sql = "UPDATE supplier SET name=?, company_name=?, phone=?, email=?, address=? WHERE supplier_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, supplier.getName());
        pstm.setString(2, supplier.getCompanyName());
        pstm.setString(3, supplier.getPhone());
        pstm.setString(4, supplier.getEmail());
        pstm.setString(5, supplier.getAddress());
        pstm.setInt(6, supplier.getSupplierId());
        return pstm.executeUpdate() > 0;
    }

    public boolean deleteSupplier(int supplierId) throws Exception {
        String sql = "DELETE FROM supplier WHERE supplier_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, supplierId);
        return pstm.executeUpdate() > 0;
    }

    public List<Supplier> getAllSuppliers() throws Exception {
        String sql = "SELECT * FROM supplier";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Supplier> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Supplier(
                rs.getInt("supplier_id"),
                rs.getString("name"),
                rs.getString("company_name"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("address")
            ));
        }
        return list;
    }
    
}
