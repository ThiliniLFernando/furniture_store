<%-- 
    Document   : Home
    Created on : Oct 25, 2019, 10:55:21 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gateway Furniture Store | Home</title>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <link rel="stylesheet" href="css/css_main.css" />

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/js_cLink.js"></script>

        <style>
            .dept-footer{
                text-align: center;
                color: white;
                background-color: black;
                cursor: pointer;
            }
            .dept-panel-body{
                height: 300px; padding: 0;
            }
        </style>
    </head>
    <body>

        <div class="jumbotron">
            <center>
                <h2>Gateway Furniture Store</h2>
            </center>
        </div>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active" style="color: white;"><a href="index.jsp" class="navbar-left-link">Home</a></li>
                        <li ><a href="AdvancedSearch.jsp" class="navbar-left-link"><span>Products</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="CSignInUp.jsp" class="navbar-right-link"><span class="glyphicon glyphicon-user"></span><span>&nbsp;&nbsp;Sign In or Sign Up</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">  
            <h3 >Furniture Departments</h3>
            <br/>
            <div class="row">
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-body dept-panel-body">
                            <img src="project_res/department/livingroom.jpg" class="img-responsive" alt="Image" style="height: 300px;">
                        </div>
                        <div class="panel-footer dept-footer">Living Room</div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-body dept-panel-body">
                            <img src="project_res/department/bedroom_1.jpg" class="img-responsive" alt="Image" style="height: 300px;">
                        </div>
                        <div class="panel-footer dept-footer">Bed Room</div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-body dept-panel-body">
                            <img src="project_res/department/kitchen2.png" class="img-responsive" alt="Image" style="height: 300px;">
                        </div>
                        <div class="panel-footer dept-footer">Kitchen</div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-body dept-panel-body">
                            <img src="project_res/department/dianing_room.jpg" class="img-responsive" alt="Image" style="height: 300px;">
                        </div>
                        <div class="panel-footer dept-footer">Dining Room</div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-body dept-panel-body">
                            <img src="project_res/department/office.jpg" class="img-responsive" alt="Image" style="height: 300px;">
                        </div>
                        <div class="panel-footer dept-footer">Office</div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="client_design_footer.html" %>


    </body>
</html>
