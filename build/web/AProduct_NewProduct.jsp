<%-- 
    Document   : AProduct_NewProduct
    Created on : Nov 15, 2019, 11:57:48 PM
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
        <style>
            #img-container{
                margin-top: 5px;
                margin-bottom: 5px;
                height: 330px;
                width: 600px;
                border: #cccccc 1px solid;
                overflow-x: hidden;
                overflow-y: auto;
                padding: 15px 15px 0px 15px;
                background-image: url('web_res/default_photo.png');
                background-size: 25%;
                background-repeat: no-repeat;
                background-position: center;
            }
            .img-div{
                width: 100%;
                float: left; 
                overflow: hidden;
                margin-bottom: 15px;
            }
            .image{
                width: 100%;
                height: auto;
            }
            
            #feature-container .row{
                margin-bottom: 5px;
            }
            #save-product{
                float: right;
                width: 150px;
            }
        </style>
    </head>
    <body onload="loadCategory();generateProductId();">
        <%@include file="admin_panel_nav.html" %>
        

        <div id="panel-container">
            <div class="container">
                <h3>Product</h3>
                <ul class="nav nav-pills">
                    <li><a href="AProduct.jsp">Product List</a></li>
                    <li class="active"><a href="#">New Product</a></li>
                    <li><a href="AProduct_Category.jsp">Category</a></li>
                </ul>
            </div>
            <br/>
            <div class="container">
                <div class="row">

                    <div class="col-md-5">
                        <span>Product Id *</span>
                        <input type="text" class="form-control" id="pid" disabled="">
                        <br/>
                        <span>Product Name *</span>
                        <input type="text" class="form-control" id="pname">
                        <br/>
                        <span>Description *</span>
                        <textarea class="form-control" rows="2" id="pdesc"></textarea>
                        <br/>
                        <span>Department *</span>
                        <select class="form-control" id="pdepartment">
                            <option>Living room</option>
                            <option>Bed room</option>
                            <option>Kitchen</option>
                            <option>Laundry</option>
                            <option>Dining room</option>
                            <option>Office</option>
                            <option>Restaurant</option>
                        </select>
                        <br/>
                        <div class="row">
                            <div class="col-sm-6">
                                <span>Price *</span>
                                <input type="text" class="form-control" id="pprice">
                            </div>
                            <div class="col-sm-6">
                                <span>Quantity per day *</span>
                                <input type="text" class="form-control" id="pqty">
                            </div>
                        </div>
                        <br/>
                        <span>Warranty Details </span>
                        <textarea class="form-control" rows="3" id="pwarranty"></textarea>
                        <br/>
                        <span>How many days to manufacture furniture *</span>
                        <input class="form-control" id="pdatec"  type="number"/>
                        <br/>
                        <span>Category *</span>
                        <select class="form-control" id="product-category" onchange="findSpecifiedFeatures();">
                            
                        </select>
                    </div>

                    <div class="col-md-7">
                        <span>Product Images</span>
                        <div id="img-container">
                            <div class="img-div">
                                <img src="" alt="" class="image" id="img1" />
                            </div>
                        </div>
                        <div class="form-inline">
                            <input type="file" class="btn btn-default" id="image-upload" multiple="" accept="image/*" onchange="readURL(this);">
                            
                        </div>
                        
                    </div>

                </div>
                <div class="row" style="margin-bottom: 200px;">

                    <div class="col-md-5">
                        <br/>
                        <div id="feature-container">

                        </div>
                    </div>

                    <div class="col-md-7" style="padding-right: 90px;">
                        <br/>
                        <button class="btn btn-primary" id="save-product" onclick="saveProduct();">Save Product</button>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript" src="js/admin_js/js_product.js"></script>
    </body>
</html>
