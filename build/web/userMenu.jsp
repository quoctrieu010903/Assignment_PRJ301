<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/usermenu.css">
        <link rel="stylesheet" href="css/navbarUserpage.css">

    </head>   
    <body>
        <%@include file="components/navbarUserpage.jsp" %>
        <div class="card_navbar">
            <h1 class="title-shop">SHOP</h1>
            <a style="width: 50px" href="MainController?action=View Cart"><img
                    src="./img/istockphoto-639811872-612x612.jpg"></a>
        </div>

        <form class="search-form" action="MainController" method="">
            From Price: <input type="text" name="fromPrice" value="${param.fromPrice}"/>
            To Price: <input type="text" name="toPrice" value="${param.toPrice}"/>
            <input type="submit" value="SearchRangePrice" name="action"/>
        </form>

        <c:if test="${not empty requestScope.messageFromAdd}">
            <div id="notification">
                <h4 style="text-align: center; color: #33ff00;">${requestScope.messageFromAdd}</h4>
            </div>
        </c:if>

        <c:set value="${sessionScope.ListProduct}" var="list"/>
        <main class="main bd-grid">
            <c:forEach items="${list}" var="o">
                <article class="card">
                    <div class="card__img">
                        <img src="${o.getProductImage()}" alt="">
                    </div>
                    <div class="card__name">
                        <p>${o.getProductName()}</p>
                    </div>
                    <div class="card__precis">
                        <a href="" class="card__icon" ><ion-icon name="heart-outline"></ion-icon></a>

                        <div>

                            <span class="card__preci card__preci--now">${o.getPrice()} $</span>
                        </div>


                        <a href="MainController?action=addtocart&producID=${o.getProductID()}" class="card__icon"><ion-icon name="cart-outline"></ion-icon></a>

                    </div>
                </article>
            </c:forEach>
            <article class="card">
                <div class="card__img">
                    <img src="https://i.postimg.cc/4dBHXR1Z/image.png" alt="">
                </div>
                <div class="card__name">
                    <p>AIR ZOOM PEGASUS</p>
                </div>
                <div class="card__precis">
                    <a href="" class="card__icon" ><ion-icon name="heart-outline"></ion-icon></a>
                    <div>
                        <span class="card__preci card__preci--before">$990.00</span>
                        <span class="card__preci card__preci--now">$749.00</span>
                    </div>
                    <a href="" class="card__icon"><ion-icon name="cart-outline"></ion-icon></a>
                </div>
            </article>

            <article class="card">
                <div class="card__img">
                    <img src="https://i.postimg.cc/DfRL0nTy/image.png" alt="">
                </div>
                <div class="card__name">
                    <p>AIR ZOOM PEGASUS</p>
                </div>
                <div class="card__precis">
                    <a href="" class="card__icon" ><ion-icon name="heart-outline"></ion-icon></a>

                    <div>
                        <span class="card__preci card__preci--before">$990.00</span>
                        <span class="card__preci card__preci--now">$749.00</span>
                    </div>
                    <a href="" class="card__icon"><ion-icon name="cart-outline"></ion-icon></a>
                </div>
            </article>

            <article class="card">
                <div class="card__img">
                    <img src="https://i.postimg.cc/DfRL0nTy/image.png" alt="">
                </div>
                <div class="card__name">
                    <p>AIR ZOOM PEGASUS</p>
                </div>
                <div class="card__precis">
                    <a href="" class="card__icon" ><ion-icon name="heart-outline"></ion-icon></a>

                    <div>
                        <span class="card__preci card__preci--before">$990.00</span>
                        <span class="card__preci card__preci--now">$749.00</span>
                    </div>
                    <a href="" class="card__icon"><ion-icon name="cart-outline"></ion-icon></a>
                </div>
            </article>
        </main>
        <footer>
            <a href="https://github.com/bedimcode">CR : Bedimcode </a> 
        </footer>
        <!-- ICONS -->
        <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
        <script>
            var notification = document.getElementById("notification");
            // Hiển thị thông báo
            notification.style.display = "block";
            // Đặt thời gian tự động biến mất sau 5 giây (5000 milliseconds)
            setTimeout(function () {
                notification.style.display = "none";
            }, 2000);
        </script>
    </body>
</html>
