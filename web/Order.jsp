<%-- 
    Document   : Order.jsp
    Created on : Mar 14, 2024, 10:22:42 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/OrderStyle.css">
        
        
        <script>
            function setFreight() {
                var freight = document.getElementById("freight");
                var addressType = document.getElementById("addressType").value;
                if (addressType === "Urban") {
                    freight.value = 30;
                } else {
                    freight.value = 50;
                }
            }
        </script>
    </head>
    <body>
        
        <div class="containerF">
            <form action="MainController">
                <form action="CreateOrder" class="order-form">
                    <c:set var="Customer" value="${sessionScope.Customer}"></c:set>
                    <c:if test="${not empty Customer}">
                        <input type="hidden" name="txtCustomerId" value="${Customer.getCustomerID()}">
                        <div class="customer-info">
                            <label for="txtContactName">Contact Name:</label>
                            <input type="text" name="txtContactName" id="txtContactName" value="${Customer.getContactName()}" readonly>
                        </div>
                        <div class="customer-info">
                            <label for="addressType">Address Type:</label>
                            <select name="addressType" id="addressType" onchange="setFreight()">
                                <option value="">Choose Direction</option>
                                <option value="Urban">Urban</option>
                                <option value="Suburban">Suburban</option>
                            </select>
                        </div>

                        <div class="customer-info">
                            <label for="txtFreight">Freight:</label>
                            <input readonly="true" type="text" id="freight" name="txtFreight" value="30">
                        </div>

                        <c:set var="CartItemValues" value="${sessionScope.CartItemValues}"></c:set>
                        <c:if test="${not empty CartItemValues}">
                            <table class="cart-items" border="1">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        int count = 1;
                                    %>
                                    <c:set var="total" value="${0.00}"></c:set>
                                    <c:forEach var="o" items="${CartItemValues}" varStatus="loop">
                                        <tr>
                                            <td><%=(count++)%></td>
                                            <td>${o.getProductName()}</td>
                                            <td>${o.getCategoryDescrip()}</td>
                                            <td>${o.getUnitPrice()}</td>
                                            <td>${o.getQuantity()}</td>
                                            <c:set var="total" value="${total + o.getUnitPrice()*o.getQuantity()}"></c:set>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <h3>Sub Total Of Product: ${total}$</h3>
                        </c:if>

                        <div class="order-actions">
                            <input type="submit" name="action" value="CreateOrder">
                            <a href="MainController?action=View Cart">Back To Cart</a>
                        </div>

                    </c:if>
                    <c:if test="${empty Customer}">
                        <h1>No Customer!!!</h1>
                    </c:if>
                </form>
        </div>
    </form>
</body>
</html>
