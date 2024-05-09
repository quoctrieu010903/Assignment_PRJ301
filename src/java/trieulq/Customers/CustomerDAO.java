/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Customers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import trieulq.Account.AccountDTO;
import trieulq.Utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CustomerDAO implements Serializable {

    public boolean AddCustomer(AccountDTO a) throws Exception {
        PreparedStatement ps = null;
        Connection cnn = null;
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            String sql = "INSERT INTO [dbo].[Customers]\n"
                    + "           ([CustomerID]\n"
                    + "           ,[Password]\n"
                    + "           ,[ContactName]\n"
                    + "           ,[Address]\n"
                    + "           ,[PhoneNumber])\n"
                    + "     VALUES  (?,?,?,'','')";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, a.getAccountID());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getUsername());

            int effectedRow = ps.executeUpdate();
            if (effectedRow > 0) {
                check = true;
            }
        } catch (ClassNotFoundException ex) {
            throw ex;
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (cnn != null) {
                cnn.close();
            }
        }
        return check;
    }//end Register

    public CustomerDTO getAccountByID(String CustId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CustomerDTO cust = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT *\n"
                        + "  FROM [CarManagement].[dbo].[Customers]\n"
                        + "  Where CustomerID = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, CustId);
                rs = ps.executeQuery();
                while(rs.next()){
                    String CustomerID = rs.getString(1);
                    String Password = rs.getString(2);
                    String ContactName= rs.getString(3);
                    String Address = rs.getString(4);
                    String Phone = rs.getString(5);
                    cust = new CustomerDTO(CustomerID, Password, ContactName, Address, Phone);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cust;
    }
    
     public boolean AddDetail(String Address, String Phone, String cusid) throws Exception {
        PreparedStatement ps = null;
        Connection cnn = null;
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            String sql = "UPDATE Customers SET Address = ?, PhoneNumber = ? WHERE CustomerID = ? ";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, Address);
            ps.setString(2, Phone);
            ps.setString(3, cusid);
            int effectedRow=  ps.executeUpdate();
            if(effectedRow >0 ){
                check= true;
            }
        } catch (ClassNotFoundException ex) {
            throw ex;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return check;
    }//end Register
}
