<%-- 
    Document   : ProductManager
    Created on : Apr 19, 2024, 2:11:57 PM
    Author     : Lương Quốc Triệu - SE172431
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css/productmanager.css">
        <link rel="stylesheet" href="css/adminstyle.css">

    </head>
    <body>
        <%@include  file="components/navbar.jsp" %>

        <header>
            <form action="MainController">
                <div class="header-content">
                    <h1>Product Manager</h1>
                    <div class="search-bar">
                        <input type="text" placeholder="Search products..." name="txtSearchValue" value="${param.txtSearchValue}">
                        <input  type="submit" value="Search Product" name="action"  />
                    </div>
                        <button class="btn-hover color-1" ><a href="createnewProduct.jsp">create a new product </a></button>

                </div>


                </div>
            </form>

        </header>

        <c:set var="resultSearch" value="${param.txtSearchValue}" />
        <c:if test="${not empty resultSearch}">


            <c:set var="list" value="${requestScope.List_P}"/>
            <c:if test="${not empty list}">

                <table class="product-table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Product Image</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="dto" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td> 
                                <td>
                                    ${dto.getProductID()}
                                    <input type="hidden" name="txtProductID" value="${dto.getProductID()}"  />
                                </td> 
                                <td>
                                   
                                    <input type="text" name="txtProductName" value="${dto.getProductName()}" />
                                </td> 
                                <td>
                                    ${dto.getCate().getCategorieName()}
                                    <input type="hidden" name="txtCategoriesName" value="${dto.getCate().getCategorieName()}"  />
                                </td> 
                                <td>
                                    
                                    <input type="text" name="txtQuantity" value="${dto.getQuantity()}" />
                                </td>
                                <td>
                                
                                    <input type="text" name="txtPrice" value="${dto.getPrice()}" />
                                </td> 
                                <td> 
                                    <img src="${dto.getProductImage()}" style="max-width: 100px; max-height: 100px;">
                                    <input type="hidden" name="txtImage" value="${dto.getProductImage()}"/>
                                </td> 
                                <td>
                                    <c:url var="deleLink" value="MainController">
                                        <c:param name="action" value="deleteProduct"/>
                                        <c:param name="pk" value="${dto.getProductID()}"/>
                                        <c:param name="LastSearchValue" value="${resultSearch}"/>
                                    </c:url>
                                    
                                    <a href="${deleLink}">Delete</a>
                                    <input type="submit" name="action" value="updateProduct"/>
                                    <input type="hidden" name="lastSearchValue" value="${resultSearch}"class="update-button" />
                                  
                                </td>

                            </tr>
                        </form>

                    </c:forEach>
                </tbody>

            </table>
        </c:if> 

        <c:if test="${empty resultSearch}">
            <h3 style="color: red"> No record is matched in the list Product !!</h3>
        </c:if>
    </c:if>








    <%@include  file="components/footer.jsp" %>
</body>
</html>
