<%-- 
    Document   : ViewCart
    Created on : Mar 11, 2024, 11:46:55 AM
    Author     : Admin
--%>


<%@page import="trieulq.Cart.CartItem"%>
<%@page import="trieulq.Customers.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Giỏ hàng</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet"href="css/ViewCartStyle.css">
        <link rel="stylesheet"href="css/navbarUserpage.css">
    </head>
    <body>
        <%@include file="components/navbarUserpage.jsp" %>
        <%
            CustomerDTO customer = (CustomerDTO) session.getAttribute("Customer");
            double totalAmount = 0;
            double Subtotal = 0;
            List<CartItem> itemsInCart = (List<CartItem>) request.getAttribute("Cart" + customer.getCustomerID());
            session.setAttribute("CartItemValues", itemsInCart);
        %>
        <%
            if (itemsInCart == null || itemsInCart.size() == 0) {
        %>
        <div class="container" >
            <header style="text-align: center;" class="header">
                <div class="text-center">
                    <h1>Pizza Store</h1>
                    <img src="img/ae264d741cae09c2377235d9705f9cbc.png">
                </div>
                <form action="FillterProductServlet">
                    <input type="submit" value="Back To Store" />
                </form>
            </header>

            <div class="empty-cart d-none">
                <div class="text-center">
                    <img src="img/empty-cart.png" alt="Giỏ hàng trống">
                    <form method="POST">
                        <input  type="submit" formaction="userMenu.jsp" value="Quay lại cửa hàng" class="btn btn-primary">
                    </form>
                </div>
            </div>
            <%
            } else {
            %>
            <div class="shopping-cart d-block">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead> 
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Mã sản phẩm</th>
                                <th scope="col">Tên sản phẩm</th>
                                <th scope="col">Loại</th>
                                <th scope="col">Mô tả</th>
                                <th scope="col">Giá đơn vị</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col" colspan="2"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                                int count = 0;
                                for (CartItem i : itemsInCart) {
                                    Subtotal = i.getQuantity() * i.getUnitPrice();
                                    totalAmount += Subtotal;
                            %>
                        <form action="MainController">
                            <tr>
                                <td class="detail"><%= (++count)%></td>
                                <td class="detail"><%= i.getProductID()%></td>
                                <td class="detail"><%= i.getProductName()%>
                                    <input type="hidden" value="<%= i.getProductID()%>" name="ProID">
                                </td>
                                <td class="detail"><%= i.getCategoryName()%></td>
                                <td class="detail"><%= i.getCategoryDescrip()%></td>
                                <td class="detail">
                                    <span><%= String.format("%.2f", i.getUnitPrice())%></span>
                                </td>
                                <td class="detail">
                                    <input type="number" min="1" value="<%=i.getQuantity()%>" name="quantity" class="form-control">
                                </td>
                                <td class="text-center">
                                    <button type="submit" name="action" value="RemoveCart" class="btn btn-danger">DELETE</button>
                                </td>
                                <td class="text-center">
                                    <button type="submit" name="action" value="UpdateCart" class="btn btn-primary">UPDATE</button>
                                </td>
                            </tr>
                        </form>

                        <%
                            }
                        %>

                        <tr>
                            <td style="padding: 30px; "colspan="5" class="text-right">
                                <strong class="text-muted">Total Amount</strong>
                            </td>
                            <td style="padding: 30px" class="text-right">
                                <span><%= String.format("%.2f", totalAmount)%></span>
                            </td>
                        </tr>
                        </tbody>
                    </table>    
                </div>
            </div>
            <div class="Buy">
                <form method="POST">
                    <input type="submit" formaction="userMenu.jsp" value="Quay lại cửa hàng" class="btn btn-primary">
                </form>
                <a href="OrderController" class="btn btn-success">Buy</a>
            </div>
        </div>
        <%
            }
        %>


