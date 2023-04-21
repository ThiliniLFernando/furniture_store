<%-- 
    Document   : ASignIn
    Created on : Nov 5, 2019, 10:49:55 AM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Sign In</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />

        <link rel="stylesheet" href="css/admin_css/aMain.css" type="text/css"/>
        <style>
            #box-wraper{
                margin-top: 50px;
                width: 450px;
            }
            #box-wraper input{
                margin-bottom: 8px;
            }
            #box-wraper .btn-right{
                float: right;
            }
            #box-wraper .btn-left{
                float: left;
            }
        </style>
    </head>
    <body>
    <center>
        <div class="panel panel-primary" id="box-wraper">
            <div class="panel-heading">
                <h4>Sign In</h4>
            </div>
            <div class="panel-body">
                <input type="text" class="form-control" placeholder="Username" id="username" >
                <input type="password" class="form-control" placeholder="Password" id="pwd">
                <br/>
                <button type="button" class="btn btn-default btn-left" onclick="replaceSignUpPage();">Create Account</button>
                <button type="button" class="btn btn-primary btn-right" onclick="adminSignIn();">Sign in</button>
            </div>
        </div>
    </center>

    <script type="text/javascript" src="js/admin_js/js_aSignIn.js">
        
    </script>
</body>
</html>