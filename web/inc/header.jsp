<%-- 
    Document   : header
    Created on : Apr 19, 2023, 8:06:35 AM
    Author     : Nguyen Thu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header-->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fas fa-envelope"></i> Nguyenthu@gmail.com</li>
                            <li>Free ship</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fab fa-facebook"></i></a>
                            <a href="#"><i class="fab fa-twitter"></i></a>
                            <a href="#"><i class="fab fa-linkedin"></i></a>
                            <a href="#"><i class="fab fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__auth">

                            <contain>
                                <div class="row" >
                                    <c:if test="${sessionScope.user == null}">                                            
                                        <a href="LoginServlet"><i class="fas fa-user"></i>Login</a>
                                    </c:if>
                                    <c:if test="${sessionScope.user != null}">                                            
                                        <a href="LogoutServlet">Logout</a>
                                    </c:if>

                                </div>
                            </contain>

                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="HomeServlet"><img src="public/img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="HomeServlet">Home</a></li>
                                <!--<li><a href="CategoryServlet">Shop</a></li>-->
                                <li><a href="CategoryServlet?category_id=2">Shop</a></li>
                                <li><a href="#">Page</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="CartServlet">Shop Cart</a></li>
                                        <li><a href="">Check Out</a></li>
                                        <li><a href="">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="">Contact</a></li>
                                <li><a href="">Blog</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                                <li><a href="CartServlet"><i class="fa fa-shopping-bag"></i> <span>${totalQuantity}</span></a></li>
                            </ul>
                            <c:if test="${totalPrice != null}">                                            
                                <div class="header__cart__price">item: <span>${totalPrice}$</span></div>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header> 
