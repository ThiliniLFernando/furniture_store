<%-- 
    Document   : AProduct
    Created on : Nov 11, 2019, 2:38:12 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css">

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <style type="text/css">
            #product-table{
                width: 1120px; 
            }
        </style>
    </head>
    <body onload="loadDepartments();
            loadCategory();
            loadProducts();">
        
        <%@include file="admin_panel_nav.html" %>
        

        <div id="panel-container">
            <div class="container">
                <h3>Product</h3>
                <ul class="nav nav-pills">
                    <li class="active"><a href="#">Product List</a></li>
                    <li><a href="AProduct_NewProduct.jsp">New Product</a></li>
                    <li><a href="AProduct_Category.jsp">Category</a></li>
                </ul>
            </div>
            <br/>
            <div class="container">
                <div id="search-div" class="container form-inline">
                    <label>Search by: </label>
                    <input type="hidden" value="" id="sdept"/>
                    <select class="form-control input-sm" id="department" onchange="document.getElementById('sdept').value = this.value;">

                    </select>
                    <select class="form-control input-sm" id="product-category">
                        <option></option>
                    </select>
                    <input type="text" placeholder="Product Name" class="form-control input-sm" id="search_name">
                    <select class="form-control input-sm" id="feature-type">
                        <option></option>
                    </select>
                    <select class="form-control input-sm" id="feature-value">
                        <option></option>
                    </select>
                    <button class="btn btn-info btn-sm">Filter</button>
                    <button class="btn btn-primary btn-sm">Clear Search</button>
                </div>
                <br/>
                <div id="product-details">
                    <table class="table table-hover table-bordered" id="product-table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Department</th>
                                <th>Category</th>
                                <th>Price (LKR)</th>
                                <th>Max qty<br/>order per day</th>
                                <th>Days to<br/>process</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody id="product-tbody">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript" src="js/admin_js/js_product.js" ></script>
    </body>
</html>
