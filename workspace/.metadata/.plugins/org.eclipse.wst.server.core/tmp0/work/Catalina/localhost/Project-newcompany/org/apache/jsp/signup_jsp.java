/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.43
 * Generated at: 2025-02-07 05:19:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>新規登録</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"container mt-5\">\r\n");
      out.write("\r\n");
      out.write("    <h2 class=\"text-center\">新規登録</h2>\r\n");
      out.write("\r\n");
      out.write("    <!--メッセージ -->\r\n");
      out.write("    <div id=\"messageBox\" class=\"alert d-none\"></div>\r\n");
      out.write("\r\n");
      out.write("    <form id=\"signupForm\" class=\"mx-auto col-md-6 border p-4 rounded shadow\" onsubmit=\"return false;\">\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label class=\"form-label\">ID</label>\r\n");
      out.write("            <input type=\"text\" id=\"userId\" name=\"userId\" class=\"form-control\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label class=\"form-label\">パスワード</label>\r\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label class=\"form-label\">名前</label>\r\n");
      out.write("            <input type=\"text\" name=\"name\" class=\"form-control\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label class=\"form-label\">メールアドレス</label>\r\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mb-3\">\r\n");
      out.write("            <label class=\"form-label\">希望部署</label>\r\n");
      out.write("            <select name=\"department\" class=\"form-select\">\r\n");
      out.write("                <option value=\"エンジニア\">エンジニア</option>\r\n");
      out.write("                <option value=\"運営\">運営</option>\r\n");
      out.write("                <option value=\"営業\">営業</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary w-100\" onclick=\"submitSignup()\">登録に進む</button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <!--Bootstrap JS -->\r\n");
      out.write("    <script src=\"js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- AJAX -->\r\n");
      out.write("    <script>\r\n");
      out.write("        function submitSignup() {\r\n");
      out.write("            if (!validateForm()) return; //確認\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                url: \"SignupAction\",\r\n");
      out.write("                data: $(\"#signupForm\").serialize(),\r\n");
      out.write("                success: function(response) {\r\n");
      out.write("                    if (response.trim() === \"success\") {\r\n");
      out.write("                        $(\"#messageBox\").removeClass(\"d-none alert-danger\").addClass(\"alert-success\")\r\n");
      out.write("                                       .text(\"会員登録が正常に行われました。 ログインページに移動します。\");\r\n");
      out.write("                        setTimeout(() => {\r\n");
      out.write("                            window.location.href = \"login.jsp\"; //ログイン画面に移動\r\n");
      out.write("                        }, 2000); // 2秒後にいくように\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $(\"#messageBox\").removeClass(\"d-none alert-success\").addClass(\"alert-danger\")\r\n");
      out.write("                                       .text(\"重複したIDまたはページエラーです。 情報を再度ご確認の上、再試行してください。\");\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function() {\r\n");
      out.write("                    $(\"#messageBox\").removeClass(\"d-none alert-success\").addClass(\"alert-danger\")\r\n");
      out.write("                                   .text(\"サーバーにエラーが発生しました。 しばらくしてからもう一度お試しください。\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function validateForm() {\r\n");
      out.write("            let userId = document.getElementById(\"userId\").value;\r\n");
      out.write("            let password = document.getElementById(\"password\").value;\r\n");
      out.write("            let email = document.getElementById(\"email\").value;\r\n");
      out.write("\r\n");
      out.write("            let idPattern = /[A-Za-z].*\\d|\\d.*[A-Za-z]/;\r\n");
      out.write("            let passPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.,'])[A-Za-z\\d@$!%*?&.,']{8,16}$/;\r\n");
      out.write("            let emailPattern = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;\r\n");
      out.write("\r\n");
      out.write("            if (!idPattern.test(userId)) {\r\n");
      out.write("                alert(\"IDエラー発生。アルファベットと数字を含めて作成してください。\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!passPattern.test(password)) {\r\n");
      out.write("                alert(\"パスワードエラー発生。大文字と小文字、数字、特殊記号を含めて作成してください。\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!emailPattern.test(email)) {\r\n");
      out.write("                alert(\"メールアドレスエラー発生。有効な電子メール形式ではありません。\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
