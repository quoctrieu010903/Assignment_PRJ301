/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Cart;

import java.io.Serializable;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trieulq.Customers.CustomerDTO;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CartUtil implements Serializable{
    public HashMap<String, CartItem> getCartFromCookie(Cookie cookieCart) {
        HashMap<String, CartItem> cart = new HashMap<>();
        String[] arrProductDetail = null;
        String ProID;
        String ProName;
        String CateName;
        String CateDes;
        double UnitPrice;
        int Quantity;
        Base64.Decoder base64Decoder = Base64.getDecoder();
        String encodeString = new String(base64Decoder.
                decode(cookieCart.getValue().getBytes()));
        String[] itemsList = encodeString.split("\\|");
        for (String strItem : itemsList) {
            arrProductDetail = strItem.split(",");
            ProID = arrProductDetail[0].trim();
            ProName = arrProductDetail[1].trim();
            CateName = arrProductDetail[2].trim();
            CateDes = arrProductDetail[3].trim();
            Quantity = Integer.parseInt(arrProductDetail[4].trim());
            UnitPrice = Double.parseDouble(arrProductDetail[5].trim());
            CartItem c = new CartItem(ProID, ProName, CateName, CateDes, UnitPrice, Quantity);
            cart.put(ProID, c);
        }
        return cart;
    }

    public Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] arrCookies = request.getCookies();
        if (arrCookies != null) {
            for (Cookie cookie : arrCookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void saveCartToCookie(HttpServletRequest request,
            HttpServletResponse response, String strItemsInCart) {
        HttpSession session = request.getSession();
        CustomerDTO cust = (CustomerDTO) session.getAttribute("Customer");
        String cookieName = "Cart" + cust.getCustomerID();
        Cookie cookieCart = getCookieByName(request, cookieName);
        if (cookieCart != null) {
            cookieCart.setValue(strItemsInCart);
        } else {
            cookieCart = new Cookie(cookieName, strItemsInCart);
        }
        cookieCart.setMaxAge(60 * 60);
        response.addCookie(cookieCart);
    }

    public String convertCartToString(List<CartItem> productList) {
        StringBuilder strProductInCart = new StringBuilder();
        productList.forEach((o) -> {
            strProductInCart.append(o.toString() + "|");
        });
        Base64.Encoder base64Encoder = Base64.getEncoder();
        String encodeString = base64Encoder.encodeToString(strProductInCart.toString().getBytes());
        return encodeString;
    }
    
}
