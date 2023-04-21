<%-- 
    Document   : ProductView
    Created on : Nov 21, 2019, 8:19:42 AM
    Author     : Thilini
--%>

<%@page import="java.util.Set"%>
<%@page import="database.ProductFeature"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.Image"%>
<%@page import="java.util.List"%>
<%@page import="database.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gateway Furniture Store | Product View</title>

        <link rel="stylesheet" href="plugins/bootstrap-3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/css_main.css" />
        <link rel="stylesheet" href="plugins/fontawesome-5.0.1/css/fontawesome-all.css" />

        <script src="plugins/jquery/jquery.min.js"></script>
        <script src="plugins/bootstrap-3/js/bootstrap.min.js"></script>
    </head>
    <body onload="">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp" class="navbar-left-link"><span>Home</span></a></li>
                        <li><a href="AdvancedSearch.jsp" class="navbar-left-link"><span>Products</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a data-toggle="modal" data-target="#popup-user-pane" id="user-pane-li" class="navbar-right-link"><span class="glyphicon glyphicon-user"></span><span>&nbsp;Your Account</span></a></li>
                        <li><a href="CartView.jsp" class="navbar-right-link"><span class="glyphicon glyphicon-shopping-cart"></span><span>&nbsp;Cart</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container" id="pdetails">
            <%
                try {
                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session1 = sessionFactory.openSession();
                    session1.clear();
                    Criteria cr1 = session1.createCriteria(Product.class);
                    String param = request.getParameter("u").trim().toUpperCase();
                    if (param != null) {
                        cr1.add(Restrictions.eq("id", param));
                        Product product = (Product) cr1.uniqueResult();
                        List<Image> imges = new ArrayList<Image>(product.getImages());
            %>
            <div class="row">
                <div class="col-md-5">
                    <div class="row">
                        <img src='<%= imges.get(0).getFilePath()%>' class="img-thumbnail" alt="Cinque Terre" width="500" height="500">
                    </div>
                    <div class="row">
                        <h4>Product Specification</h4>
                        <table class="table table-condensed">
                            <%
                                Set<ProductFeature> productF = product.getProductFeatures();
                                for (ProductFeature pf : productF) {
                            %>
                            <tr>
                                <td><%= pf.getFeature().getFname()%></td>
                                <td><%= pf.getFeatureValue()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
                <div class="col-md-7">
                    <h2><%= product.getPname().toUpperCase()%></h2>
                    <h4><%= product.getId()%></h4>
                    <h3 style="color: green;"><span>LKR&nbsp;</span><%= product.getPrice()%></h3>
                    <p><%= product.getPdesc()%></p>
                    <hr>
                    <h4 style="color: red; font-style: italic; font-weight: bold;">Delivery : </h4>
                    <p style="color: red; font-style: italic; font-size: medium;"><%= product.getMpsDateCount() %>&nbsp;working days (Maximum) (to provide the best satisfaction, the manufacturing process will start once you placed the order.)</p>
                        <br/>
                    <div class="col-md-5 input-group">
                        <input class="form-control input-lg" type="text" placeholder="Quantity" id="<%= "q" + product.getId()%>" style="" />
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-lg btn-warning" id="btn-add-to-cart" onclick="addToCart('<%= product.getId()%>');" ><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Add to Cart</button>
                        </span>
                    </div>
                </div>
            </div>
            <%
                    }
                    session1.close();
                } catch (Exception e) {

                }
            %>
        </div>
        
         <!--        popup dialog-->
        <jsp:include page="popup_modal_userAccount.jsp" />
        <!--        popup dialog-->

        <%@include file="client_design_footer.html" %>

        <script type="text/javascript" src="js/js_cMain.js">

        </script>
    </body>
</html>
