/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Order;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class OrderDTO implements Serializable{
        private String OrderID, CustomerID;
    private Date OrderDate, RequiredDate, ShippedDate;
    private float Freight;
    private String ShipAddress;

    public OrderDTO() {
    }

    public OrderDTO(String OrderID, String CustomerID, Date OrderDate, Date RequiredDate, Date ShippedDate, float Freight, String ShipAddress) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.Freight = Freight;
        this.ShipAddress = ShipAddress;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(Date RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public Date getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(Date ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public float getFreight() {
        return Freight;
    }

    public void setFreight(float Freight) {
        this.Freight = Freight;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }
    
}
