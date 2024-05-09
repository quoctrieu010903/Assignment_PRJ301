/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import trieulq.Product.ProductDTO;
import trieulq.Utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class OrderDAO implements Serializable {

    public List<OrderDTO> getOrderList() throws SQLException {
        String sql = "SELECT * FROM Orders";
        List<OrderDTO> List = new ArrayList<>();
        String OrderID, CustomerID, ShipAddress;
        Date OrderDate, RequiredDate, ShippedDate;
        float Freight;
        OrderDTO o;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderID = rs.getString(1);
                CustomerID = rs.getString(2);
                OrderDate = rs.getDate(3);
                RequiredDate = rs.getDate(4);
                ShippedDate = rs.getDate(5);
                Freight = rs.getFloat(6);
                ShipAddress = rs.getString(7);
                o = new OrderDTO(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress);
                List.add(o);
            }
        } catch (ClassNotFoundException e) {
            e.addSuppressed(e);
        }
        return List;
    }

    public List<OrderDTO> getOrderByCustID(String CustID) throws SQLException {
        String sql = "SELECT * FROM Orders WHERE CustomerID = ? ";
        List<OrderDTO> List = new ArrayList<>();
        String OrderID, CustomerID, ShipAddress;
        Date OrderDate, RequiredDate, ShippedDate;
        float Freight;
        OrderDTO o;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, CustID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderID = rs.getString(1);
                CustomerID = rs.getString(2);
                OrderDate = rs.getDate(3);
                RequiredDate = rs.getDate(4);
                ShippedDate = rs.getDate(5);
                Freight = rs.getFloat(6);
                ShipAddress = rs.getString(7);
                o = new OrderDTO(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress);
                List.add(o);
            }
        } catch (ClassNotFoundException e) {
            e.addSuppressed(e);
        }
        return List;
    }

    public List<ProductDTO> getOrderDetailByOrderID(String OrderIdd) throws SQLException {
        String sql = "SELECT ProductID,UnitPrice,Quantity FROM Order_Details WHERE OrderID=?";
        List<ProductDTO> List = new ArrayList<>();
        String ProductId;
        int quantity;
        float UnitPrice;
        ProductDTO p;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, OrderIdd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductId = rs.getString("ProductID");
                UnitPrice = rs.getFloat("UnitPrice");
                quantity = rs.getInt("Quantity");
                p = new ProductDTO(ProductId, quantity, UnitPrice);
                List.add(p);
            }
        } catch (ClassNotFoundException e) {
        }
        return List;
    }

    public boolean InsertOrderToDB(String OrderID, String CustomerID, LocalDate OrderDate, LocalDate RequiredDate, LocalDate ShipppedDate, float Freight, String ShipAddress) throws SQLException, ClassNotFoundException {
        PreparedStatement preStm = null;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            String sql = "Insert Into Orders values(?,?,?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrderID);
            preStm.setString(2, CustomerID);

            Instant orderInstant = OrderDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            Instant requiredInstant = RequiredDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            Instant shippedInstant = ShipppedDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

            java.sql.Date orderDateDb = new java.sql.Date(orderInstant.toEpochMilli());
            java.sql.Date requiredDateDb = new java.sql.Date(requiredInstant.toEpochMilli());
            java.sql.Date shippedDateDb = new java.sql.Date(shippedInstant.toEpochMilli());

            preStm.setDate(3, (java.sql.Date) orderDateDb);
            preStm.setDate(4, (java.sql.Date) requiredDateDb);
            preStm.setDate(5, (java.sql.Date) shippedDateDb);
            preStm.setFloat(6, Freight);
            preStm.setString(7, ShipAddress);
            return preStm.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
        }
    }

    public boolean InsertOrderDetailsToDB(String OrderID, String ProductId, float UnitPrice, int quantity) throws SQLException, ClassNotFoundException {
        PreparedStatement preStm = null;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            String sql = "Insert Into Order_Details values(?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrderID);
            preStm.setString(2, ProductId);
            preStm.setFloat(3, UnitPrice);
            preStm.setInt(4, quantity);
            return preStm.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
        }
    }

    public List<OrderDTO> getOrderDetail(String CusID) throws SQLException {
        List<OrderDTO> oList = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = DBUtils.getConnection();
            String sql = "SELECT o.OrderID, o.CustomerID, o.OrderDate, o.RequiredDate,o.ShippedDate,o.Freight,o.ShipAddress FROM Orders o \n"
                    + "JOIN Order_Details od ON o.OrderID = od.OrderID\n"
                    + "JOIN Products p on p.ProductID = od.ProductID\n"
                    + "JOIN Categories c ON c.CategoryID = p.CategoryID\n"
                    + "JOIN Customers cu on cu.CustomerID = o.CustomerID\n"
                    + "WHERE cu.CustomerID = ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, CusID);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO o = new OrderDTO();
                o.setOrderID(rs.getString(1));
                o.setCustomerID(rs.getString(2));
                o.setOrderDate(rs.getDate(3));
                o.setRequiredDate(rs.getDate(4));
                o.setShippedDate(rs.getDate(5));
                o.setFreight(rs.getFloat(6));
                o.setShipAddress(rs.getString(7));
                oList.add(o);
            }
        } catch (ClassNotFoundException e) {
        }
        return oList;
    }

     
}
