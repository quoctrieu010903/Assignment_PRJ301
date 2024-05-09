<%-- 
    Document   : Login
    Created on : Apr 18, 2024, 5:36:17 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/logincss.css">
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <form action="MainController" method="post">
                <label for="txtUserID">UserID:</label>
                <input type="text" id="txtUserID" name="txtUserID" required>
                <label for="txtPassword">Password:</label>
                <input type="password" id="txtPassword" name="txtPassword" required>
                <input type="submit" value="Login" name="action">
            </form>
             <div id="create-account-wrap">
                <p>Not a member? <a href="Register.jsp">Create Account</a><p>
            </div>
        </div>
    </body>
</html>
