package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import database.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import database.NewHibernateUtil;
import org.hibernate.SessionFactory;

public final class AOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/admin_css/aNavigation.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.min.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.css\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/fontawesome-5.0.1/css/fontawesome-all.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/slick/slick.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"plugins/bootstrap-3/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"plugins/slick/slick.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #orderView-carousel{\n");
      out.write("                height: 93%;\n");
      out.write("                width: 0px;\n");
      out.write("                position: fixed;\n");
      out.write("                right: 0px;\n");
      out.write("                top: 7%;\n");
      out.write("                display: none;\n");
      out.write("                border: #f4f4f4 solid 0.5px;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .img-rounded{\n");
      out.write("                border: 1px solid black;\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("            #veditHolder{\n");
      out.write("                margin: 5px;\n");
      out.write("            }\n");
      out.write("            #veditHolder img,input,select{\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            #veditHolder span{\n");
      out.write("                float: left;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("        <li><a href=\"AOrder.jsp\">Order</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!--        sidebar-->\r\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"panel-container\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h3>User</h3>\n");
      out.write("            </div>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Order Id</th>\n");
      out.write("                        <th>Order Date</th>\n");
      out.write("                        <th>Customer</th>\n");
      out.write("                        <th>Sub Total (LKR)</th>\n");
      out.write("                        <th>Order Status</th>\n");
      out.write("                        <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                        Session s = sessionFactory.openSession();
                        s.clear();
                        Criteria criteria = s.createCriteria(Order.class);
                        List<Order> orders = criteria.list();
                        for (Order o : orders) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( o.getId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( o.getOrderDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( o.getFrontUser().getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( o.getSubTotal());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( o.getOrderStatus());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <button onclick=\"viewOrderItems('");
      out.print( o.getId());
      out.write("');\" class=\"btn btn-primary\">View</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                        s.close();
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- user view carousel -->\n");
      out.write("        <div id=\"orderView-carousel\">\n");
      out.write("            <div class=\"container\" style=\"width: 400px;\" >\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default btn-sm\" onclick=\"closeUserViewSlider();\" style=\"float: right; margin: 5px;\">&times;&nbsp;close&nbsp;</button>\n");
      out.write("                    <input type=\"hidden\" id=\"vuid\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\" id=\"veditHolder\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- user view carousel -->\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function viewOrderItems(id) {\n");
      out.write("                var request = new XMLHttpRequest();\n");
      out.write("                request.onreadystatechange = function() {\n");
      out.write("                    if (request.readyState === 4 && request.status === 200) {\n");
      out.write("                        document.getElementById(\"veditHolder\").innerHTML = request.responseText;\n");
      out.write("                        var boxWidth = $(\"#orderView-carousel\").width();\n");
      out.write("                        document.getElementById(\"orderView-carousel\").style.display = \"block\";\n");
      out.write("                        $(\"#orderView-carousel\").animate({\n");
      out.write("                            right: '0px',\n");
      out.write("                            width: '400px'\n");
      out.write("                        }, \"slow\");\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                request.open(\"GET\", \"SearchOrderItems?\" + \"id=\" + id, true);\n");
      out.write("                request.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function closeUserViewSlider() {\n");
      out.write("                $(\"#orderView-carousel\").animate({\n");
      out.write("                    right: '0px',\n");
      out.write("                    width: '0px'\n");
      out.write("                }, \"slow\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
