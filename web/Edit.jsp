<%-- 
    Document   : Edit
    Created on : Apr 10, 2023, 4:43:32 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Products</h1>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Edit Products
                    </div>
                    <div class="card-body">
                        <form action="EditServlet" method="post">
                            <input type="hidden" name="product_id" value="${product.id}"/>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Name</label>
                                <input type="text" name="name" value="${product.name}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Description</label>
                                <input type="text" name="description" value="${product.description}" class="form-control" id="exampleInputPassword1" placeholder="Description">
                            </div>

                            <!--                                    <div class="form-group">
                                                                    <label for="exampleInputPassword1">Price</label>
                                                                    <input type="text" name="price" value="${product.price}" class="form-control" id="exampleInputPassword1" placeholder="Description">
                                                                </div>
                            
                                                                <div class="form-group">
                                                                    <label for="exampleInputPassword1">Quantity</label>
                                                                    <input type="text" name="quantity" value="${product.quantity}" class="form-control" id="exampleInputPassword1" placeholder="Description">
                                                                </div>-->


                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>