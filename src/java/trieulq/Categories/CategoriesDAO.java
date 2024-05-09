/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Categories;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trieulq.Utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CategoriesDAO implements Serializable {

    public CategoriesDTO getCategoriesByID(String caID) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        CategoriesDTO result = new CategoriesDTO();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [CategoryID]\n"
                        + "      ,[CategoryName]\n"
                        + "      ,[Description]\n"
                        + "  FROM [CarManagement].[dbo].[Categories]\n"
                        + "  where CategoryID = ? ";
                psm = conn.prepareStatement(sql);
                psm.setString(1, caID);
                rs = psm.executeQuery();
                if(rs.next()){
                    String CategoryID = rs.getString(1);
                    String CategoryName = rs.getString(2);
                    String Description = rs.getString(3);
                    result= new CategoriesDTO(CategoryID, CategoryName, Description);
                }
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
       public CategoriesDTO getCategoriesByName(String caName) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        CategoriesDTO result = new CategoriesDTO();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [CategoryID]\n"
                        + "      ,[CategoryName]\n"
                        + "      ,[Description]\n"
                        + "  FROM [CarManagement].[dbo].[Categories]\n"
                        + "  where CategoryName = ? ";
                psm = conn.prepareStatement(sql);
                psm.setString(1, caName);
                rs = psm.executeQuery();
                if(rs.next()){
                    String CategoryID = rs.getString(1);
                    String CategoryName = rs.getString(2);
                    String Description = rs.getString(3);
                    result= new CategoriesDTO(CategoryID, CategoryName, Description);
                }
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
    
    
    
    public boolean CheckExistCategoriesByID(String caID) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        boolean categoryExists = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT COUNT(*) FROM Categories WHERE CategoryID = ? ";
               psm = conn.prepareStatement(sql);
                psm.setString(1, caID);
                rs =psm.executeQuery();
                
                if (rs.next()) {
                    int count = rs.getInt(1);
                    categoryExists = (count > 0);
                }
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return categoryExists;
    }
    
    
    
}
