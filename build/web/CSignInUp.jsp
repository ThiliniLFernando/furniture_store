<%-- 
    Document   : CSignIn
    Created on : Oct 25, 2019, 10:49:59 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gateway Sign In</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <link rel="stylesheet" href="css/css_main.css" />
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp" class="navbar-left-link"><span>Home</span></a></li>
                        <li><a href="AdvancedSearch.jsp" class="navbar-left-link"><span>Products</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="CSignInUp.jsp" class="navbar-right-link"><span class="glyphicon glyphicon-user"></span><span>&nbsp;Your Account</span></a></li>
                        <li><a href="CartView.jsp" class="navbar-right-link"><span class="glyphicon glyphicon-shopping-cart"></span><span>&nbsp;Cart</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br/>
        
        <div class="container"> 
            <div class="row">
                <div class="col-md-6">
                    <center>
                        <div class="panel panel-default box-wraper">
                            <div class="panel-heading">
                                <h4>Sign In</h4>
                            </div>
                            <div class="panel-body">
                                <br/>
                                <input type="text" class="form-control" placeholder="Username" id="email" >
                                <input type="password" class="form-control" placeholder="Password" id="pw">
                                <br/>
                                <button type="button" class="btn btn-default" onclick="cSignIn();">Sign in</button>
                            </div>
                        </div>
                    </center>
                </div>
                
                <div class="col-md-6">
                    <center>
                        <div class="panel panel-default box-wraper">
                            <div class="panel-heading">
                                <h4>Create New Account</h4>
                            </div>
                            <div class="panel-body">
                                <br/>
                                <input type="text" id="signUp-name" placeholder="Name" class="form-control" />
                                <input type="email" id="signUp-email" placeholder="Email" class="form-control"/>
                                <input type="password" id="signUp-pw" placeholder="Password" class="form-control" />
                                <input type="password" id="signUp-retype_pw" placeholder="Retype Password" class="form-control" />
                                <br/>
                                <button class="btn btn-default" onclick="cSignUp();">Create New Account</button>
                            </div>
                        </div>
                    </center>
                </div>
                
            </div>
        </div>
        
        <%@include file="client_design_footer.html" %>

        <script type="text/javascript" src="js/js_cSignInUp.js">

        </script>
    </body>
</html>
