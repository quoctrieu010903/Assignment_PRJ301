<%-- 
    Document   : UserManager
    Created on : Apr 18, 2024, 8:27:41 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/adminstyle.css">
        <link rel="stylesheet" href="css/usermanage.css">
        <link rel="stylesheet" href="css/adminstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
    <center>
        <%@include file="components/navbar.jsp" %>
    </center>
    <div class="container-lg">
        <div class="table-responsive">
            <div class="table-wrapper">			
                <div class="table-title">
                    <form action="MainController">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Account<b>Details</b></h2>
                            </div>
                            <div class="col-sm-3">     
                                <div class="search-box">
                                    <div class="input-group">								
                                        <input type="text" id="search" class="form-control" placeholder="Search by Name" name="txtSearch" value="${param.txtSearch}">
                                        <input type="submit" value="Search"  name="action" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3"> 
                                <form action="MainController">
                                    <input type="submit" value="Create a new Account" name="acc" class="create-account-btn" />
                                </form>
                            </div>

                    </form>
                </div>
            </div>
            <h3 style="color: green">${Message}</h3>
            <c:set value="${param.txtSearch}" var="searchValue"/>
            <c:if test="${ not empty searchValue}">

                <table >
                    <thead>
                        <tr>
                            <th>#</th>
                            <th style="width: 22%;">UserID</th>
                            <th style="width: 22%;">Full Name</th>
                            <th>UserName</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:set value="${requestScope.Result}" var="result"/>
                        <c:forEach items="${result}" var="c" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="txtAccountID" value="${c.getAccountID()}" readonly=""/>
                                </td>
                                <td>
                                    <input type="text" name="txtUsername" value="${c.getUsername()}"/>
                                </td>
                                <td>
                                    <input type="text" name="txtFullName" value="${c.getFullName()}"/>
                                </td>
                                <td>

                                    <input type="text" name="txtRoleID" value="${c.getRoleID()}"/>
                                </td>
                                <td>
                                    ${c.getPassword()}
                                    <input type="hidden" name="txtPassword" value="${c.getPassword()}"/>
                                </td>
                                <td>
                                <td>    
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="delete"/>
                                        <c:param name="pk" value="${c.getAccountID()}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}"/>

                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="action"/>
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                </td>
                                </td>
                            </tr>
                        </form>

                    </c:forEach>

                    </tbody>
                </table>
                <center>
                    <c:if test="${empty result}">
                        <h3 style="color: red"> No Result can match </h3>
                    </c:if>
                </center>
            </c:if>


        </div>
    </div>        
</div>     
<%@include file="components/script.jsp" %>
</body>
</html>
