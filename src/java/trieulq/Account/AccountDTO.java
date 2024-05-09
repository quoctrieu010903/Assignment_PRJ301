/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Account;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class AccountDTO implements Serializable{
      private String AccountID;
      private String Username;
      private String password;
      private String fullName;
      private String RoleID;

    public AccountDTO() {
    }

    public AccountDTO(String AccountID, String Username, String password, String fullName, String RoleID) {
        this.AccountID = AccountID;
        this.Username = Username;
        this.password = password;
        this.fullName = fullName;
        this.RoleID = RoleID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }
      
}
