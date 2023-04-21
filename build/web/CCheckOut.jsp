<%-- 
    Document   : CCheckOut
    Created on : Dec 14, 2019, 11:10:28 PM
    Author     : Thilini
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="database.Cart"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.FrontUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gateway Furniture Store | CheckOut</title>
    </head>
    <body onload="document.forms['g'].submit();">

    <center>
        <h3>Payment Gateway</h3>

        <%
            String total = "200";
            if(session.getAttribute("cart_total") != null){
               total = session.getAttribute("cart_total").toString();
            }
        %>

        <form id="g" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <!-- Identify your business so that you can collect the payments. -->
            <input type="hidden" name="business" value="gatewayfurniture@gmail.com">

            <!-- Specify a Buy Now button. -->
            <input type="hidden" name="cmd" value="_xclick">

            <!-- Specify details about the item that buyers will purchase. -->
            <input type="hidden" name="item_name" value="Cart Payment">
            <input type="hidden" name="amount" value="<%= total%>">
            <input type="hidden" name="currency_code" value="USD">

            <input type="hidden" name="return" value="http://localhost:8080/FinalFurnitureStore/payment_success.jsp">
            <input type="hidden" name="cancel_return" value="http://localhost:8080/FinalFurnitureStore/payment_cancel.jsp">

            <!-- Display the payment button. -->
            <input type="image" name="submit" border="0"
                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                   alt="Buy Now">
            <img alt="" border="0" width="1" height="1"
                 src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

        </form>
    </center>
</body>
</html>
