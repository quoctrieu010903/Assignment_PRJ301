/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trieulq.Categories.CategoriesDAO;
import trieulq.Categories.CategoriesDTO;
import trieulq.Utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class ProductDAO implements Serializable {

    public List<ProductDTO> getAllProduct() throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [ProductID]\n"
                        + "      ,[ProductName]\n"
                        + "      ,[CategoryID]\n"
                        + "      ,[QuantityPerUnit]\n"
                        + "      ,[UnitPrice]\n"
                        + "      ,[ProductImage]\n"
                        + "  FROM [CarManagement].[dbo].[Products] ";
                psm = conn.prepareStatement(sql);
                rs = psm.executeQuery();
                while (rs.next()) {
                    String ProductID = rs.getString(1);
                    String productName = rs.getString(2);
                    CategoriesDAO caDAO = new CategoriesDAO();
                    CategoriesDTO CategoryID = caDAO.getCategoriesByID(rs.getString(3));

                    int quantity = rs.getInt(4);
                    double price = rs.getDouble(5);
                    String productImage = rs.getString(6);
                    list.add(new ProductDTO(ProductID, productName, CategoryID, quantity, price, productImage));
                }
            }
        } catch (Exception e) {
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

        return list;

    }

    public List<ProductDTO> getProductByPrice(double minPrice, double maxPrice) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [ProductID]\n"
                        + "      ,[ProductName]\n"
                        + "      ,[CategoryID]\n"
                        + "      ,[QuantityPerUnit]\n"
                        + "      ,[UnitPrice]\n"
                        + "      ,[ProductImage]\n"
                        + "  FROM [CarManagement].[dbo].[Products]\n"
                        + "  where UnitPrice between ? and ? ";
                psm = conn.prepareStatement(sql);
                psm.setDouble(1, minPrice);
                psm.setDouble(2, maxPrice);
                rs = psm.executeQuery();
                while (rs.next()) {
                    String ProductID = rs.getString(1);
                    String productName = rs.getString(2);
                    CategoriesDAO caDAO = new CategoriesDAO();
                    CategoriesDTO CategoryID = caDAO.getCategoriesByID(rs.getString(3));

                    int quantity = rs.getInt(4);
                    double price = rs.getDouble(5);
                    String productImage = rs.getString(6);
                    list.add(new ProductDTO(ProductID, productName, CategoryID, quantity, price, productImage));
                }
            }
        } catch (Exception e) {
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

        return list;

    }

    public List<ProductDTO> getProductByName(String productName) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [ProductID]\n"
                        + "      ,[ProductName]\n"
                        + "      ,[CategoryID]\n"
                        + "      ,[QuantityPerUnit]\n"
                        + "      ,[UnitPrice]\n"
                        + "      ,[ProductImage]\n"
                        + "  FROM [CarManagement].[dbo].[Products]\n"
                        + "  where  ProductName like ? ";
                psm = conn.prepareStatement(sql);
                psm.setString(1, "%" + productName + "%");
                rs = psm.executeQuery();
                while (rs.next()) {
                    String ProductID = rs.getString(1);
                    String productname = rs.getString(2);
                    CategoriesDAO caDAO = new CategoriesDAO();
                    CategoriesDTO CategoryID = caDAO.getCategoriesByID(rs.getString(3));

                    int quantity = rs.getInt(4);
                    double price = rs.getDouble(5);
                    String productImage = rs.getString(6);
                    list.add(new ProductDTO(ProductID, productname, CategoryID, quantity, price, productImage));
                }
            }
        } catch (Exception e) {
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

        return list;

    }

    public ProductDTO getProductByID(String productID) throws SQLException {
        String sql = "SELECT * FROM Products WHERE ProductID= ? ";
        ProductDTO p = null;
        String ProductId, ProductName, CategoryID, ProductImage;
        int QuantityPerUnit;
        double UnitPrice;
        try {
            Connection cnn;
            cnn = DBUtils.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductId = rs.getString(1);
                ProductName = rs.getString(2);
               
                CategoryID = rs.getString(3);
                CategoriesDAO cateD = new CategoriesDAO();
                CategoriesDTO cate = cateD.getCategoriesByID(CategoryID);
                QuantityPerUnit = Integer.parseInt(rs.getString(4));
                UnitPrice = Double.parseDouble(rs.getString(5));
                ProductImage = rs.getString(6);
                p = new ProductDTO(ProductId, ProductName, cate, QuantityPerUnit, UnitPrice, ProductImage);
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return p;

    }

    private boolean CheckExistCategoriesByID(String caID) throws SQLException, ClassNotFoundException {
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
                rs = psm.executeQuery();

                if (rs.next()) {
                    categoryExists = true;
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

    public boolean updateProduct(ProductDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;

        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                String sql = "UPDATE [dbo].[Products]\n"
                        + "   SET "
                        + "      [ProductName] = ? "
                        + "      ,[CategoryID] =  ? "
                        + "      ,[QuantityPerUnit] = ? "
                        + "      ,[UnitPrice] = ? "
                        + "      ,[ProductImage] =  ? "
                        + "          where ProductID = ? ";
                psm = conn.prepareStatement(sql);

                psm.setString(1, p.getProductName());
                psm.setString(2, p.getCate().getCategorieID());
                psm.setInt(3, p.getQuantity());
                psm.setDouble(4, p.getPrice());
                psm.setString(5, p.getProductImage());
                psm.setString(6, p.getProductID());
                int effectRow = psm.executeUpdate();
                if (effectRow > 0) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteProduct(String ProductID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM [dbo].[Products]\n"
                        + "   where  ProductID = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ProductID);
                int effectedRow = ps.executeUpdate();
                if (effectedRow > 0) {
                    check = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean createProduct(ProductDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[Products]\n"
                        + "           ([ProductID]\n"
                        + "           ,[ProductName]\n"
                        + "           ,[CategoryID]\n"
                        + "           ,[QuantityPerUnit]\n"
                        + "           ,[UnitPrice]\n"
                        + "           ,[ProductImage])\n"
                        + "     VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getProductID());
                ps.setString(2, p.getProductName());
                ps.setString(3, p.getCate().getCategorieID());
                ps.setInt(4, p.getQuantity());
                ps.setDouble(5, p.getPrice());
                ps.setString(6, p.getProductImage());
                int effectRow = ps.executeUpdate();
                if (effectRow > 0) {
                    check = true;
                }
            }

        } catch (Exception e) {
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public String getCateNameByProductID(String ProductID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String cateName = "";
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT c.CategoryName FROM Categories c JOIN Products p ON c.CategoryID = p.CategoryID WHERE p.ProductID = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ProductID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    cateName = rs.getString(1);
                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return cateName;
    }

    public String getCateDesByCateName(String CateName) throws SQLException {
        Connection cnn = null;
        PreparedStatement ps = null;
        String CateDes = "";
        ResultSet rs = null;
        try {
            cnn = DBUtils.getConnection();
            String sql = "SELECT c.Description FROM Categories c WHERE c.CategoryName = ? ";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, CateName);
            rs = ps.executeQuery();
            while (rs.next()) {
                CateDes = rs.getString(1);
            }
        } catch (ClassNotFoundException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return CateDes;
    }
}
