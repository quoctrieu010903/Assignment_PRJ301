<%-- 
    Document   : AddInFoCus
    Created on : Mar 18, 2024, 12:47:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="slide navbar style.css">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/addInfo.css">
    </head>
    <body>
        <div id="login-form-wrap">
            <h2>Detail</h2>
            <form id="login-form" action="MainController">
                <p>
                    <input type="text" name="Address" placeholder="Address" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="Phone" name="Phone" placeholder="Phone Number" required><i class="validation"><span></span><span></span></i>
                </p>
                <p>
                    <input type="submit" value="Add Detail" name="action">
                </p>
            </form>
            <div id="create-account-wrap">
            </div>  
        </div>
    </body>
</html>
