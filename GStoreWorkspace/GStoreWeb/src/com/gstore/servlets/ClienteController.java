package com.gstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.ClienteDAO;
import com.gstore.model.Cliente;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO cdao = new ClienteDAO();
       
    public ClienteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String codigoString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String cpf = request.getParameter("cpf");
		
		Cliente cli = new Cliente();
		
		if(action == null) {
			action = "read";
		}
		
		if(codigoString != null) {
			int codigo = Integer.parseInt(codigoString);
			cli.setCodigo(codigo);
			System.err.println("C?digo do cliente: " + cli.getCodigo());
		}
		
		cli.setNome(nome);
		cli.setEmail(email);
		cli.setTelefone(telefone);
		cli.setEndereco(endereco);
		cli.setBairro(bairro);
		cli.setCep(cep);
		cli.setCidade(cidade);
		cli.setCpf(cpf);
		
		switch (action) {
		case "create":
			cdao.create(cli);
			System.err.println("Cliente Adicionado com Sucesso!");
			response.sendRedirect("/GStoreWeb/ClienteController"); 	
			break;
		case "update":
			cdao.update(cli);
			System.err.println("Cliente Alterado!");
			response.sendRedirect("/GStoreWeb/ClienteController"); 	
			break;
		case "read":
			request.setAttribute("lista", cdao.list()); 				// devolver a lista de clientes
			System.err.println("Listagem de Clientes completa!");
			request.getRequestDispatcher("/WEB-INF/Cliente.jsp").forward(request, response);
			break;
		case "delete":
			cdao.delete(cli.getCodigo());
			System.err.println("Cliente Removido!");
			response.sendRedirect("/GStoreWeb/ClienteController"); 
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
