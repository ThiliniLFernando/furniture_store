<%-- 
    Document   : temp_product_panel
    Created on : Nov 21, 2019, 5:28:44 AM
    Author     : Thilini
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="database.Image"%>
<%@page import="java.util.HashSet"%>
<%@page import="database.Product"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("p_list");
    Integer pages = (Integer) request.getAttribute("pages");

    String param = request.getParameter("features").toLowerCase().trim();
    int start_page = Integer.parseInt(request.getParameter("start"));

    if (request.getAttribute("p_list") != null) {
        if (products.size() > 0) {
%>
<div class="row" id="pagination-btn">
    <ul class="pagination pagination-sm" id="pagers">

        <li><a onclick="filterProducts(<%=  start_page - 12%>, '');">Previous</a></li>
            <%
                for (int i = 1; i <= pages; i++) {

            %>
        <li><a onclick="filterProducts(<%= (i * 12) - 12%>, '');"><%= i%></a></li>
            <%

                }

                if (start_page != (pages * 12) - 12) {
            %>
        <li><a onclick="filterProducts(<%=  start_page + 12%>, '');">Next</a></li>
            <%
                }
            %>
    </ul>
</div>
<%

%>
<div class="row">
    <%        for (int i = 0; products.size() > i; i++) {
            Product p = products.get(i);
            List<Image> imgs = new ArrayList<Image>(p.getImages());
            String p_name = p.getPname().toUpperCase();

    %>
    <div class="col-sm-3">
        <div class="panel panel-default">
            <div class="panel-body" title="Click to view product details" onclick="window.location = 'ProductView.jsp?u=<%= p.getId()%>'">
                <img src='<%= imgs.get(0).getFilePath()%>' class="img-responsive item-img" alt="Image" id='iimg<%= i%>'>
                <span id='id<%= i%>' class="item-id"><%= p.getId()%></span>
                <br/>
                <span id="iname<%= i%>" class="item-name"><%= p_name%></span>
                <br/>
                <span id="lkr">LKR&nbsp;</span>
                <span id="iprice<%= i%>" class="item-price"><%= p.getPrice()%></span>
            </div>
            <div class="panel-footer">
                <div class="input-group">
                    <input  class="form-control" type="text" placeholder="Quantity" id="<%= "q" + p.getId()%>" style="" />
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-warning" id="btn-add-to-cart" onclick="addToCart('<%= p.getId() %>');" ><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Add to Cart</button>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<%
} else {
%>
<div class="row">
    <center>
        <br/>
        <img alt="Empty Search" src="project_res/empty_search.png">
        <h4>No products were found matching your selection.</h4>
    </center>
</div>
<%
        }
    } else {

    }
%>


