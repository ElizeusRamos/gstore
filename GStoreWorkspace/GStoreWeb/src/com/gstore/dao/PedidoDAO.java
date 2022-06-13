package com.gstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Pedido;

public class PedidoDAO {
	private final String QUERY_CREATE = "INSERT INTO pedidos(vendedor, cliente, total) "
			+ "values (?, ?, ?)";
	private final String QUERY_LIST = "SELECT * from pedidos";
	private final String QUERY_DELETE = "DELETE from pedidos WHERE id = ?";
	
	public void create(Pedido pedido) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, pedido.getVendedor());
			ps.setString(2, pedido.getCliente());
			ps.setDouble(3, pedido.getTotalPedido());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar pedido");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Pedido> list() {
		List<Pedido> lista = new ArrayList<Pedido>();
		
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(QUERY_LIST);
		
			//para executar a query
			//pegar resultado da pesquisa
			rs = ps.executeQuery();
			//enquanto houver retorno de proximo
			while(rs.next()) {
				
				Pedido pedido = new Pedido();
				
				pedido.setCodigo(rs.getInt("id"));
				pedido.setVendedor(rs.getString("vendedor"));
				pedido.setCliente(rs.getString("cliente"));
				pedido.setTotalPedido(rs.getDouble("total"));
				
				lista.add(pedido);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar pedidos : " + e.getErrorCode() + " " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}

	public void delete(int id) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_DELETE);
			ps.setInt(1, id);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar remover pedido");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
}
