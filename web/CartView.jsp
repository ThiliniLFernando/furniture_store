<%-- 
    Document   : CartView
    Created on : Nov 20, 2019, 6:35:43 PM
    Author     : Thilini
--%>

<%@page import="database.FrontUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gateway Furniture Store | Cart</title>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <link rel="stylesheet" href="css/css_main.css" />

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.js"></script>
        <style>
            #cart-table td,th{
                text-align: center;
            }
            #cart-table cqty{
                width: 100%;
                margin: 0px;
                //border: none;
            }
            #checkout-btn{
                width: 200px; 
                background-color: black; 
                color: white; 
                font-size: 16px; 
                margin-right: 10px;
                float: right;
            }
            .bottom-row h4{
                padding-right: 10px;
                text-align: right;
            }
        </style>
    </head>
    <body onload="loadCartData();">

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp" class="navbar-left-link"><span>Home</span></a></li>
                        <li ><a href="AdvancedSearch.jsp" class="navbar-left-link"><span>Products</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a data-toggle="modal" data-target="#popup-user-pane" id="user-pane-li" class="navbar-right-link"><span class="glyphicon glyphicon-user"></span><span>&nbsp;Your Account</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <br/><br/>
        <div class="container" id="cart-table">
            <div class="row">
                <table class="table table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Product Id</th>
                            <th>Product</th>
                            <th>Price (LKR)</th>
                            <th>Quantity</th>
                            <th>Total (LKR)</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="cart-tbody">

                    </tbody>
                </table>
            </div>
        </div>

         <!--        popup dialog-->
        <jsp:include page="popup_modal_userAccount.jsp" />
        <!--        popup dialog-->

        <%@include file="client_design_footer.html" %>

        <script type="text/javascript" src="js/js_cMain.js"></script>
        
    </body>
</html>
