<%-- 
    Document   : navbar
    Created on : Apr 18, 2024, 8:28:35 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
      <h2 style="text-align: center">Welcome, ${sessionScope.Account_List.fullName}</h2>

    <h1>Admin Panel</h1>
</header>
<nav>
    <a href="#">Dashboard</a>
    <a href="UserManager.jsp">User Management</a>
    <a href="ProductManager.jsp">Product Management</a>
    <a href="#">Settings</a>
    <a href="MainController?action=Logout">Logout</a>
</nav>
