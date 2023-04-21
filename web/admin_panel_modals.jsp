<%-- 
    Document   : admin_panel_modals
    Created on : Dec 2, 2019, 10:58:27 AM
    Author     : Thilini
--%>

<%@page import="database.BackendUser"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    Session hibernateSession = sessionFactory.openSession();
%>
<!-- Modal -->
<div id="userAccountModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">User Profile</h4>
            </div>
            <div class="modal-body">
                <center>
                    <%
                        if (session.getAttribute("current_user") != null) {
                            BackendUser beUser = (BackendUser) session.getAttribute("current_user");
                    %>
                    <h3><%= beUser.getName() %></h3>
                    <%
                        } else {

                        }
                    %>
                </center>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<%
    hibernateSession.close();
%>
