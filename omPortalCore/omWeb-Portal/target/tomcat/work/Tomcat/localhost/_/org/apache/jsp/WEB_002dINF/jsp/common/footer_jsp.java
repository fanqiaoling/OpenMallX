/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-10-21 14:13:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- FOOTER -->\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("    <!-- top footer -->\r\n");
      out.write("    <div class=\"section\">\r\n");
      out.write("        <!-- container -->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <!-- row -->\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-3 col-xs-6\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">About Us</h3>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-map-marker\"></i>1734 Stonecoal Road</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-phone\"></i>+021-95-51-84</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-envelope-o\"></i>email@email.com</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-3 col-xs-6\">\r\n");
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
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"clearfix visible-xs\"></div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-3 col-xs-6\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">Information</h3>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Orders and Returns</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Terms & Conditions</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-3 col-xs-6\">\r\n");
      out.write("                    <div class=\"footer\">\r\n");
      out.write("                        <h3 class=\"footer-title\">Service</h3>\r\n");
      out.write("                        <ul class=\"footer-links\">\r\n");
      out.write("                            <li><a href=\"#\">My Account</a></li>\r\n");
      out.write("                            <li><a href=\"#\">View Cart</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Wishlist</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Track My Order</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Help</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /row -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /container -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /top footer -->\r\n");
      out.write("\r\n");
      out.write("    <!-- bottom footer -->\r\n");
      out.write("    <div id=\"bottom-footer\" class=\"section\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <!-- row -->\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12 text-center\">\r\n");
      out.write("                    <ul class=\"footer-payments\">\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-cc-visa\"></i></a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-credit-card\"></i></a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-cc-paypal\"></i></a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-cc-mastercard\"></i></a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-cc-discover\"></i></a></li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-cc-amex\"></i></a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <span class=\"copyright\">Copyright &copy; 2018.Company name All rights reserved.<a target=\"_blank\" href=\"http://sc.chinaz.com/moban/\">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /row -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /container -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /bottom footer -->\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- /FOOTER -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
