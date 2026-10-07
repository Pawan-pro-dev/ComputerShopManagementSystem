/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public class Supplier {
    
    private int supplierId;
    private String name;
    private String companyName;
    private String phone;
    private String email;
    private String address;
    
    public Supplier(){
        
    }

    public Supplier(int supplierId, String name, String companyName, String phone, String email, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Supplier(String name, String companyName, String phone, String email, String address) {
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
