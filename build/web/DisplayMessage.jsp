<%-- 
   Document   : DisplayMessage
   Created on : Jan 20, 2024, 11:22:01 AM
   Author     : ADMIN
--%>


<%@page import="trieulq.Account.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/DisplayMessStyle.css">
    </head>
    <body>
        <div class="box">
            <div class="box-header">
                <p>Alert:</p>
                <h1><%=request.getAttribute("action")%></h1>
            </div>
            <div class="box-content">
                <%
                    AccountDTO a = (AccountDTO) session.getAttribute("Account_List");
                    String message = (String) request.getAttribute("message");
                    String imageSrc;
                    String messageColor;
                    if (message.matches("Something went wrong") || message.matches("Invalid Password or Username")) {
                        imageSrc = "img/6586128_delete_remove_uncheck_icon.png";
                        messageColor = "red";
                    } else {
                        imageSrc = "img/299110_check_sign_icon_1.png";
                        messageColor = "green";
                    }
                %>
                <img class="box-image" src="<%= imageSrc%>">
                <div class="box-content-text">
                    <h3 style="color:<%=messageColor%>"><%=message%></h3>
                    <div class="box-content__link">
                        <a href="${requestScope.page}">Back</a><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
