<%-- 
    Document   : temp_category
    Created on : Nov 21, 2019, 11:44:51 AM
    Author     : Thilini
--%>
<%@page import="database.Category"%>
<%@page import="java.util.ArrayList"%>

<li><a onclick="setCategoryName('SELECT CATEGORY');">SELECT CATEGORY</a></li>
<%
    ArrayList<Category> cList = (ArrayList<Category>) request.getAttribute("c_list");
    for (Category c : cList) {
        String cat = c.getCname().toUpperCase();
%>
<li><a onclick="setCategoryName('<%= cat %>');"><%= cat %></a></li>
<%
    }
%>