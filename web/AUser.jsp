<%-- 
    Document   : AUser
    Created on : Nov 11, 2019, 2:34:08 PM
    Author     : Thilini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <link rel="stylesheet" href="plugins/slick/slick.css" />

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <script src="plugins/slick/slick.js"></script>
        <style>
            #img-div{
                float: left; 
                overflow: hidden;
                border: 1px solid #999999;
                height: 150px; 
                margin-left: 15px;
                padding: 0px;
            }
            .image{
                width: 100%;
                height: 150px;
                margin: 0px;
            }
            .form-inline input,select,label{
                margin-bottom: 5px;
            }

            #userView-carousel{
                height: 93%;
                width: 0px;
                position: fixed;
                right: 0px;
                top: 7%;
                display: none;
                border: #f4f4f4 solid 0.5px;
                background-color: #f4f4f4;
            }
            .img-rounded{
                border: 1px solid black;
                padding: 5px;
            }
            #veditHolder{
                margin: 5px;
            }
            #veditHolder img,input,select{
                margin-bottom: 10px;
            }
            #veditHolder span{
                float: left;
                display: block;
            }
        </style>
    </head>
    <body onload="loadUserType();
            loadUser();">
        <%@include file="admin_panel_nav.html" %>
        <jsp:include page="admin_panel_modals.jsp" />

        <div id="panel-container">
            <div class="container">
                <h3>User</h3>
                <button type="button" class="btn btn-primary" onclick="showNewUserModel();">Add User</button>
            </div>
            <br/>
            <div class="container">
                <div class="row">
                    <div class="col-md-1" style="padding: 0; text-align: center;">
                        <label class="has-feedback">Search by:</label>
                    </div>
                    <div class="col-md-11 form-inline" style="padding: 0;">
                        <input type="text" placeholder="your name" class="form-control input-sm" id="sbname" />
                        <input type="text" placeholder="your username" class="form-control input-sm" id="sbuname" />
                        <select class="form-control input-sm" id="sbutype">

                        </select>
                        <input type="text" placeholder="your mobile no" class="form-control input-sm" id="sbmobile" />
                        <input type="text" placeholder="your email address" class="form-control input-sm" id="sbemail" />
                        <span>&nbsp;&nbsp;Date Created:&nbsp;</span>
                        <input type="date" class="form-control input-sm" id="sbdcreate" />
                        <span>&nbsp;&nbsp;Status:&nbsp;</span>
                        <span class="radio-inline" onclick="checkRadio('sbnone');"><input type="radio" name="status" checked="" id="sbnone" />None</span>
                        <span class="radio-inline" onclick="checkRadio('sbactive');"><input type="radio" name="status" id="sbactive" />Active</span>
                        <span class="radio-inline" onclick="checkRadio('sbdeactive');" style="padding-right: 5px;"><input type="radio" name="status" id="sbdeactive" />Deactivate</span>
                        <button class="btn btn-info btn-sm" onclick="loadUser();">Filter</button>
                        <button class="btn btn-primary btn-sm">Clear Search</button>
                    </div>
                </div>
            </div>
            <br/>
            <div class="container">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Username</th>
                            <th>User Type</th>
                            <th>Mobile No</th>
                            <th>Email Address</th>
                            <th>Date Created</th>
                            <th>Date Updated</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="user-tbody">

                    </tbody>
                </table>
            </div>
        </div>

        <!-- user view carousel -->
        <div id="userView-carousel">
            <div class="container" style="width: 400px;" >
                <div class="row">
                    <button type="button" class="btn btn-default btn-sm" onclick="closeUserViewSlider();" style="float: right; margin: 5px;">&times;&nbsp;close&nbsp;</button>
                    <input type="hidden" id="vuid" />
                </div>
                <div class="row" id="veditHolder">
                    <img src="project_res/avatar_customer.png" class="img-rounded" alt="" width="120" height="120">
                    <button class="btn btn-sm btn-default">Change Picture</button>
                    <br/>
                    <span>Name</span>
                    <input type="text" id="vuname" class="form-control" />
                    <span>User Type</span>
                    <select id="vutype" class="form-control">
                        
                    </select>
                    <span>Username</span>
                    <input type="text" id="vusername" class="form-control" />
                    <span>Mobile No</span>
                    <input type="text" id="vumobile" class="form-control"  />
                    <span>Email Address</span>
                    <input type="text" id="vuemail" class="form-control" />
                    <br/>
                    <button class="btn btn-warning">Update</button>
                </div>
            </div>
        </div>
        <!-- user view carousel -->

        <!--        popup dialog-->
        <div class="modal fade" id="addNewUser" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">New User</h4>
                    </div>
                    <div class="modal-body">
                        <label>Name *</label>
                        <input type="text" placeholder="Name" id="uname" class="form-control">
                        <br/>
                        <label>Username (use nic as username ) *</label>
                        <input type="text" placeholder="Username" id="un" class="form-control" style="margin-bottom: 5px;">
                        <br/>
                        <label >User Type</label>
                        <select id="utype" class="form-control">

                        </select>
                        <br/>
                        <label>Contact No *</label>
                        <input type="tel" placeholder="Contact No" id="mobile" class="form-control">
                        <br/>
                        <label>Email Address </label>
                        <input type="email" placeholder="Email Address" id="email" class="form-control">
                        <br/>
                        <label>Profile Photo</label>
                        <div class="row" style="">
                            <div id="img-div" class="col-md-3" >
                                <img src="" class="image" id="uimg">
                            </div>
                            <div class="col-md-7">
                                <input type="file" class="btn btn-default" accept="image/*" onchange="readImageUrl(this);" id="img-file" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                        <button type="button" class="btn btn-success" onclick="addUser();">Add User</button>
                    </div>
                </div>

            </div>
        </div>
        <!--        popup dialog-->

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
        <script type="text/javascript" src="js/admin_js/js_user.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
