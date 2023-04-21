<%-- 
    Document   : temp_order_items_viewer
    Created on : Jan 2, 2020, 5:57:51 PM
    Author     : Thilini
--%>

<%@page import="java.util.Set"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="database.OrderProduct"%>
<%
    if (request.getAttribute("ops") != null) {
        Set<OrderProduct> ops = (Set<OrderProduct>) request.getAttribute("ops");
        %>
        <table class="table table-bordered">
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
            <%
            for(OrderProduct op : ops){
            %>
            <tr>
                <td><%= op.getProduct().getPname() %></td>
                <td><%= op.getOrderPrice() %></td>
                <td><%= op.getOrderQty() %></td>
                <td><%= op.getRowTotal() %></td>
            </tr>
            <%
            }
            %>
        </table>
<%
    }
%>
