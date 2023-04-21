<%-- 
    Document   : AdminPanel
    Created on : Nov 7, 2019, 3:03:44 PM
    Author     : Thilini
--%>

<%@page import="database.Order"%>
<%@page import="database.FrontUser"%>
<%@page import="database.Product"%>
<%@page import="database.Supplier"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="database.BackendUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">

        <title>Administrator Panel</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css">
        <link rel="stylesheet" href="css/admin_css/aNavigation.css">

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
        <style>
            .bg{
                color: white;
                padding: 7px;
                height: 100px;
                cursor: pointer;
                margin: 10px;
            }

            .bg:hover{
                background-color: #333333;
                color: #ffffff;
            }

            .bg_name{
                font-size: 14px;
            }

            .bg_value{
                margin: 0;
                padding: 0;
                padding-top: 2px;
            }

            .dashboard-form{
                background-color: white;
                padding: 5px;
            }

            .bg_lb{ background:#27a9e3;}
            .bg_db{ background:#2295c9;}
            .bg_lg{ background:#28b779;}
            .bg_dg{ background:#28b779;}
            .bg_ly{ background:#ffb848;}
            .bg_dy{ background:#da9628;}
            .bg_ls{ background:#2255a4;}
            .bg_lo{ background:#da542e;}
            .bg_lr{ background:#f74d4d;}
            .bg_lv{ background:#603bbc;}
            .bg_lh{ background:#b6b3b3;}
        </style>
    </head>
    <body>

        <%@include file="admin_panel_nav.html" %>
        <jsp:include page="admin_panel_modals.jsp" />


        <div id="panel-container">
            <%
                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();
                hibernateSession.clear();
            %>
            <div class="container" style="margin: 20px 30px 20px 30px;">

                <div class="row">
                    <div class="col-sm-2 bg bg_lb">
                        <%
                            Criteria userCriteria = hibernateSession.createCriteria(BackendUser.class);
                            userCriteria.setProjection(Projections.rowCount());
                        %>
                        <center>
                            <span class="fa fa-user fa-2x"></span>
                            <h2 class="bg_value"><%= userCriteria.uniqueResult()%></h2>
                            <span class="bg_name">Total Users</span>
                        </center>
                    </div>
                    <div class="col-sm-2 bg bg_dg">
                        <%
                            Criteria supCriteria = hibernateSession.createCriteria(Supplier.class);
                            supCriteria.setProjection(Projections.rowCount());
                        %>
                        <center>
                            <span class="fa fa-bus fa-2x"></span>
                            <h2 class="bg_value"><%= supCriteria.uniqueResult()%></h2>
                            <span class="bg_name">Total Suppliers</span>
                        </center>
                    </div>
                    <div class="col-sm-2 bg bg_ly">
                        <%
                            Criteria productCriteria = hibernateSession.createCriteria(Product.class);
                            productCriteria.setProjection(Projections.rowCount());
                        %>
                        <center>
                            <span class="fa fa-tag fa-2x"></span>
                            <h2 class="bg_value"><%= productCriteria.uniqueResult()%></h2>
                            <span class="bg_name">Total Products</span>
                        </center>
                    </div>
                    <div class="col-sm-2 bg bg_lr">
                        <%
                            Criteria clientCriteria = hibernateSession.createCriteria(FrontUser.class);
                            clientCriteria.setProjection(Projections.rowCount());
                        %>
                        <center>
                            <span class="fa fa-bus fa-2x"></span>
                            <h2 class="bg_value"><%= clientCriteria.uniqueResult()%></h2>
                            <span class="bg_name">Total Customers</span>
                        </center>
                    </div>
                    <div class="col-sm-2 bg bg_db">
                        <%
                            Criteria orderCriteria = hibernateSession.createCriteria(Order.class);
                            orderCriteria.setProjection(Projections.rowCount());
                        %>
                        <center>
                            <span class="fa fa-bus fa-2x"></span>
                            <h2 class="bg_value"><%= orderCriteria.uniqueResult()%></h2>
                            <span class="bg_name">Total Orders</span>
                        </center>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-4 dashboard-form">
                        <h3>User Information</h3>
                        <br/>
                        <span></span>
                        <input type="text" class="form-control" />
                    </div>
                </div>
            </div>
            <%
                hibernateSession.close();
            %>
        </div>

        <script type="text/javascript" src="js/admin_js/js_adminMain.js"></script>
    </body>
</html>
