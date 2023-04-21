package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Gateway Furniture Store | Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap-3/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/fontawesome-5.0.1/css/fontawesome-all.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css_main.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"plugins/bootstrap-3/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/js_cLink.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .dept-footer{\n");
      out.write("                text-align: center;\n");
      out.write("                color: white;\n");
      out.write("                background-color: black;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .dept-panel-body{\n");
      out.write("                height: 300px; padding: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <center>\n");
      out.write("                <h2>Gateway Furniture Store</h2>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\" style=\"color: white;\"><a href=\"index.jsp\" class=\"navbar-left-link\">Home</a></li>\n");
      out.write("                        <li ><a href=\"AdvancedSearch.jsp\" class=\"navbar-left-link\"><span>Products</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"CSignInUp.jsp\" class=\"navbar-right-link\"><span class=\"glyphicon glyphicon-user\"></span><span>&nbsp;&nbsp;Sign In or Sign Up</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">  \n");
      out.write("            <h3 >Furniture Departments</h3>\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body dept-panel-body\">\n");
      out.write("                            <img src=\"project_res/department/livingroom.jpg\" class=\"img-responsive\" alt=\"Image\" style=\"height: 300px;\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer dept-footer\">Living Room</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body dept-panel-body\">\n");
      out.write("                            <img src=\"project_res/department/bedroom_1.jpg\" class=\"img-responsive\" alt=\"Image\" style=\"height: 300px;\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer dept-footer\">Bed Room</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body dept-panel-body\">\n");
      out.write("                            <img src=\"project_res/department/kitchen2.png\" class=\"img-responsive\" alt=\"Image\" style=\"height: 300px;\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer dept-footer\">Kitchen</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body dept-panel-body\">\n");
      out.write("                            <img src=\"project_res/department/dianing_room.jpg\" class=\"img-responsive\" alt=\"Image\" style=\"height: 300px;\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer dept-footer\">Dining Room</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body dept-panel-body\">\n");
      out.write("                            <img src=\"project_res/department/office.jpg\" class=\"img-responsive\" alt=\"Image\" style=\"height: 300px;\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer dept-footer\">Office</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
      out.write("\n");
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
