<%-- 
    Document   : Register
    Created on : Mar 5, 2024, 8:54:34 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/registrationcss.css">
    </head>
    <body>
        <div id="login-form-wrap">
            <h2>Register</h2>
            <form id="login-form" action="MainController" >
                <p>
                    <input type="text" id="username" name="accountId" placeholder="Account ID" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="text" id="username" name="userName" placeholder="User Name" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="text" id="username" name="fullName" placeholder="Full Name" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="text" id="email" name="password" placeholder="Password" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    Type <select class="ops" name="type">

                        <option  value="AD">staff</option>
                        <option  value="US">user</option>

                    </select> <i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="submit" id="login" value="CreateAccount" name="action">
                </p>


            </form>
            <div id="create-account-wrap">
            </div>
        </div>
    </body>
</html>
