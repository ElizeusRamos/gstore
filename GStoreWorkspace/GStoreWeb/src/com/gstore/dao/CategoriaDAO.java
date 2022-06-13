package com.gstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Cargo;
import com.gstore.model.Categoria;

public class CategoriaDAO {
	private final String QUERY_CREATE = "INSERT INTO categorias(nome, descricao) "
			+ "values (?, ?)";
	private final String QUERY_LIST = "SELECT * from categorias";
	private final String QUERY_UPDATE = "UPDATE categorias SET nome = ?, descricao = ?, ativo = ? "
			+ "WHERE id = ?";
	private final String QUERY_DELETE = "DELETE from categorias WHERE id = ?";
	
	public void create(Categoria cat) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, cat.getNome());
			ps.setString(2, cat.getDescricao());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar categoria");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Categoria> list() {
		List<Categoria> lista = new ArrayList<Categoria>();
		
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
				
				Categoria categoria = new Categoria();
				
				categoria.setAtivo(rs.getBoolean("ativo"));
				categoria.setCodigo(rs.getInt("id"));
				
				categoria.setNome(rs.getString("nome"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setAtivo(rs.getBoolean("ativo"));
				
				lista.add(categoria);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar categoria : " + e.getErrorCode() + " " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}

	public void update(Cargo cargo) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		System.err.println("Codigo cliente: " + cargo.getCodigo());
		
		try {
			ps = con.prepareStatement(QUERY_UPDATE);
			
			ps.setString(1, cargo.getNome());
			ps.setString(2, cargo.getDescricao());
			ps.setBoolean(3, cargo.isAtivo());
			ps.setInt(4, cargo.getCodigo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar alterar categoria");
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
			System.err.println("Falha ao tentar remover categoria");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
}
