/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Customers;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CustomerDTO implements Serializable{
    private String CustomerID;
    private String Password;
    private String ContactName;
    private String Address;
    private String phoneNumber; 

    public CustomerDTO() {
    }

    public CustomerDTO(String CustomerID, String Password, String ContactName, String Address, String phoneNumber) {
        this.CustomerID = CustomerID;
        this.Password = Password;
        this.ContactName = ContactName;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   
    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   
    
}
