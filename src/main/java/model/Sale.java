/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author USER
 */
public class Sale {
    
    private int saleId;
    private int customerId;
    private int userId;
    private Timestamp saleDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    
    public Sale(){
        
    }

    public Sale(int saleId, int customerId, int userId, Timestamp saleDate, double totalAmount, String paymentMethod, String paymentStatus) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.userId = userId;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Sale(int customerId, int userId, double totalAmount, String paymentMethod, String paymentStatus) {
        this.customerId = customerId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
    
}
