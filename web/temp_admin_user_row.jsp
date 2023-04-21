<%-- 
    Document   : temp_admin_user_row
    Created on : Dec 5, 2019, 6:09:42 PM
    Author     : Thilini
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="database.BackendUser"%>
<%@page import="java.util.List"%>
<%!
    static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
%>
<%
    if (request.getAttribute("backendUsers") != null) {
        List<BackendUser> backendUsers = (List<BackendUser>) request.getAttribute("backendUsers");
        for (BackendUser beUser : backendUsers) {
%>
<tr id="<%= beUser.getId()%>">
<input type="hidden" value="<%= beUser.getImage()%>">
<td><%= beUser.getId()%></td>
<td><%= beUser.getName()%></td>
<td><%= beUser.getUsername()%></td>
<td><%= beUser.getRole().getRole()%></td>
<td><%= beUser.getMobile()%></td>
<td><%= beUser.getEmail()%></td>
<td><%= dateFormat.format(beUser.getDateCreated())%></td>
<td><%= dateFormat.format(beUser.getDateUpdate())%></td>
<td><%= beUser.getBuserStatus()%></td>
<td>
    <button class="btn btn-primary btn-sm" onclick="slideUserView('<%= beUser.getId()%>');">view</button>
</td>
</tr>
<%    }
    }
%>
