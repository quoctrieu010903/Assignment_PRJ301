/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Product.ProductDAO;
import trieulq.Product.ProductDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "SearchProductbyRagePrice", urlPatterns = {"/SearchProductbyRagePrice"})
public class SearchProductbyRagePrice extends HttpServlet {

    private final String Fails = "userMenu.jsp";

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
        String FromPriceStr = request.getParameter("fromPrice");
        String ToPriceStr = request.getParameter("toPrice");
        String url = Fails;
        try {

            if (FromPriceStr != null && ToPriceStr != null && !FromPriceStr.isEmpty() && !ToPriceStr.isEmpty()) {
                double fromPrice = Double.parseDouble(FromPriceStr);
                double toPrice = Double.parseDouble(ToPriceStr);

                ProductDAO dao = new ProductDAO();
                List<ProductDTO> listProduct = dao.getProductByPrice(fromPrice, toPrice);
                if (listProduct.isEmpty()) {
                    request.setAttribute("ERROR", "NO ROW CAN BE MATCHED Price FROM " + fromPrice + "$ TO " + toPrice + "$");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("ListProduct", listProduct);
                }
            }
        } catch (NumberFormatException e) {
            request.setAttribute("ERROR", "THE PRICE MUST BE A NUMBER !!");
        } finally {
            request.getRequestDispatcher("userMenu.jsp").forward(request, response);
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
            Logger.getLogger(SearchProductbyRagePrice.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchProductbyRagePrice.class.getName()).log(Level.SEVERE, null, ex);
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
