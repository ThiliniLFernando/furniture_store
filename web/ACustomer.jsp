<%-- 
    Document   : ACustomer
    Created on : Nov 11, 2019, 2:34:40 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css">

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>

    </head>
    <body>
        <%@include file="admin_panel_nav.html" %>
        <jsp:include page="admin_panel_modals.jsp" />

        <div id="panel-container">
            <h1>Date Picker</h1>
            <div class="form-group">
                <div class="input-group" id="datetimepicker1">
                    <input type="text" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript">
            $("#datetimepicker1").datetimepicker();
        </script>
    </body>
</html>
