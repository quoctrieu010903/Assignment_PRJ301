/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Account.AccountDTO;
import trieulq.Cart.CartItem;
import trieulq.Cart.CartUtil;
import trieulq.Customers.CustomerDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "ViewCardServlet", urlPatterns = {"/ViewCardServlet"})
public class ViewCardServlet extends HttpServlet {

    private final String SaveCartController = "SaveCartController";

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
          String url = SaveCartController;
        List<CartItem> itemsInCart = null;
        Cookie cookieCart = null;
        HashMap<String, CartItem> cart = null;
        HttpSession session = request.getSession();
        CustomerDTO customer = (CustomerDTO) session.getAttribute("Customer");
        AccountDTO a = (AccountDTO) session.getAttribute("Account");
        try {
            CartUtil cartUtils = new CartUtil();
            HttpSession sessionCart = request.getSession();
            cart = (HashMap<String, CartItem>) sessionCart.getAttribute("Cart" + a.getAccountID());
            if (cart == null) {
                cookieCart = cartUtils.getCookieByName(request, "Cart" + a.getAccountID());
                if (cookieCart != null) {
                    cart = cartUtils.getCartFromCookie(cookieCart);
                    log(cookieCart.getValue());
                    if (cart != null) {
                        itemsInCart = new ArrayList<>(cart.values());
                        sessionCart.setAttribute("Cart" + a.getAccountID(), cart);
                    }
                }
            } else {
                itemsInCart = new ArrayList<>(cart.values());
            }
            request.setAttribute("Cart" + customer.getCustomerID(), itemsInCart);
        } catch (Exception e) {
            log("ViewCartController has been error " + e.getMessage());
        } finally {
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
