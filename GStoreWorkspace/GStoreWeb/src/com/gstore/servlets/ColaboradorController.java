package com.gstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.ColaboradorDAO;
import com.gstore.model.Colaborador;

@WebServlet("/ColaboradorController")
public class ColaboradorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ColaboradorDAO cdao = new ColaboradorDAO();
      
    public ColaboradorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String codigoString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cargo = request.getParameter("cargo");
		String descricao = request.getParameter("descricao");
		
		Colaborador colab = new Colaborador();
		
		if(action == null) {
			action = "read";
		}
		
		if(codigoString != null) {
			int codigo = Integer.parseInt(codigoString);
			colab.setCodigo(codigo);
			System.err.println("C?digo do colaborador: " + colab.getCodigo());
		}
		
		colab.setNome(nome);
		colab.setEmail(email);
		colab.setCargo(cargo);
		colab.setDescricao(descricao);
		
		switch (action) {
		case "create":
			cdao.create(colab);
			System.err.println("Colaborador Adicionado com Sucesso!");
			response.sendRedirect("/GStoreWeb/ColaboradorController"); 	
			break;
		case "update":
			cdao.update(colab);
			System.err.println("Colaborador Alterado!");
			response.sendRedirect("/GStoreWeb/ColaboradorController"); 	
			break;
		case "read":
			request.setAttribute("lista", cdao.list()); 				// devolver a lista de colaboradores
			System.err.println("Listagem de Colaboradors completa!");
			request.getRequestDispatcher("/WEB-INF/Colaborador.jsp").forward(request, response);
			break;
		case "delete":
			cdao.delete(colab.getCodigo());
			System.err.println("Colaborador Removido!");
			response.sendRedirect("/GStoreWeb/ColaboradorController"); 
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
