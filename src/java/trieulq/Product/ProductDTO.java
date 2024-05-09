/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Product;

import java.io.Serializable;
import trieulq.Categories.CategoriesDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class ProductDTO  implements Serializable{
   private String ProductID;
   private String ProductName;
   private CategoriesDTO cate;
   private int quantity;
   private double price;
   private String ProductImage;

    public ProductDTO() {
    }

    public ProductDTO(String ProductID, int quantity, double price) {
        this.ProductID = ProductID;
        this.quantity = quantity;
        this.price = price;
    }
    

    public ProductDTO(String ProductID, String ProductName, CategoriesDTO cate, int quantity, double price, String ProductImage) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.cate = cate;
        this.quantity = quantity;
        this.price = price;
        this.ProductImage = ProductImage;
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

    public CategoriesDTO getCate() {
        return cate;
    }

    public void setCate(CategoriesDTO cate) {
        this.cate = cate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", cate=" + cate + ", quantity=" + quantity + ", price=" + price + ", ProductImage=" + ProductImage + '}';
    }
    

 
   
   
    
}
