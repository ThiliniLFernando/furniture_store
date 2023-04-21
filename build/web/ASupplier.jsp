<%-- 
    Document   : ASupplier
    Created on : Nov 11, 2019, 9:04:22 AM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Supplier</title>

        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css">

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
    </head>
    <body onload="loadSupplier(0);">
        <%@include file="admin_panel_nav.html" %>
        <jsp:include page="admin_panel_modals.jsp" />

        <div id="panel-container">
            <div class="container">
                <h3>Supplier</h3>  
                <button type="button" class="btn btn-primary" onclick="showNewSupplierModel();">Add Supplier</button>
                <br/><br/>
                <div id="search-div" class="container form-inline">
                    <label>Search by: </label>
                    <input type="text" placeholder="Name" class="form-control input-sm" id="search_name">
                    <input type="text" placeholder="City" class="form-control input-sm" id="search_city">
                    <input type="tel" placeholder="Contcact No" class="form-control input-sm" id="search_mobile">
                    <input type="email" placeholder="Email" class="form-control input-sm" id="search_email">
                    <button class="btn btn-info btn-sm">Filter</button>
                    <button class="btn btn-primary btn-sm">Clear Search</button>
                </div>

                <div id="supplier-details">

                </div>
            </div>
        </div>

        <!--        popup dialog-->
        <div class="modal fade" id="addNewSupplier" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">New Supplier</h4>
                    </div>
                    <div class="modal-body">
                        <label>Name *</label>
                        <input type="text" placeholder="Name" id="sname" class="form-control">
                        <br/>
                        <label>Address *</label>
                        <input type="text" placeholder="Address No,Street" id="saddress" class="form-control" style="margin-bottom: 5px;">
                        <input type="text" placeholder="City" id="scity" class="form-control">
                        <br/>
                        <label>Contact No *</label>
                        <input type="tel" placeholder="Contact No" id="scontactNo" class="form-control">
                        <br/>
                        <label>Email</label>
                        <input type="email" placeholder="Email" id="semail" class="form-control">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" onclick="addSupplier();">Add Supplier</button>
                    </div>
                </div>

            </div>
        </div>
        <!--        popup dialog-->

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript" src="js/admin_js/js_supplier.js"></script>
    </body>
</html>
