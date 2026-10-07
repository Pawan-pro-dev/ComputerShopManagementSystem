/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public class PurchaseItem {
    
    private int purchaseItemId;
    private int purchaseId;
    private int productId;
    private int quantity;
    private double unitPrice;
    private double subtotal;
    
    public PurchaseItem(){
        
    }

    public PurchaseItem(int purchaseItemId, int purchaseId, int productId, int quantity, double unitPrice, double subtotal) {
        this.purchaseItemId = purchaseItemId;
        this.purchaseId = purchaseId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public PurchaseItem(int purchaseId, int productId, int quantity, double unitPrice, double subtotal) {
        this.purchaseId = purchaseId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public PurchaseItem(int productId, int quantity, double unitPrice, double subtotal) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    
    

    public int getPurchaseItemId() {
        return purchaseItemId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setPurchaseItemId(int purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
