package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/admin_css/aNavigation.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.min.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/fontawesome-5.0.1/css/fontawesome-all.css\">\n");
      out.write("\n");
      out.write("        <script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"plugins/bootstrap-3/js/bootstrap.min.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #product-table{\n");
      out.write("                width: 1120px; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"loadDepartments();\n");
      out.write("            loadCategory();\n");
      out.write("            loadProducts();\">\n");
      out.write("        \n");
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
      out.write("        <div id=\"panel-container\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h3>Product</h3>\n");
      out.write("                <ul class=\"nav nav-pills\">\n");
      out.write("                    <li class=\"active\"><a href=\"#\">Product List</a></li>\n");
      out.write("                    <li><a href=\"AProduct_NewProduct.jsp\">New Product</a></li>\n");
      out.write("                    <li><a href=\"AProduct_Category.jsp\">Category</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div id=\"search-div\" class=\"container form-inline\">\n");
      out.write("                    <label>Search by: </label>\n");
      out.write("                    <input type=\"hidden\" value=\"\" id=\"sdept\"/>\n");
      out.write("                    <select class=\"form-control input-sm\" id=\"department\" onchange=\"document.getElementById('sdept').value = this.value;\">\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <select class=\"form-control input-sm\" id=\"product-category\">\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"text\" placeholder=\"Product Name\" class=\"form-control input-sm\" id=\"search_name\">\n");
      out.write("                    <select class=\"form-control input-sm\" id=\"feature-type\">\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                    <select class=\"form-control input-sm\" id=\"feature-value\">\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                    <button class=\"btn btn-info btn-sm\">Filter</button>\n");
      out.write("                    <button class=\"btn btn-primary btn-sm\">Clear Search</button>\n");
      out.write("                </div>\n");
      out.write("                <br/>\n");
      out.write("                <div id=\"product-details\">\n");
      out.write("                    <table class=\"table table-hover table-bordered\" id=\"product-table\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Id</th>\n");
      out.write("                                <th>Name</th>\n");
      out.write("                                <th>Department</th>\n");
      out.write("                                <th>Category</th>\n");
      out.write("                                <th>Price (LKR)</th>\n");
      out.write("                                <th>Max qty<br/>order per day</th>\n");
      out.write("                                <th>Days to<br/>process</th>\n");
      out.write("                                <th>Status</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody id=\"product-tbody\">\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/admin_js/js_adminMain.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/admin_js/js_product.js\" ></script>\n");
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
