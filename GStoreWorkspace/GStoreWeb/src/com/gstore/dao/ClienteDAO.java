package com.gstore.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Cliente;

public class ClienteDAO {
	
	private final String QUERY_CREATE = "INSERT INTO clientes(nome, email, telefone, endereco, bairro, cep, cidade, cpf) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String QUERY_LIST = "SELECT * from clientes";
	private final String QUERY_READ = "SELECT * from clientes WHERE id = ?";
	private final String QUERY_UPDATE = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, endereco = ?, bairro = ?, "
			+ "cep = ?, cidade = ?, cpf = ?, ativo = ? WHERE id = ?";
	private final String QUERY_DELETE = "DELETE from clientes WHERE id = ?";
	
	public void create(Cliente cliente) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getBairro());
			ps.setString(6, cliente.getCep());
			ps.setString(7, cliente.getCidade());
			ps.setString(8, cliente.getCpf());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar cliente");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Cliente> list() {
		List<Cliente> lista = new ArrayList<Cliente>();
		
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
				
				Cliente cli = new Cliente();
				
				cli.setAtivo(rs.getBoolean("ativo"));
				cli.setCodigo(rs.getInt("id"));
				
				cli.setNome(rs.getString("nome"));
				cli.setEmail(rs.getString("email"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setEndereco(rs.getString("endereco"));
				cli.setBairro(rs.getString("bairro"));
				cli.setCep(rs.getString("cep"));
				cli.setCidade(rs.getString("cidade"));
				cli.setCpf(rs.getString("cpf"));
				
				lista.add(cli);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar cliente : " + e.getErrorCode() + " " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}
	
	public Cliente read(int id) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(QUERY_READ);
		
			//para executar a query
			//pegar resultado da pesquisa
			rs = ps.executeQuery();
			//enquanto houver retorno de proximo
			while(rs.next()) {
				
				Cliente cli = new Cliente();
				
				cli.setAtivo(rs.getBoolean("ativo"));
				cli.setCodigo(rs.getInt("codigo"));
				
				cli.setNome(rs.getString("nome"));
				cli.setEmail(rs.getString("email"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setEndereco(rs.getString("endereco"));
				cli.setBairro(rs.getString("bairro"));
				cli.setCep(rs.getString("cep"));
				cli.setCidade(rs.getString("cidade"));
				cli.setCpf(rs.getString("cpf"));
				
				return cli;
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar consultar cliente");
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return null;
	}

	public void update(Cliente cliente) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		System.err.println("Codigo cliente: " + cliente.getCodigo());
		
		try {
			ps = con.prepareStatement(QUERY_UPDATE);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getBairro());
			ps.setString(6, cliente.getCep());
			ps.setString(7, cliente.getCidade());
			ps.setString(8, cliente.getCpf());
			ps.setBoolean(9, cliente.isAtivo());
			ps.setInt(10, cliente.getCodigo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar alterar cliente");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}

	public void delete(int id) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_DELETE);
			ps.setInt(1, id);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar remover cliente");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
}
