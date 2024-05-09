

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Product</title>
        <link rel="stylesheet" href="css/createProductstyle.css">
    </head>
    <body>
       
        <div class="container">
            <form action="MainController" method="post">
                <h2>Create New Product</h2>
                <div class="form-group">
                    <label for="productID">Product ID</label>
                    <input type="text" id="productID" name="productID" required>
                </div>
                <div class="form-group">
                    <label for="productName">Product Name</label>
                    <input type="text" id="productName" name="productName" required>
                </div>
                <div class="form-group">
                    <label for="categoryID">Category</label>

                    <select id="categoryID" name="categoryID" required>
                        <c:forEach items="${sessionScope.ListCa}" var="ca">
                            <option value="">Select Category</option>
                            <option value="${ca.getCate().getCategorieID()}">${ca.getCate().getCategorieName()}</option>

                        </c:forEach>
                              <input type="hidden" id="categoryIDHidden" name="categoryIDHidden" value="${ca.getCate().getCategorieID()}">
                        <!-- Add more options as needed -->
                    </select>

                </div>
                <div class="form-group">
                    <label for="quantityPerUnit">Quantity Per Unit</label>
                    <input type="text" id="quantityPerUnit" name="quantityPerUnit" required>
                </div>
                <div class="form-group">
                    <label for="unitPrice">Unit Price</label>
                    <input type="number" id="unitPrice" name="unitPrice" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="productImage">Product Image</label>
                    <input type="text" id="productImage" name="productImage" accept="image/*" required>
                </div>
                <button type="submit" name="action" value="createProduct">Create Product</button>
            </form>
        </div>
    </body>
</html>
