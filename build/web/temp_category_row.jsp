<%@page import="database.Category"%>
<%@page import="java.util.List"%>
<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    for (Category c : categories) {
        String s = "";
        if (c.getCstatus().equals("deactive")) {
            s = "danger";
        }
%>
<tr class='<%= s%>' onclick="setCategoryDetailsToFields(<%= c.getId()%>);">
    <td><%= c.getId()%></td>
    <td><%= c.getCname()%></td>
    <td>
        <%= c.getCstatus()%>
        <%
            if (c.getCstatus().equals("deactive")) {
        %>
        <a onclick="activeCategory('<%= c.getId() %>');" title="Click to reactive category" style="float: right; cursor: pointer;"><u>Activate</u></a>
        <%
            }
        %>
    </td>
</tr>
<%
    }
%>
