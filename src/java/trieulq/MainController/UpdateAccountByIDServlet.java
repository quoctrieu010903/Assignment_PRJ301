/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trieulq.Account.AccountDAO;
import trieulq.Account.AccountDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "UpdateAccountByIDServlet", urlPatterns = {"/UpdateAccountByIDServlet"})
public class UpdateAccountByIDServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String AccountID = request.getParameter("txtAccountID");
        String Username = request.getParameter("txtUsername");
        String FullName = request.getParameter("txtFullName");
        String RoleID = request.getParameter("txtRoleID");
        String Password = request.getParameter("txtPassword");
        String searchValue = request.getParameter("lastSearchValue");
        String url = null;
        
        try {
            AccountDAO dao = new AccountDAO();
            
            boolean result = dao.updateAccount(new AccountDTO(AccountID, Username, Password, FullName, RoleID));
                if(result) {
                    url ="MainController?action=Search&txtSearch="+searchValue;
                    request.setAttribute("Message","update "+AccountID +"Successfully"); 
                }else{
                    request.setAttribute("Message","Update "+AccountID + " Faill");
                }
                 response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
