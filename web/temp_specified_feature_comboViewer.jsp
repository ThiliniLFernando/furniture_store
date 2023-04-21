<%-- 
    Document   : temp_specified_feature
    Created on : Nov 21, 2019, 2:06:58 PM
    Author     : Thilini
--%>

<%@page import="database.Feature"%>
<%@page import="java.util.Set"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%
    HashMap<Feature, Set<String>> sf_Map = (HashMap<Feature, Set<String>>) request.getAttribute("sf_map");

    StringBuffer sb = new StringBuffer();
    int i = 1;
    for (Feature s : sf_Map.keySet()) {
        if (i > 1) {
            sb.append("#");
        }
        sb.append(s.getId());
        i++;
    }
    String str = sb.toString();
%>
<input type="hidden" value='<%= str%>' id="specified-holder">
<%

    for (Map.Entry<Feature, Set<String>> entry : sf_Map.entrySet()) {
        Feature fn = entry.getKey();
        String un = fn.getFname().toUpperCase();
        Set<String> values = entry.getValue();

%>
<select class="form-control special-search" id='search-<%= fn.getId() %>'>
    <option><%= un%></option>
    <%
        for (String s : values) {
    %>
    <option><%= s%></option>
    <%
        }
    %>
</select>
<%
    }

%>