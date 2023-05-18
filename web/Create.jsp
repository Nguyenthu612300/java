<%-- 
    Document   : Create
    Created on : Apr 14, 2023, 8:12:59 AM
    Author     : Nguyen Thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Product</h1>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>

                </div>

                <div class="card-body">
                    <form action="CreateServlet" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Description</label>
                            <input type="text" name="description" class="form-control" id="exampleInputPassword1" placeholder="Description">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Price</label>
                            <input type="text" name="price" class="form-control" id="exampleInputPassword1" placeholder="Price">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Quantity</label>
                            <input type="text" name="quantity" class="form-control" id="exampleInputPassword1" placeholder="Quantity">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">View</label>
                            <input type="text" name="view" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter image">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Category</label>
                            <select name="categoryId" class="form-control">
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>