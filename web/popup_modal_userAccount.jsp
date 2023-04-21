<%-- 
    Document   : popup_modal_userAccount
    Created on : Nov 28, 2019, 9:33:54 AM
    Author     : Thilini
--%>
<%@page import="database.FrontUser"%>
<div class="modal fade" id="popup-user-pane" role="dialog" style="display: none;">
    <div class="modal-dialog modal-sm">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center>
                    <h4 class="modal-title">Your Account</h4>
                </center>
            </div>
            <div class="modal-body">
                <center>
                    <%
                        FrontUser fu = (FrontUser) session.getAttribute("current_user");
                        if (fu != null) {
                            String img = fu.getImage();
                            if (img == null) {
                                img = "project_res/avatar_customer.png";
                            }
                    %>
                    <div class="row">
                        <div class="col-sm-6">
                            <img src='<%= img%>' width="75" height="75" alt="User Profile" />
                        </div>
                        <div class="col-sm-6">
                            <button data-toggle="modal" data-target="#changePwModal" class="btn btn-sm btn-default" style="width: 120px; color: #339900; border-color: #339900; margin-bottom: 3px;">Change Password</button>
                            <button onclick="logOut();" class="btn btn-sm btn-default" style="width: 120px; color: #ff3300; border-color: #ff3300; margin-bottom: 3px;">Log Out</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <br/>
                            <h4><%= fu.getName().toUpperCase()%></h4>
                            <h5><%= fu.getEmail()%></h5>
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <button type="button" class="btn btn-warning" onclick="window.location = 'CSignInUp.jsp'">Log In or Sign Up</button>
                    <%
                        }
                    %>
                </center>
            </div>
        </div>
    </div>
</div>

<!-- Change Password Modal -->
<div class="modal fade" id="changePwModal" role="dialog">
    <div class="modal-dialog modal-sm">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Change Password</h4>
            </div>
            <div class="modal-body">
                <div id="cpw-well-container" class="">
                    
                </div>
                <span>Current Password</span><span>*</span>
                <input type="password" id="currentPw" class="form-control">
                <br/>
                <span>New Password</span><span>*</span>
                <input type="password" id="newPw" class="form-control">
                <br/>
                <span>Retype Password</span><span>*</span>
                <input type="password" id="retypePw" class="form-control">
                <br/>
            </div>
            <div class="modal-footer">
                <button class="btn btn-warning btn-sm" onclick="changePassword();">Update</button>
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

