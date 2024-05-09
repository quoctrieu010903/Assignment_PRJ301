/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trieulq.Categories.CategoriesDAO;
import trieulq.Categories.CategoriesDTO;
import trieulq.Product.ProductDAO;
import trieulq.Product.ProductDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    private final String Success = "ProductManager.jsp";

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
        String textProductID = request.getParameter("txtProductID");
        String txtProductName = request.getParameter("txtProductName");
        String txtCategoriesName = request.getParameter("txtCategoriesName");
        CategoriesDAO daoca = new CategoriesDAO();
        CategoriesDTO cateName = daoca.getCategoriesByName(txtCategoriesName);
        String txtImage = request.getParameter("txtImage");
        String SearchValue = request.getParameter("lastSearchValue");
        String url = Success;
        try {
            int txtQuantity = Integer.parseInt(request.getParameter("txtQuantity"));
            double txtPrice = Double.parseDouble(request.getParameter("txtPrice"));

            ProductDAO dao = new ProductDAO();
            boolean result = dao.updateProduct(new ProductDTO(textProductID, txtProductName, cateName, txtQuantity, txtPrice, txtImage));

            if (result) {
                url = "MainController?action=Search Product&txtSearchValue=" + SearchValue;
                request.setAttribute("mess", "Update " + txtProductName + "Successfully");
            }
            request.setAttribute("mess", "Update " + textProductID + " Fail");
        } catch (NumberFormatException e) {
            request.setAttribute("mess", "Quantity and Price must be a number!!");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
