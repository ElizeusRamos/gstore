package com.gstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.CargoDAO;
import com.gstore.model.Cargo;

@WebServlet("/CargoController")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CargoDAO cdao = new CargoDAO();
       
    public CargoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String codigoString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String ativoString = request.getParameter("ativo");
		
		Cargo cargo = new Cargo();
		
		if(action == null) {
			action = "read";
		}
		
		if(codigoString != null) {
			int codigo = Integer.parseInt(codigoString);
			cargo.setCodigo(codigo);
			System.err.println("Código do cargo: " + cargo.getCodigo());
		}
		
		if(ativoString != null) {
			boolean ativo = Boolean.parseBoolean(ativoString);
			cargo.setAtivo(ativo);
			System.err.println("Status do cargo: " + cargo.isAtivo());
		}
		
		cargo.setNome(nome);
		cargo.setDescricao(descricao);
		
		switch (action) {
		case "create":
			cdao.create(cargo);
			System.err.println("Cargo Adicionado com Sucesso!");
			response.sendRedirect("/GStoreWeb/CargoController"); 	
			break;
		case "update":
			cdao.update(cargo);
			System.err.println("Cargo Alterado!");
			response.sendRedirect("/GStoreWeb/CargoController"); 	
			break;
		case "read":
			request.setAttribute("lista", cdao.list()); 				// devolver a lista de cargos
			System.err.println("Listagem de Cargos completa!");
			request.getRequestDispatcher("/WEB-INF/Cargo.jsp").forward(request, response);
			break;
		case "delete":
			cdao.delete(cargo.getCodigo());
			System.err.println("Cargo Removido!");
			response.sendRedirect("/GStoreWeb/CargoController"); 
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
