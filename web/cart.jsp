<%-- 
    Document   : cart
    Created on : Apr 21, 2023, 7:54:53 AM
    Author     : Nguyen Thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
    </head>
    <body>
        <%@include file="./inc/header.jsp" %>

        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Products</th>

                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${cart}" var="product">
                                        <tr>


                                            <td class="shoping__cart__item">
                                                <img src="${product.img}" alt="alt"/>
                                                <h5>${product.productName}</h5>
                                            </td>
                                            <td class="shoping__cart__price">
                                                ${product.price}
                                            </td>
                                            <td class="shoping__cart__quantity  ">
                                                <div class="d-flex justify-content-center">
                                                    <form class="px-2" action="CartServlet" method="post">
                                                    <input type="hidden" name="action" value="update"/>
                                                    <input type="hidden" name="product_id" value="${product.productId}"/>
                                                    <input type="hidden" name="quantity" value="-1">
                                                    <button type="" class="minus">-</button>
                                                </form>
                                               
                                                ${product.quantity}
                                               <form class="px-2" action="CartServlet" method="post">

                                                    <input type="hidden" name="product_id" value="${product.productId}"/>
                                                    <input type="hidden" name="action" value="update"/>
                                                    <input type="hidden" name="quantity" value="1">
                                                    <button type="" class="minus">+</button>
                                                </form>
                                            </td>
                                            <td class="shoping__cart__total">
                                                ${ product.quantity * product.price }
                                            </td>
                                            <td class="shoping__cart__item__close">
                                                <form action="OrderServlet" method="post">
                                                    <input type="hidden" name="action" value="delete"/>
                                                    <input type="hidden" name="product_id" value="${product.productId}"/>

                                                    <button type="submit"class="icon_close">x</button>
                                                </form>
                                            </td>
                                            </div>
                                        </tr>

                                        <c:set var="totalQuantity" value="${totalQuantity + product.quantity}"/>
                                        <c:set var="totalPrice" value="${totalPrice + (product.price * products.quantity)}" />
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a href="HomeServlet" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                            <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                Upadate Cart</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__continue">
                            <div class="shoping__discount">
                                <h5>Discount Codes</h5>
                                <form action="#">
                                    <input type="text" placeholder="Enter your coupon code">
                                    <button type="submit" class="site-btn">APPLY COUPON</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Cart Total</h5>
                            <ul>
                                <li>Total <span>$${total}</span></li>
                            </ul>
                            <a href="CheckoutServlet" class="primary-btn">PROCEED TO CHECKOUT</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="./inc/footer.jsp" %>

    </body>
</html>
