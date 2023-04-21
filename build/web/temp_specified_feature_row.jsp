
<%@page import="java.util.List"%>
<%@page import="database.SpecifiedFeature"%>
<%
    List<SpecifiedFeature> sf_list = (List<SpecifiedFeature>) request.getAttribute("sf_list");
    for (int i = 0; i<sf_list.size(); i++) {
        SpecifiedFeature sf = sf_list.get(i);
%>
<div class="row" id='row<%= i+1%>'>
    <div class="col-md-5">
        <input type="text" class="form-control" disabled="true" id='sf<%= i+1%>' value="<%= sf.getFeature().getFname() %>" />
    </div>
    <div class="col-md-7">
        <input type="text" class="form-control" id='value<%= i+1%>' />
    </div>
</div>
<%
    }
%>
