/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Cart.CartItem;
import trieulq.Cart.CartUtil;
import trieulq.Customers.CustomerDTO;
import trieulq.Order.OrderDAO;
import trieulq.Order.OrderDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/CreateOrderServlet"})
public class CreateOrderServlet extends HttpServlet {

    private final String DisplayMessage = "DisplayMessage.jsp";

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = DisplayMessage;
        HttpSession session = request.getSession();
        List<CartItem> list = (List<CartItem>) session.getAttribute("CartItemValues");
        String OrderId;
        String custId, message = "Something went wrong", contactName, ShipAddress, Phone;
        float freight;
        LocalDate orderDate = LocalDate.now();
        LocalDate requiredDate = orderDate.plusDays(3), ShippedDate = orderDate.plusDays(1);
        OrderDAO oDao = new OrderDAO();
        List<OrderDTO> oList = oDao.getOrderList();
        CustomerDTO c = (CustomerDTO) session.getAttribute("Customer");
        int Num = 0;
        if (oList != null) {
            Num = (oDao.getOrderList().size() + 1);
        }
        OrderId = String.format("O%03d", Num++);
        try {
            custId = c.getCustomerID();
            contactName = c.getContactName();
            ShipAddress = c.getAddress();
            Phone = c.getPhoneNumber();
            freight = Float.parseFloat(request.getParameter("txtFreight"));
            if (oDao.InsertOrderToDB(OrderId, custId, orderDate, requiredDate, ShippedDate, freight, ShipAddress)) {
                for (CartItem o : list) {
                    if (oDao.InsertOrderDetailsToDB(OrderId, o.getProductID(), (float) o.getUnitPrice(), o.getQuantity())) {
                        message = "Your Order Is Ready To Ship For You !!!!";
                    }
                }
            }
            // từ đây nè 
            HashMap<String, CartItem> itemsInCart = null;
            HttpSession shoppingCart = request.getSession();
            CustomerDTO customer = (CustomerDTO) session.getAttribute("Customer");
            itemsInCart = (HashMap<String, CartItem>) shoppingCart.getAttribute("Cart" + customer.getCustomerID());
            CartUtil cart = new CartUtil();
            if (itemsInCart != null) {
                String strItemsInCart = cart.convertCartToString(new ArrayList<>(itemsInCart.values()));
                shoppingCart.setAttribute("Cart" + c.getCustomerID(), null);
            }
        } catch (ClassNotFoundException e) {
        } finally {
            request.setAttribute("page", "userMenu.jsp");
            request.setAttribute("action", "Create Order");
            request.setAttribute("message", message);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
