/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trieulq.Utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class AccountDAO implements Serializable {

    public AccountDTO checkLogin(String accountID, String password) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AccountDTO list = new AccountDTO();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT  [AccountID]\n"
                        + "      ,[UserName]\n"
                        + "      ,[Password]\n"
                        + "      ,[FullName]\n"
                        + "      ,[RoleID]\n"
                        + "  FROM [CarManagement].[dbo].[Account]\n"
                        + "  where AccountID = ? and Password = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, accountID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("FullName");
                    String RoleID = rs.getString("RoleID");
                    String username = rs.getString("UserName");
                    list = new AccountDTO(accountID, username, password, fullName, RoleID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return list;
    }

    public List<AccountDTO> searchAccountByName(String fullname) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AccountDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT  [AccountID]\n"
                        + "      ,[UserName]\n"
                        + "      ,[Password]\n"
                        + "      ,[FullName]\n"
                        + "      ,[RoleID]\n"
                        + "  FROM [CarManagement].[dbo].[Account]\n"
                        + "  where FullName like ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + fullname + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String accountID = rs.getString("AccountID");
                    String fullName = rs.getString("FullName");
                    String password = rs.getString("password");
                    String RoleID = rs.getString("RoleID");
                    String username = rs.getString("UserName");
                    list.add(new AccountDTO(accountID, username, password, fullName, RoleID));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return list;
    }

    public boolean deleteAccount(String UserID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM [dbo].[Account]\n"
                        + "      WHERE AccountID=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, UserID);
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

    public boolean updateAccount(AccountDTO a) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [dbo].[Account]\n"
                        + "   SET "
                        + "      [UserName] = ? "
                        + "      ,[Password] = ? "
                        + "      ,[FullName] = ? "
                        + "      ,[RoleID] = ? "
                        + " WHERE AccountID = ? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, a.getUsername());
                ps.setString(2, a.getPassword());
                ps.setString(3, a.getFullName());
                ps.setString(4, a.getRoleID());
                ps.setString(5, a.getAccountID());
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

    public boolean createAccout(AccountDTO a) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[Account]\n"
                        + "           ([AccountID]\n"
                        + "           ,[UserName]\n"
                        + "           ,[Password]\n"
                        + "           ,[FullName]\n"
                        + "           ,[RoleID])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, a.getAccountID());
                ps.setString(2, a.getUsername());
                ps.setString(3, a.getPassword());
                ps.setString(4, a.getFullName());
                ps.setString(5, a.getRoleID());

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

    public AccountDTO getAccountByID(String AccountID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AccountDTO list = new AccountDTO();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [AccountID]\n"
                        + "      ,[UserName]\n"
                        + "      ,[Password]\n"
                        + "      ,[FullName]\n"
                        + "      ,[RoleID]\n"
                        + "  FROM [CarManagement].[dbo].[Account]\n"
                        + "  where AccountID = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, AccountID);
                rs = ps.executeQuery();
                if (rs.next()) {
                  
                   String  Password = rs.getString("Password");
                    String fullName = rs.getString("FullName");
                    String RoleID = rs.getString("RoleID");
                    String username = rs.getString("UserName");
                    list = new AccountDTO(AccountID, username, Password, fullName, RoleID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return list;
    }
}
