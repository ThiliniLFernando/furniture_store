<%@page import="java.util.List"%>
<%@page import="database.Supplier"%>
<table class="table table-bordered table-condensed table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Contact No</th>
            <th>Email</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="supplier-tbody">
        <%
            List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");
            for (Supplier s : suppliers) {
        %>
        <tr>
            <td><%= s.getId()%></td>
            <td><%= s.getSname()%></td>
            <td><%= s.getSaddress1()%></td>
            <td><%= s.getScity()%></td>
            <td><%= s.getScontactNo()%></td>
            <td><%= s.getEmail()%></td>
            <th>
                <button class="btn btn-warning btn-sm">Update</button>
                <button class="btn btn-danger btn-sm">Delete</button>
            </th>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

<ul class="pagination pagination-sm" id="pagers">
    <li><a onclick="loadSupplier(<%=  Integer.parseInt(request.getParameter("start")) - 8%>);" style="cursor: pointer;">Previous</a></li>
        <%
            Integer pages = (Integer) request.getAttribute("pages");
            for (int i = 1; i <= pages; i++) {
        %>
    <li><a onclick="loadSupplier(<%= (i * 8) - 8%>);" style="cursor: pointer;"><%= i%></a></li>
        <%
            }
            if (Integer.parseInt(request.getParameter("start")) != (pages * 8) - 8) {
        %>
    <li><a onclick="loadSupplier(<%=  Integer.parseInt(request.getParameter("start")) + 8%>);" style="cursor: pointer;">Next</a></li>
        <%
            }
        %>
</ul>