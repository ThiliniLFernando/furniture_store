<%-- 
    Document   : AOrder
    Created on : Jan 2, 2020, 3:33:52 PM
    Author     : Thilini
--%>

<%@page import="java.util.List"%>
<%@page import="database.Order"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />
        <link rel="stylesheet" href="plugins/slick/slick.css" />

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <script src="plugins/slick/slick.js"></script>
        <style type="text/css">
            #orderView-carousel{
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
    <body>
        <%@include file="admin_panel_nav.html" %>

        <div id="panel-container">
            <div class="container">
                <h3>User</h3>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Customer</th>
                        <th>Sub Total (LKR)</th>
                        <th>Order Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                        Session s = sessionFactory.openSession();
                        s.clear();
                        Criteria criteria = s.createCriteria(Order.class);
                        List<Order> orders = criteria.list();
                        for (Order o : orders) {

                    %>
                    <tr>
                        <td><%= o.getId()%></td>
                        <td><%= o.getOrderDate()%></td>
                        <td><%= o.getFrontUser().getName()%></td>
                        <td><%= o.getSubTotal()%></td>
                        <td><%= o.getOrderStatus()%></td>
                        <td>
                            <button onclick="viewOrderItems('<%= o.getId()%>');" class="btn btn-primary">View</button>
                        </td>
                    </tr>
                    <%
                        }
                        s.close();
                    %>
                </tbody>
            </table>
        </div>

        <!-- user view carousel -->
        <div id="orderView-carousel">
            <div class="container" style="width: 400px;" >
                <div class="row">
                    <button type="button" class="btn btn-default btn-sm" onclick="closeUserViewSlider();" style="float: right; margin: 5px;">&times;&nbsp;close&nbsp;</button>
                    <input type="hidden" id="vuid" />
                </div>
                <div class="row" id="veditHolder">

                </div>
            </div>
        </div>
        <!-- user view carousel -->

        <script type="text/javascript">
            function viewOrderItems(id) {
                var request = new XMLHttpRequest();
                request.onreadystatechange = function() {
                    if (request.readyState === 4 && request.status === 200) {
                        document.getElementById("veditHolder").innerHTML = request.responseText;
                        var boxWidth = $("#orderView-carousel").width();
                        document.getElementById("orderView-carousel").style.display = "block";
                        $("#orderView-carousel").animate({
                            right: '0px',
                            width: '400px'
                        }, "slow");
                    }
                };
                request.open("GET", "SearchOrderItems?" + "id=" + id, true);
                request.send();

            }

            function closeUserViewSlider() {
                $("#orderView-carousel").animate({
                    right: '0px',
                    width: '0px'
                }, "slow");
            }
        </script>
    </body>
</html>
