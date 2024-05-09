<%-- 
    Document   : admin
    Created on : Apr 18, 2024, 6:03:24 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/adminstyle.css">
       
    </head>
    <body>
        
        <%@include file="components/navbar.jsp" %>
        <section>
            <!-- Admin content goes here -->
            <h2 style="text-align: center">Welcome, ${sessionScope.Account_List.fullName}</h2>

        </section>
        <%@include file="components/footer.jsp" %>
</html>
