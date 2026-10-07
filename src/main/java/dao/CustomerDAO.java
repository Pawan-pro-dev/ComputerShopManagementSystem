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
import model.Customer;

/**
 *
 * @author USER
 */
public class CustomerDAO {
    
    public boolean addCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO customer (name, phone, email, address) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, customer.getName());
        pstm.setString(2, customer.getPhone());
        pstm.setString(3, customer.getEmail());
        pstm.setString(4, customer.getAddress());

        return pstm.executeUpdate() > 0;
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        String sql = "UPDATE customer SET name=?, phone=?, email=?, address=? WHERE customer_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, customer.getName());
        pstm.setString(2, customer.getPhone());
        pstm.setString(3, customer.getEmail());
        pstm.setString(4, customer.getAddress());
        pstm.setInt(5, customer.getCustomerId());

        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCustomer(int customerId) throws Exception {
        String sql = "DELETE FROM customer WHERE customer_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, customerId);

        return pstm.executeUpdate() > 0;
    }

    public List<Customer> getAllCustomers() throws Exception {
        String sql = "SELECT * FROM customer";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Customer> customerList = new ArrayList<>();

        while (rs.next()) {
            Customer customer = new Customer(
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("address")
            );
            customerList.add(customer);
        }
        return customerList;
    }
    
}
