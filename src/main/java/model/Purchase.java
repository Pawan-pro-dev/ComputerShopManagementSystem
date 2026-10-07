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
public class Purchase {
    
    private int purchaseId;
    private int supplierId;
    private int userId;
    private Timestamp purchaseDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    
    public Purchase(){
        
    }

    public Purchase(int purchaseId, int supplierId, int userId, Timestamp purchaseDate, double totalAmount, String paymentMethod, String paymentStatus) {
        this.purchaseId = purchaseId;
        this.supplierId = supplierId;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Purchase(int supplierId, int userId, double totalAmount, String paymentMethod, String paymentStatus) {
        this.supplierId = supplierId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
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

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
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
