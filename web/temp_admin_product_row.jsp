<%-- 
    Document   : temp_admin_product_row
    Created on : Nov 30, 2019, 12:10:15 PM
    Author     : Thilini
--%>
<%@page import="java.util.List"%>
<%@page import="database.Product"%>
<%
    if (request.getAttribute("plist") != null) {
        List<Product> plist = (List<Product>) request.getAttribute("plist");
        for (Product p : plist) {
            String s = "";
            if (p.getPstatus().equals("deactive")) {
                s = "danger";
            }else if(!p.getPstatus().equals("deactive") & p.getPstatus().equals("category_deactive")){
                s = "success";
            }
%>
<tr class="<%= s %>">
    <td><%= p.getId()%></td>
    <td><%= p.getPname()%></td>
    <td><%= p.getDepartment()%></td>
    <td><%= p.getCategory().getCname()%></td>
    <td><%= p.getPrice()%></td>
    <td><%= p.getMaxQtyOrderPerDay()%></td>
    <td><%= p.getMpsDateCount()%></td>
    <td><%= p.getPstatus()%></td>
</tr>
<%
        }
    }
%>
