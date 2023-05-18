<%-- 
    Document   : login
    Created on : Apr 21, 2023, 10:10:39 AM
    Author     : Nguyen Thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
        <!-- Css Styles -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css"/>
        <link rel="stylesheet" href="./public/css/bootstrap.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link rel="stylesheet" href="./public/css/login.css">

    </head>

    <body>
        <%@include file="./inc/header.jsp" %> 
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="LoginServlet" method="post">
                    <h2 class="login">Login</h2>
                    <input type="email" placeholder="email" name="email"/>
                    <input type="password" placeholder="password" name="password"/>
                    <button type="submit" class="btn btn-primary btn-lg">
                        Login
                    </button>
                    <p class="message">Don't Have an Account? <a href="RegisterServlet">Click Here!</a></p>
                </form>
            </div>
        </div>
        <%@include file="inc/footer.jsp" %>

    </body>
</html>
