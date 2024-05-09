/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Cart.CartItem;
import trieulq.Customers.CustomerDTO;
import trieulq.Product.ProductDAO;
import trieulq.Product.ProductDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {
      private final String userMenu = "userMenu.jsp";
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
           String url = userMenu;// url
        String message = "Something went wrong", ProductID;
        ProductDTO seletedProduct = null; //product
        CartItem cartProduct = null;
        HashMap<String,CartItem> itemInCart = null;
        HttpSession session = request.getSession();
        CustomerDTO customer = (CustomerDTO) session.getAttribute("Customer");
        try {
            ProductDAO pd = new ProductDAO();
            ProductID = request.getParameter("producID");
            itemInCart= (HashMap<String, CartItem>) session.getAttribute("Cart" + customer.getCustomerID());
            seletedProduct = pd.getProductByID(ProductID);
              if (itemInCart == null) {
                itemInCart = new HashMap<>();
                session.setAttribute("Cart" + customer.getCustomerID(), itemInCart);
            }
             cartProduct = itemInCart.get(seletedProduct.getProductID());
            if (cartProduct == null) {
                String ProductName = seletedProduct.getProductName();
                String CateName = pd.getCateNameByProductID(ProductID);
                String Des = pd.getCateDesByCateName(CateName);
                cartProduct = new CartItem(ProductID, ProductName, CateName, Des, seletedProduct.getPrice(), 1);
                itemInCart.put(seletedProduct.getProductID(), cartProduct);
                message = "The Product " + seletedProduct.getProductName() + " has been added to cart successfully";
            } else {
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                message = "The cart has been updated successfully";
            }
        } 
         catch (SQLException e) {
            log("AddtoCart has been error " + e.getMessage());
        } finally {
            request.setAttribute("messageFromAdd", message);
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
