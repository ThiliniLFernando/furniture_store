<%-- 
    Document   : AProduct_Category
    Created on : Nov 16, 2019, 12:00:34 AM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product-Category</title>
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css">

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <style>
            #category-details{
                width: 550px; 
                height: 275px;
                overflow: auto;
                border-bottom: 1px solid #cccccc;
                border-left: 1px solid #cccccc;
            }
            #category-btn{
                margin-right: 20px;
                width: 140px; 
                float: right;
            }
            #category-btn button{
                margin: 2.5px 5px 2.5px 5px;
                float: right;
                width: 100%;
            }
        </style>
    </head>
    <body onload="loadCategoryDatatoTable();">
        <%@include file="admin_panel_nav.html" %>
        

        <div id="panel-container">
            <div class="container">
                <h3>Product</h3>
                <ul class="nav nav-pills">
                    <li><a href="AProduct.jsp">Product List</a></li>
                    <li><a href="AProduct_NewProduct.jsp">New Product</a></li>
                    <li class="active"><a href="#">Category</a></li>
                </ul>
            </div>
            <br/>
            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <input id="hcid" type="hidden" value="" />
                        <span>Category Name *</span>
                        <input type="text" class="form-control" id="cname">
                        <br/>
                        <span>Description</span>
                        <textarea class="form-control" cols="3" id="cdesc"></textarea>
                        <br/>
                        <span>Specified Features</span>
                        <div class="form-inline">
                            <input type="text" class="form-control" id="feature-name">
                            <button class="btn btn-warning" onclick="createNewFeatureTag();">Add</button>
                        </div>
                        <br/>
                        <table class="table table-bordered" id="specified-features">
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-6">
                        <br/>
                        <div class="row" style="width: 100%;">
                            <div class="form-inline">
                                <input type="text" class="form-control" id="search_cat_name">
                                <button class="btn btn-info" onclick="loadCategoryDatatoTable();">Filter</button>
                                <button class="btn btn-info" onclick="resetCategoryTable();">Reset Table</button>
                            </div>
                        </div>
                        <br/>
                        <div class="row" id="category-details">
                            <table class="table table-bordered table-condensed table-hover" >
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Category name</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody id="category-tbody">

                                </tbody>
                            </table>
                        </div>
                        <br/>
                        <div class="row" id="category-btn">
                            <button class="btn btn-primary" onclick="saveCategory();">Save category</button>
                            <button class="btn btn-warning" onclick="updateCategory();">Update category</button>
                            <button class="btn btn-danger" onclick="deleteCategory();">Delete category</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript" src="js/admin_js/js_product.js"></script>
    </body>
</html>
