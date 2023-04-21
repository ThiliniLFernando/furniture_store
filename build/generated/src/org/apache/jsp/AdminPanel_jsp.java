package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.Order;
import database.FrontUser;
import database.Product;
import database.Supplier;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import org.hibernate.Session;
import database.NewHibernateUtil;
import org.hibernate.SessionFactory;
import database.BackendUser;

public final class AdminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/admin_panel_nav.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("\n");
      out.write("        <title>Administrator Panel</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.min.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/fontawesome-5.0.1/css/fontawesome-all.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/admin_css/aNavigation.css\">\n");
      out.write("\n");
      out.write("        <script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"plugins/bootstrap-3/js/bootstrap.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .bg{\n");
      out.write("                color: white;\n");
      out.write("                padding: 7px;\n");
      out.write("                height: 100px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                margin: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .bg:hover{\n");
      out.write("                background-color: #333333;\n");
      out.write("                color: #ffffff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .bg_name{\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .bg_value{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                padding-top: 2px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dashboard-form{\n");
      out.write("                background-color: white;\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .bg_lb{ background:#27a9e3;}\n");
      out.write("            .bg_db{ background:#2295c9;}\n");
      out.write("            .bg_lg{ background:#28b779;}\n");
      out.write("            .bg_dg{ background:#28b779;}\n");
      out.write("            .bg_ly{ background:#ffb848;}\n");
      out.write("            .bg_dy{ background:#da9628;}\n");
      out.write("            .bg_ls{ background:#2255a4;}\n");
      out.write("            .bg_lo{ background:#da542e;}\n");
      out.write("            .bg_lr{ background:#f74d4d;}\n");
      out.write("            .bg_lv{ background:#603bbc;}\n");
      out.write("            .bg_lh{ background:#b6b3b3;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\" id=\"topbar\" style=\"margin-bottom: 0;\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Gateway Furniture Store</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav navbar-nav\">\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            <li><a style=\"cursor: pointer;\" onclick=\"popupUserAccountPane();\"><span class=\"glyphicon glyphicon-user\"></span>&nbsp;Profile</a></li>\r\n");
      out.write("            <li><a style=\"cursor: pointer;\"><span class=\"glyphicon glyphicon-log-out\"></span>&nbsp;Log Out</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!--        top nav bar-->\r\n");
      out.write("\r\n");
      out.write("<!--        sidebar-->\r\n");
      out.write("<div id=\"sidebar\">\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li><a href=\"AdminPanel.jsp\">Dashboard</a></li>\r\n");
      out.write("        <li><a href=\"AUser.jsp\">User</a></li>\r\n");
      out.write("        <li><a href=\"ASupplier.jsp\">Supplier</a></li>\r\n");
      out.write("        <li><a href=\"AProduct.jsp\">Product</a></li>\r\n");
      out.write("        <li><a href=\"ACustomer.jsp\">Customer</a></li>\r\n");
      out.write("        <li><a href=\"#\">Order</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!--        sidebar-->\r\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_panel_modals.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"panel-container\">\n");
      out.write("            ");

                SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                Session hibernateSession = sessionFactory.openSession();
                hibernateSession.clear();
            
      out.write("\n");
      out.write("            <div class=\"container\" style=\"margin: 20px 30px 20px 30px;\">\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-2 bg bg_lb\">\n");
      out.write("                        ");

                            Criteria userCriteria = hibernateSession.createCriteria(BackendUser.class);
                            userCriteria.setProjection(Projections.rowCount());
                        
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <span class=\"fa fa-user fa-2x\"></span>\n");
      out.write("                            <h2 class=\"bg_value\">");
      out.print( userCriteria.uniqueResult());
      out.write("</h2>\n");
      out.write("                            <span class=\"bg_name\">Total Users</span>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2 bg bg_dg\">\n");
      out.write("                        ");

                            Criteria supCriteria = hibernateSession.createCriteria(Supplier.class);
                            supCriteria.setProjection(Projections.rowCount());
                        
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <span class=\"fa fa-bus fa-2x\"></span>\n");
      out.write("                            <h2 class=\"bg_value\">");
      out.print( supCriteria.uniqueResult());
      out.write("</h2>\n");
      out.write("                            <span class=\"bg_name\">Total Suppliers</span>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2 bg bg_ly\">\n");
      out.write("                        ");

                            Criteria productCriteria = hibernateSession.createCriteria(Product.class);
                            productCriteria.setProjection(Projections.rowCount());
                        
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <span class=\"fa fa-tag fa-2x\"></span>\n");
      out.write("                            <h2 class=\"bg_value\">");
      out.print( productCriteria.uniqueResult());
      out.write("</h2>\n");
      out.write("                            <span class=\"bg_name\">Total Products</span>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2 bg bg_lr\">\n");
      out.write("                        ");

                            Criteria clientCriteria = hibernateSession.createCriteria(FrontUser.class);
                            clientCriteria.setProjection(Projections.rowCount());
                        
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <span class=\"fa fa-bus fa-2x\"></span>\n");
      out.write("                            <h2 class=\"bg_value\">");
      out.print( clientCriteria.uniqueResult());
      out.write("</h2>\n");
      out.write("                            <span class=\"bg_name\">Total Customers</span>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2 bg bg_db\">\n");
      out.write("                        ");

                            Criteria orderCriteria = hibernateSession.createCriteria(Order.class);
                            orderCriteria.setProjection(Projections.rowCount());
                        
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <span class=\"fa fa-bus fa-2x\"></span>\n");
      out.write("                            <h2 class=\"bg_value\">");
      out.print( orderCriteria.uniqueResult());
      out.write("</h2>\n");
      out.write("                            <span class=\"bg_name\">Total Orders</span>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 dashboard-form\">\n");
      out.write("                        <h3>User Information</h3>\n");
      out.write("                        <br/>\n");
      out.write("                        <span></span>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                hibernateSession.close();
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/admin_js/js_adminMain.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
