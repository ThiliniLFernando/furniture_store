<%-- 
    Document   : ASignUp
    Created on : Nov 5, 2019, 4:02:43 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Sign Up</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />

        <link rel="stylesheet" href="css/admin_css/aMain.css">
        <style>
            #box-wraper{
                margin-top: 50px;
                width: 450px;
            }
            #box-wraper input,select{
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
                <h4>Create New Account</h4>
            </div>
            <div class="panel-body">
                <input type="text" required="" placeholder="Your Name" class="form-control" id="name">
                <input type="email" required="" placeholder="Username" class="form-control" id="username">
                <select class="form-control" id="role">
                    <option>Admin</option>
                    <option>Manager</option>
                </select>
                <input type="password" required="" placeholder="Password" class="form-control" id="pwd">
                <input type="password" required="" placeholder="Retype Password" class="form-control" id="retype_pwd">
                <br/>
                <button class="btn btn-default btn-left" onclick="replaceSignInPage();" >Sign In</button>
                <button class="btn btn-primary btn-right" onclick="adminSignUp();">Create New Account</button>
            </div>
        </div>
    </center>

    <script type="text/javascript" src="js/admin_js/js_aSignUp.js">

    </script>
</body>
</html>
