/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Cart;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CartItem implements Serializable{
    private String ProductID;
    private String ProductName;
    private String CategoryName;
    private String CategoryDescrip;
    private double UnitPrice;
    private int Quantity;

    public CartItem() {
    }

    public CartItem(String ProductID, String ProductName, String CategoryName, String CategoryDescrip, double UnitPrice, int Quantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryName = CategoryName;
        this.CategoryDescrip = CategoryDescrip;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getCategoryDescrip() {
        return CategoryDescrip;
    }

    public void setCategoryDescrip(String CategoryDescrip) {
        this.CategoryDescrip = CategoryDescrip;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    public double getSubTotal() {
        return Quantity * UnitPrice;
    }
}
