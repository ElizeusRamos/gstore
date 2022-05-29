package com.gstore.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Produto;

public class ProdutoDAO {
	
	private final String QUERY_CREATE = "INSERT INTO produtos(nome, descricao, preco, qtde) values (?, ?, ?, ?)";
	private final String QUERY_LIST = "SELECT * from produtos";
	private final String QUERY_READ = "SELECT * from produtos WHERE id = ?";
	private final String QUERY_UPDATE = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, qtde = ? WHERE id = ?";
	private final String QUERY_DELETE = "DELETE from produtos WHERE id = ?";
	
	public void create(Produto produto) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getPreco());
			ps.setInt(4, produto.getQtde());
			
			//para executar a query de inserção ou alteração
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar produto");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Produto> list() {
		List<Produto> lista = new ArrayList<Produto>();
		
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
				
				Produto pd = new Produto();
				
				pd.setCodigo(rs.getInt("id"));
				pd.setNome(rs.getString("nome"));
				pd.setDescricao(rs.getString("descricao"));
				pd.setPreco(rs.getDouble("preco"));
				pd.setQtde(rs.getInt("qtde"));
				
				lista.add(pd);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar produtos");
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}
	
	public Produto read(int id) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(QUERY_READ);
		
			//para executar a query
			//pegar resultado da pesquisa
			rs = ps.executeQuery();
			//enquanto houver retorno de proximo
			if(rs.next()) {
				
				Produto pd = new Produto();
				
				pd.setCodigo(rs.getInt("id"));
				pd.setNome(rs.getString("nome"));
				pd.setDescricao(rs.getString("descricao"));
				pd.setPreco(rs.getDouble("preco"));
				pd.setQtde(rs.getInt("qtde"));
				
				return pd;
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar consultar produto");
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return null;
	}

	public void update(Produto produto) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		System.err.println("Codigo produto: " + produto.getCodigo());
		
		try {
			ps = con.prepareStatement(QUERY_UPDATE);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getPreco());
			ps.setInt(4, produto.getQtde());
			ps.setInt(5, produto.getCodigo());
			
			//para executar a query de inserção ou alteração ou delete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar alterar produto");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public void delete(int id) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(QUERY_DELETE);
			ps.setInt(1, id);
			//para executar a query de inserção ou alteração ou delete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar remover produto");
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
	}
}
