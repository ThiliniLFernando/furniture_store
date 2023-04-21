<%-- 
    Document   : temp_cart_row
    Created on : Nov 24, 2019, 2:33:58 PM
    Author     : Thilini
--%>
<%@page import="database.Cart"%>
<%@page import="java.util.List"%>
<%
    if (request.getAttribute("citems") != null) {
        List<Cart> cart_list = (List<Cart>) request.getAttribute("citems");
        if (cart_list.size() > 0) {
            double cart_total = 0;
            for (Cart cart : cart_list) {
                double total = Math.round((cart.getCartQty() * cart.getProduct().getPrice()) * 100.00) / 100.00;
                cart_total += total;
%>
<tr>
    <td>
<center>
    <button class="btn btn-sm" id="remove" onclick="removeCartItem('<%= cart.getProduct().getId()%>')">&times;</button>
</center>
</td>
<td id="pid"><%= cart.getProduct().getId()%></td>
<td id="pname"><%= cart.getProduct().getPname().toUpperCase()%></td>
<td id="pPrice"><%= cart.getProduct().getPrice()%></td>
<td contenteditable="true" id="<%= "cqty" + cart.getProduct().getId()%>"><%= cart.getCartQty()%></td>
<td id="crow-total"><%= total%></td>
<td>
    <button class="btn btn-sm" onclick="updateCartItem('<%= cart.getProduct().getId()%>');"><span class="glyphicon glyphicon-repeat"></span>&nbsp;Update</button>
</td>
</tr>
<%
    }
%>
<tr class="bottom-row">
    <td colspan="3">
        <h4>Cart Total&nbsp;(LKR)</h4>
    </td>
    <td colspan="3">
        <h4><%= cart_total%></h4>
    </td>
</tr>
<tr class="bottom-row">
    <td colspan="6" >
        <input id="checkout-btn" class="btn" value="Check Out" type="submit" onclick="checkOutRedirect('<%= cart_total%>');"/>
    </td>
</tr>
<%
} else {
%>
<tr>
    <td colspan="7">
        <br/>
        <img alt="Empty Cart" src="project_res/empty_shopping_cart.png">
        <h4>You don't have any products in your cart.</h4>
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="7">
        <br/>
        <img alt="Empty Cart" src="project_res/empty_cart.PNG" width="200" height="150">
        <h4>You don't have any products in your cart.Have an Account ? Sign in to see your products.</h4>
    </td>
</tr>
<%
    }
%>
