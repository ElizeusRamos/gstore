/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2022-06-19 18:25:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class Categoria_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1647901459469L));
    _jspx_dependants.put("jar:file:/D:/Desenvolvimento/Projetos/eclipse-2021-12/gstore/GStoreWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/GStoreWeb/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153395882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>Gerência - Categorias</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap.min.css\" media=\"screen\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/popper.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/jquery.mask.min.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<a href=\"index.html\" title=\"home\"><img src=\"assets/GStore.png\" class=\"img mx-auto d-block\" alt=\"gstore logotipo\"></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h3>Categorias</h3>\r\n");
      out.write("\t\t\t\t<p>Gerenciamento de categorias</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"row mb-4 mx-auto\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#adicionarModal\">+ Adicionar</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table class=\"table table-dark\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"col\">ID</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"col\">Nome</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"col\">Categoria Ativa</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"col\"></th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Modal Adicionar -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"adicionarModal\" >\r\n");
      out.write("\t\t  <div class=\"modal-dialog\">\r\n");
      out.write("\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t        <h5 class=\"modal-title\">Adicionar Categoria</h5>\r\n");
      out.write("\t\t        <button type=\"button\" class=\"btn-close\" data-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t        <form action=\"/GStoreWeb/CategoriaController\">\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"nome\">Nome</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"nome\" name=\"nome\" aria-descriptedby=\"nomeHelp\" required/>\r\n");
      out.write("\t\t        \t\t<small id=\"nomeHelp\" class=\"form-text text-muted\">Nome da categoria a ser adicionada</small>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"descricao\">Descrição</label>\r\n");
      out.write("\t\t        \t\t<textarea \r\n");
      out.write("\t\t\t        \t\tclass=\"form-control\" id=\"descricao\" name=\"descricao\" \r\n");
      out.write("\t\t\t        \t\taria-descriptedby=\"descricaoHelp\" maxlength=\"255\" style=\"resize: none;\" rows=\"5\"></textarea>\r\n");
      out.write("\t\t        \t\t<small id=\"descricaoHelp\" class=\"form-text text-muted\">Breve descrição até 255 caracteres</small>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<button type=\"submit\" class=\"btn btn-success\">\r\n");
      out.write("\t\t        \t\tAdicionar\r\n");
      out.write("\t\t        \t</button>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<input type=\"hidden\" name=\"action\" value=\"create\"/>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Modal Alterar -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"alterarModal\" >\r\n");
      out.write("\t\t  <div class=\"modal-dialog\">\r\n");
      out.write("\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t        <h5 class=\"modal-title\">Alterar Categoria</h5>\r\n");
      out.write("\t\t        <button type=\"button\" class=\"btn-close\" data-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t        <form action=\"/GStoreWeb/CategoriaController\">\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"id\">ID</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"id\" name=\"id\" readonly/>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"nome\">Nome</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"nome\" name=\"nome\" aria-descriptedby=\"nomeHelp\" required/>\r\n");
      out.write("\t\t        \t\t<small id=\"nomeHelp\" class=\"form-text text-muted\">Nome da categoria a ser alterada</small>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"descricao\">Descrição</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"descricao\" name=\"descricao\" aria-descriptedby=\"descricaoHelp\"/>\r\n");
      out.write("\t\t        \t\t<small id=\"descricaoHelp\" class=\"form-text text-muted\">Breve descrição até 255 caracteres</small>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"ativo\">Cargo Ativo</label>\r\n");
      out.write("\t\t        \t\t<select class=\"form-control\"  id=\"ativo\" name=\"ativo\" aria-descriptedby=\"statusHelp\" required>\r\n");
      out.write("\t\t\t        \t\t<option value=\"none\" selected disabled hidden=\"hidden\">\r\n");
      out.write("\t\t\t\t\t          Selecione uma opção\r\n");
      out.write("\t\t\t\t\t        </option>\r\n");
      out.write("\t\t        \t\t\t<option value=\"true\">ATIVO</option>\r\n");
      out.write("\t\t        \t\t\t<option value=\"false\">INATIVO</option>\r\n");
      out.write("\t\t        \t\t</select>\r\n");
      out.write("\t\t        \t\t<small id=\"statusHelp\" class=\"form-text text-muted\">Status ativo/inativo</small>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<button type=\"submit\" class=\"btn btn-warning\">\r\n");
      out.write("\t\t        \t\tAlterar\r\n");
      out.write("\t\t        \t</button>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<input type=\"hidden\" name=\"action\" value=\"update\"/>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Modal Consultar ou Excluir -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"excluirModal\" >\r\n");
      out.write("\t\t  <div class=\"modal-dialog\">\r\n");
      out.write("\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t        <h5 class=\"modal-title\">Categoria</h5>\r\n");
      out.write("\t\t        <button type=\"button\" class=\"btn-close\" data-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t        <form action=\"/GStoreWeb/CargoController\">\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"id\">ID</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"id\" name=\"id\" readonly/>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"nome\">Nome</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"nome\" name=\"nome\" aria-descriptedby=\"nomeHelp\" readonly/>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"descricao\">Descrição</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"descricao\" name=\"descricao\" readonly/>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<div class=\"form-group\">\r\n");
      out.write("\t\t        \t\t<label for=\"ativo\">Categoria Ativa</label>\r\n");
      out.write("\t\t        \t\t<input class=\"form-control\" type=\"text\" id=\"ativo\" name=\"ativo\" readonly/>\r\n");
      out.write("\t\t        \t</div>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<button type=\"submit\" class=\"btn btn-danger\">\r\n");
      out.write("\t\t        \t\tExcluir\r\n");
      out.write("\t\t        \t</button>\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \t<input type=\"hidden\" name=\"action\" value=\"delete\"/>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction onReadDelete(idP, nomeP, descricaoP, statusP) {\r\n");
      out.write("\t\t\t\tvar id = document.querySelector(\"#excluirModal input[name=id]\");\r\n");
      out.write("\t\t\t\tvar nome = document.querySelector(\"#excluirModal input[name=nome]\");\r\n");
      out.write("\t\t\t\tvar ativo = document.querySelector(\"#excluirModal input[name=ativo]\");\r\n");
      out.write("\t\t\t\tvar descricao = document.querySelector(\"#excluirModal input[name=descricao]\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\tid.value = idP;\r\n");
      out.write("\t\t\t\tnome.value = nomeP;\r\n");
      out.write("\t\t\t\tdescricao.value = descricaoP;\r\n");
      out.write("\t\t\t\tativo.value = statusP;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tfunction onUpdate(idP, nomeP, descricaoP, statusP) {\r\n");
      out.write("\t\t\t\tvar id = document.querySelector(\"#alterarModal input[name=id]\");\r\n");
      out.write("\t\t\t\tvar nome = document.querySelector(\"#alterarModal input[name=nome]\");\r\n");
      out.write("\t\t\t\tvar ativo = document.querySelector(\"#alterarModal input[name=ativo]\");\r\n");
      out.write("\t\t\t\tvar descricao = document.querySelector(\"#alterarModal input[name=descricao]\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\tid.value = idP;\r\n");
      out.write("\t\t\t\tnome.value = nomeP;\r\n");
      out.write("\t\t\t\tdescricao.value = descricaoP;\r\n");
      out.write("\t\t\t\tativo.value = statusP;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/Categoria.jsp(41,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("it");
    // /WEB-INF/Categoria.jsp(41,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/Categoria.jsp(41,5) '${lista}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${lista}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/Categoria.jsp(41,5) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("contador");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-secondary\" \r\n");
          out.write("\t\t\t\t\t\t\t\t\tdata-toggle=\"modal\" data-target=\"#alterarModal\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\tonclick=\"onUpdate('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.codigo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.descricao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.ativo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("')\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\tAlterar\r\n");
          out.write("\t\t\t\t\t\t\t\t</button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-info\" \r\n");
          out.write("\t\t\t\t\t\t\t\t\tdata-toggle=\"modal\" data-target=\"#excluirModal\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\tonclick=\"onReadDelete('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.codigo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.descricao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.ativo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("')\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\tConsultar\r\n");
          out.write("\t\t\t\t\t\t\t\t</button>\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/Categoria.jsp(43,11) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.codigo}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/Categoria.jsp(44,11) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.nome}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/Categoria.jsp(45,11) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${it.ativo}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }
}
