/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trieulq.Account.AccountDAO;
import trieulq.Account.AccountDTO;
import trieulq.Customers.CustomerDAO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

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
        String message = "", accountId, password, fullName, RoleID, userName, url = "DisplayMessage.jsp";
        try {
            accountId = request.getParameter("accountId");
            password = request.getParameter("password");
            userName = request.getParameter("userName");
            fullName = request.getParameter("fullName");
            RoleID = request.getParameter("type");
            AccountDAO accountDao = new AccountDAO();
            CustomerDAO cusDao = new CustomerDAO();

            AccountDTO a = new AccountDTO(accountId, userName, password, fullName, RoleID);

            if (accountDao.createAccout(a)) {
                if (RoleID.equals("US")) {
                    if (cusDao.AddCustomer(a)) {
                        message = "Register successfully";
                       
                    }
                }

            } else {
                message = "Something went wrong!!!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.setAttribute("action", "Register Account");
            request.setAttribute("page", "Login.jsp");
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
