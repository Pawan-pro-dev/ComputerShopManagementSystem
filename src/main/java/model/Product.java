/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public class Product {
    
    private int productId;
    private int categoryId;
    private String productName;
    private String brand;
    private String model;
    private double buyingPrice;
    private double sellingPrice;
    private int stockQuantity;
    
    public Product(){
        
    }

    public Product(int productId, int categoryId, String productName, String brand, String model, double buyingPrice, double sellingPrice, int stockQuantity) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.brand = brand;
        this.model = model;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.stockQuantity = stockQuantity;
    }

    public Product(int categoryId, String productName, String brand, String model, double buyingPrice, double sellingPrice, int stockQuantity) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.brand = brand;
        this.model = model;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.stockQuantity = stockQuantity;
    }
   

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    
    
}
