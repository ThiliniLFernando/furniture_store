package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.FrontUser;

public final class AdvancedSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/client_design_footer.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Gateway Furniture Store | Product</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css_main.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/fontawesome-5.0.1/css/fontawesome-all.css\" />\n");
      out.write("        <script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"plugins/bootstrap-3/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .special-search{\n");
      out.write("                margin-bottom: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .search-divs{\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("            #search-pname{\n");
      out.write("                width: 300px;\n");
      out.write("            }\n");
      out.write("            #loading-div{\n");
      out.write("                top: 230px;\n");
      out.write("                left: 600px;\n");
      out.write("                position: fixed;\n");
      out.write("                z-index: 99;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"loadDepartmentCat();\n");
      out.write("            loadCategory();\n");
      out.write("            filterProducts(0);\">\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle navbar-left-link\" data-toggle=\"dropdown\" href=\"#\"><span id=\"dept-dropdown-label\">SELECT DEPARTMENT&nbsp;&nbsp;</span><span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\" id=\"dept-dropdown\">\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown\"><a class=\"dropdown-toggle navbar-left-link\" data-toggle=\"dropdown\" href=\"#\"><span id=\"category-dropdown-label\">SELECT CATEGORY&nbsp;&nbsp;</span><span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\" id=\"category-dropdown\">\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a data-toggle=\"modal\" data-target=\"#popup-user-pane\" id=\"user-pane-li\" class=\"navbar-right-link\"><span class=\"glyphicon glyphicon-user\"></span><span>&nbsp;Your Account</span></a></li>\n");
      out.write("                        <li><a href=\"CartView.jsp\" class=\"navbar-right-link\"><span class=\"glyphicon glyphicon-shopping-cart\" ></span><span>&nbsp;Cart</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!--        Search Container   -->\n");
      out.write("        <div class=\"container\" id=\"search-container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"form-inline col-md-6 search-divs\" id=\"specified-search-div\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"form-inline col-md-12 search-divs\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Search by Product Name\" id=\"search-pname\">\n");
      out.write("                    <span>&nbsp;&nbsp;&nbsp;Price&nbsp;From</span>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Enter Minimum Price\" id=\"search-min-price\">\n");
      out.write("                    <span>&nbsp;to&nbsp;</span>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Enter Maximum Price\" id=\"search-max-price\">\n");
      out.write("                    <select class=\"form-control\" id=\"order_by\">\n");
      out.write("                        <option>Order by</option>\n");
      out.write("                        <option>Price Low to High</option>\n");
      out.write("                        <option>Price High to Low</option>\n");
      out.write("                        <option>Model ASC</option>\n");
      out.write("                        <option>Model DES</option>\n");
      out.write("                    </select>\n");
      out.write("                    <button class=\"btn btn-primary\" onclick=\"filterProducts(0);\">Search</button>\n");
      out.write("                    <button class=\"btn btn-success\" onclick=\"clearFilters();\">Clear Search</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--        Search Container   -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--        Product Container   -->\n");
      out.write("        <div class=\"container\" id=\"product-container\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--    Product Container   -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--        popup dialog-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "popup_modal_userAccount.jsp", out, false);
      out.write("\n");
      out.write("        <!--        popup dialog-->\n");
      out.write("\n");
      out.write("        <!--        hidden div , loading gif -->\n");
      out.write("\n");
      out.write("        <div id=\"loading-div\">\n");
      out.write("            <img alt=\"Loading...\" src=\"project_res/gif/loading.gif\" />\n");
      out.write("        </div>\n");
      out.write("        <!--        hidden div , loading gif -->\n");
      out.write("\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--        footer      -->\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("    <div class=\"section\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <center>\r\n");
      out.write("                    <h3 id=\"footer-name-title\">Gateway Furniture Store</h3>\r\n");
      out.write("                </center>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">About Us</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-map-marker\"></i>1734 Stonecoal Road</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-phone\"></i>+031-954-51-84</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-envelope-open\"></i>gatewayfurniturestore@email.com</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("<!--                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">Categories</h3>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"#\">Hot deals</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Laptops</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Smartphones</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Cameras</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Accessories</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>-->\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">Service</h3>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"CSignInUp.jsp\">My Account</a></li>\r\n");
      out.write("                            <li><a href=\"CartView.jsp\">View Cart</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Help</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("<!--        footer      -->\r\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/js_cMain.js\"></script>\n");
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
