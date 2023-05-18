<%-- 
    Document   : register
    Created on : Apr 21, 2023, 10:10:50 AM
    Author     : Nguyen Thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/register.css">
    </head>

    <body>
        <%@include file="./inc/header.jsp" %> 
        <!-- sign up -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">
                    <h4 style="text-align: center;">SIGN UP</h4>
                    <form action="RegisterServlet" method="post">
                        <span>${error}</span>
                        <div class="checkout__input">
                            <p>Email<span>*</span></p>
                            <input type="email" placeholder="Email*" name="email"></div>
                        <div class="checkout__input">
                            <p>Password<span>*</span></p>
                            <input type="password" placeholder="Password*" name="password"></div>

                        <p>Create an account by entering the button below. If you are a returning customer
                            please login at the top of the page</p>
                        <div class="center">
                            <button type="submit" class="site-btn">Create an account</button></div>
                    </form>
                </div>
            </div>
        </section>

        <!-- Footer Section Begin -->
        <%@include file="inc/footer.jsp" %>
    </body>
</html>
