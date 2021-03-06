package com.gstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.ProdutoDAO;
import com.gstore.model.Produto;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDAO pdao = new ProdutoDAO();
       
    public ProdutoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String precoString = request.getParameter("preco");
		String idString = request.getParameter("id");
		String qtdeString = request.getParameter("qtde");
		
		Produto pd = new Produto();
		
		if(action == null) {
			action = "read";
		}
		
		if(idString != null) {
			Integer codigo = Integer.parseInt(idString);
			pd.setCodigo(codigo);
		}
		
		if(precoString != null) {
			Double preco = Double.parseDouble(precoString);
			pd.setPreco(preco);
		}
		
		if(qtdeString != null) {
			int qtde = Integer.parseInt(qtdeString);
			pd.setQtde(qtde);
		}
		
		pd.setNome(nome);
		pd.setDescricao(descricao);
		
		switch (action) {
		case "create":
			pdao.create(pd);
			System.err.println("Produto Cadastrado!");
			response.sendRedirect("/GStoreWeb/ProdutoController"); 	
			break;
		case "update":
			pdao.update(pd);
			System.err.println("Produto Alterado!");
			response.sendRedirect("/GStoreWeb/ProdutoController"); 	
			break;
		case "read":
			request.setAttribute("lista", pdao.list()); 				// devolver a lista de produtos
			System.err.println("Listagem de Produtos completa!");
			request.getRequestDispatcher("/WEB-INF/Produto.jsp").forward(request, response);
			break;
		case "delete":
			pdao.delete(pd.getCodigo());
			System.err.println("Produto Removido!");
			response.sendRedirect("/GStoreWeb/ProdutoController"); 
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
