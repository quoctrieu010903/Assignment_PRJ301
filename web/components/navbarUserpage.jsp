<%-- 
    Document   : navbarUserpage
    Created on : Apr 23, 2024, 9:41:04 AM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="navbar">
    <div>
        <a href="view_order.html">
            <img src="view_order_icon.png" alt="View Order">
        </a>
        <a href="view_order.html">View Order</a>
    </div>
    <div>
        <h1>My Fruit Store</h1>
    </div>
    <div>
        <span>Welcome,${sessionScope.Customer.getContactName()}</span>
        <a href="MainController?action=Logout">Logout</a>
    </div>
</div>