<%-- 
    Document   : temp_department
    Created on : Nov 20, 2019, 10:55:54 PM
    Author     : Thilini
--%>
<%@page import="java.util.ArrayList"%>

<%
    if (request.getParameter("rc").equals("101")) {
%>
<li><a onclick="setDepartmentName('SELECT DEPARTMENT');">SELECT DEPARTMENT</a></li>
    <%
        ArrayList<String> pList = (ArrayList<String>) request.getAttribute("pList");
        for (String s : pList) {
            String s1 = s.toUpperCase();
    %>
<li><a onclick="setDepartmentName('<%= s1%>');"><%= s1%></a></li>
    <%
        }
    } else if (request.getParameter("rc").equals("100")) {
    %>
<li><a onclick="listDeptOnClick('SELECT DEPARTMENT');">SELECT DEPARTMENT</a></li>
    <%
        ArrayList<String> pList = (ArrayList<String>) request.getAttribute("pList");
        for (String s : pList) {
            String s1 = s.toUpperCase();
    %>
<li><a onclick="listDeptOnClick('<%= s1%>');"><%= s1%></a></li>
<%
        }
    }
%>