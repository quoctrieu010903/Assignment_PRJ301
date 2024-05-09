/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Cart.CartItem;
import trieulq.Customers.CustomerDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "UpdateCartItemsServlet", urlPatterns = {"/UpdateCartItemsServlet"})
public class UpdateCartItemsServlet extends HttpServlet {
 private final String success = "MainController";
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
         String url = success;
        String message = "Something went wrong", itemId;
        int newQuantity;
        CartItem item;
        HashMap<String, CartItem> cHash = new HashMap<>();
        try {
            itemId = request.getParameter("ProID");
            newQuantity = Integer.parseInt(request.getParameter("quantity"));
            if (itemId != null) {
                HttpSession sessionCart = request.getSession();
                CustomerDTO customer = (CustomerDTO) sessionCart.getAttribute("Customer");
                cHash = (HashMap<String, CartItem>) sessionCart.getAttribute("Cart" + customer.getCustomerID());
                item = cHash.get(itemId);
                item.setQuantity(newQuantity);
                message = "Your Cart has been updated successfully";
                url = success + "?action=View Cart";
            }
        } catch (NumberFormatException e) {
            log(e.getMessage());
        } finally {
            request.setAttribute("Message", message);
            request.getRequestDispatcher(url).forward(request, response);
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
