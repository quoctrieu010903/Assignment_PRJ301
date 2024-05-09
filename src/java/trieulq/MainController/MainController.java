/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.MainController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class MainController extends HttpServlet {

    private final String LOGIN = "Login";
    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String LOGOUT ="Logout";
    private final String LOGOUT_CONTROLLER="LogoutServlet";
    private final String REGISTRATOR ="CreateAccount";
    private final String REGISTRATION_CONTROLLER="CreateAccountServlet";
    private final String SEARCH = "Search";
    private final String SEARCH_CONTROLLER = "SearchByLastNameServlet";
    private final String UPDATE= "Update";
    private final String UPDATE_CONTROLLER="UpdateAccountByIDServlet";
    private final String DELETE="delete";
    private final String DELETE_CONTROLLER="DeleteAccontByIDServlet";
    private final String CREATE_PRODUCT="createProduct";
    private final String CREATE_PRODUCT_CONTROLLER="createNewProductServlet";
    private final String SEARCH_PRODUCT="Search Product";
    private final String SEARCH_PRODUCT_CONTROLL="SearchProductServlet";
    private final String DELETE_PRODUCT="deleteProduct";
    private final String DELETE_PRODUCT_CONTROLLER="DeleteProductServlet";
    private final String UPDATE_PRODUCT="updateProduct";
    private final String UPDATE_PRODUCT_CONTROLLER="UpdateProductServlet";
    private final String FILLTER_PRODUCT="FillterProductByID";
    private final String FILLTER_PRODUCT_CONTROLLER="FillterProductServlet";
    private final String SEARCH_PRODUCT_BY_PRICE="SearchRangePrice";
    private final String SEARCH_PRODUCT_BY_RANGEPRICE_CONTROLLER="SearchProductbyRagePrice";
    private final String ADD_TO_CART = "addtocart";
    private final String ADD_TO_CART_CONTROLLER="AddToCartServlet";
    private final String VIEW_CARD="View Cart";
    private final String VIEW_CARD_CONTROLLER="ViewCardServlet";
    private final String ADD_DETAIL = "Add Detail";
    private final String ADD_DETAIL_CONTROLLER ="AddDetailServlet";
    private final String CREATE_ORDER = "CreateOrder";
    private final String CREATE_ORDER_CONTROLLER = "CreateOrderServlet";
    private final String REMOVE_CART_ITEMS="RemoveCart";
    private final String REMOVE_CARRT_ITEMS_CONTROLLER="RemoveItemsCartServlet";
    private final String UPDARE_CART_ITEMS="UpdateCart";
    private final String UPDARE_CART_ITEMS_CONTROLLER="UpdateCartItemsServlet";
    
    

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String url = LOGIN_PAGE;
        try {

                String button = request.getParameter("action");
           
            if (button == null) {
                url = LOGIN_PAGE;
            } else if (LOGIN.equals(button)) {
                url = LOGIN_CONTROLLER;
            }else if(LOGOUT.equals(button)){
                url = LOGOUT_CONTROLLER;
            }else if(REGISTRATOR.equals(button)){
                url = REGISTRATION_CONTROLLER;
            }else if(SEARCH.equals(button)){
                url = SEARCH_CONTROLLER;
            }else if(UPDATE.equals(button)){
                url = UPDATE_CONTROLLER;
            }else if(DELETE.equals(button)){
                url = DELETE_CONTROLLER;
            }else if(SEARCH_PRODUCT.equals(button)){
                url = SEARCH_PRODUCT_CONTROLL;  
            }else if(CREATE_PRODUCT.equals(button)){
                url = CREATE_PRODUCT_CONTROLLER;
            }else if(DELETE_PRODUCT.equals(button)){
                url = DELETE_PRODUCT_CONTROLLER;
            }else if(UPDATE_PRODUCT.equals(button)){
                url = UPDATE_PRODUCT_CONTROLLER;
            }else if(FILLTER_PRODUCT.equals(button)){
                url =  FILLTER_PRODUCT_CONTROLLER;
         }else if(SEARCH_PRODUCT_BY_PRICE.equals(button)){
                url = SEARCH_PRODUCT_BY_RANGEPRICE_CONTROLLER;
            }else if(ADD_TO_CART.equals(button)){
                url =  ADD_TO_CART_CONTROLLER;
            }else if(VIEW_CARD.equals(button)){
                url = VIEW_CARD_CONTROLLER;
            }else if(ADD_DETAIL.equals(button)){
                url = ADD_DETAIL_CONTROLLER;
            }else if(CREATE_ORDER.equals(button)){
                url= CREATE_ORDER_CONTROLLER;
            }else if(REMOVE_CART_ITEMS.equals(button)){
                url = REMOVE_CARRT_ITEMS_CONTROLLER;
            }else if(UPDARE_CART_ITEMS.equals(button)){
                url =UPDARE_CART_ITEMS_CONTROLLER;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
