<%-- 
    Document   : hero
    Created on : Apr 27, 2023, 9:56:35 AM
    Author     : Nguyen Thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>S
<!DOCTYPE html>
<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fas fa-bars"></i>
                        <span>All departments</span>
                    </div>
                    <ul>

                        <c:forEach items="${categoryList}" var="category">
                            <li><a href="CategoryServlet?category_id=${category.id}">${category.name}</a></li>
                            </c:forEach>



                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="SearchServlet" method="get">
                            <div class="hero__search__categories">
                                All Categories
                                <span class="arrow_carrot-down"></span>
                            </div>
                            <input name="search" type="search" type="text" placeholder="What do you need?">
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fas fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+65 11.188.888</h5>
                            <span>support from 8 to 22h</span>
                        </div>
                    </div>
                </div>
                <div class="hero__item set-bg" data-setbg="public/img/hero/banner.jpg" style="background-image: url(public/img/hero/banner.jpg) ;">
                    <div class="hero__text">
                        <span>FRUIT FRESH</span>
                        <h2>Vegetable <br />100% Organic</h2>
                        <p>Free Pickup and Delivery Available</p>
                        <a href="#" class="primary-btn">SHOP NOW</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

