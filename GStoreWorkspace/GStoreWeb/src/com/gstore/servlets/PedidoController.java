package com.gstore.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gstore.dao.PedidoDAO;
import com.gstore.model.Pedido;

@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDAO pdao = new PedidoDAO();
       
    public PedidoController() {
        super();// TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String codigoString = request.getParameter("id");
		String vendedor = request.getParameter("vendedor");
		String cliente = request.getParameter("cliente");
		String totalString = request.getParameter("total");
		
		Pedido pedido = new Pedido();
		
		if(action == null) {
			action = "read";
		}
		
		if(codigoString != null) {
			int codigo = Integer.parseInt(codigoString);
			pedido.setCodigo(codigo);
			System.err.println("Código do pedido: " + pedido.getCodigo());
		}
		
		if(totalString != null) {
			double total = Double.parseDouble(totalString);
			pedido.setTotalPedido(total);
			System.err.println("Total do Pedido: " + pedido.getTotalPedido());
		}
		
		pedido.setVendedor(vendedor);
		pedido.setCliente(cliente);
		
		switch (action) {
		case "create":
			pdao.create(pedido);
			System.err.println("Pedido Adicionado com Sucesso!");
			response.sendRedirect("/GStoreWeb/PedidoController"); 	
			break;
		case "read":
			request.setAttribute("lista", pdao.list()); 				// devolver a lista de Pedidos
			System.err.println("Listagem de Pedidos completa!");
			request.getRequestDispatcher("/WEB-INF/Pedido.jsp").forward(request, response);
			break;
		case "delete":
			pdao.delete(pedido.getCodigo());
			System.err.println("Pedido Removido!");
			response.sendRedirect("/GStoreWeb/PedidoController"); 
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
