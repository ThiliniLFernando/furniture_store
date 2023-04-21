<%-- 
    Document   : AdvancedSearch
    Created on : Nov 20, 2019, 6:12:04 PM
    Author     : Thilini
--%>

<%@page import="database.FrontUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gateway Furniture Store | Product</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/css_main.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>

        <style>
            .special-search{
                margin-bottom: 5px;
            }

            .search-divs{
                margin: 0px;
                padding: 5px;
            }
            #search-pname{
                width: 300px;
            }
            #loading-div{
                top: 230px;
                left: 600px;
                position: fixed;
                z-index: 99;
            }
        </style>
    </head>
    <body onload="loadDepartmentCat();
            loadCategory();
            filterProducts(0);">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li class="dropdown"><a class="dropdown-toggle navbar-left-link" data-toggle="dropdown" href="#"><span id="dept-dropdown-label">SELECT DEPARTMENT&nbsp;&nbsp;</span><span class="caret"></span></a>
                            <ul class="dropdown-menu" id="dept-dropdown">

                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle navbar-left-link" data-toggle="dropdown" href="#"><span id="category-dropdown-label">SELECT CATEGORY&nbsp;&nbsp;</span><span class="caret"></span></a>
                            <ul class="dropdown-menu" id="category-dropdown">

                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a data-toggle="modal" data-target="#popup-user-pane" id="user-pane-li" class="navbar-right-link"><span class="glyphicon glyphicon-user"></span><span>&nbsp;Your Account</span></a></li>
                        <li><a href="CartView.jsp" class="navbar-right-link"><span class="glyphicon glyphicon-shopping-cart" ></span><span>&nbsp;Cart</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--        Search Container   -->
        <div class="container" id="search-container">
            <div class="row">
                <div class="form-inline col-md-6 search-divs" id="specified-search-div">

                </div>
            </div>
            <div class="row">
                <div class="form-inline col-md-12 search-divs">
                    <input type="text" class="form-control" placeholder="Search by Product Name" id="search-pname">
                    <span>&nbsp;&nbsp;&nbsp;Price&nbsp;From</span>
                    <input type="text" class="form-control" placeholder="Enter Minimum Price" id="search-min-price">
                    <span>&nbsp;to&nbsp;</span>
                    <input type="text" class="form-control" placeholder="Enter Maximum Price" id="search-max-price">
                    <select class="form-control" id="order_by">
                        <option>Order by</option>
                        <option>Price Low to High</option>
                        <option>Price High to Low</option>
                        <option>Model ASC</option>
                        <option>Model DES</option>
                    </select>
                    <button class="btn btn-primary" onclick="filterProducts(0);">Search</button>
                    <button class="btn btn-success" onclick="clearFilters();">Clear Search</button>
                </div>
            </div>
        </div>
        <!--        Search Container   -->


        <!--        Product Container   -->
        <div class="container" id="product-container">

        </div>
        <!--    Product Container   -->


        <!--        popup dialog-->
        <jsp:include page="popup_modal_userAccount.jsp" />
        <!--        popup dialog-->

        <!--        hidden div , loading gif -->

        <div id="loading-div">
            <img alt="Loading..." src="project_res/gif/loading.gif" />
        </div>
        <!--        hidden div , loading gif -->

        <%@include file="client_design_footer.html" %>

        <script type="text/javascript" src="js/js_cMain.js"></script>
    </body>
</html>
