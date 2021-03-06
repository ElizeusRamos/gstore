package com.gstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.CategoriaDAO;
import com.gstore.model.Categoria;

@WebServlet("/CategoriaController")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO cdao = new CategoriaDAO();
       
    public CategoriaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
		
		String codigoString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String ativoString = request.getParameter("ativo");
		
		Categoria categoria = new Categoria();
		
		if(action == null) { 
			action = "read";
		}
		
		if(codigoString != null) {
			int codigo = Integer.parseInt(codigoString);
			categoria.setCodigo(codigo);
			System.err.println("C?digo do cargo: " + categoria.getCodigo());
		}
		
		if(ativoString != null) {
			boolean ativo = Boolean.parseBoolean(ativoString);
			categoria.setAtivo(ativo);
			System.err.println("Status do cargo: " + categoria.isAtivo());
		}
		
		categoria.setNome(nome);
		categoria.setDescricao(descricao);
		
		switch (action) {
		case "create":
			cdao.create(categoria);
			System.err.println("Categoria Adicionada com Sucesso!");
			response.sendRedirect("/GStoreWeb/CategoriaController"); 	
			break;
		case "read":
			request.setAttribute("lista", cdao.list()); 				// devolver a lista de cargos
			System.err.println("Listagem de Categorias completa!");
			request.getRequestDispatcher("/WEB-INF/Categoria.jsp").forward(request, response);
			break;
		case "delete":
			cdao.delete(categoria.getCodigo());
			System.err.println("Cargo Removido!");
			response.sendRedirect("/GStoreWeb/CategoriaController"); 
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
