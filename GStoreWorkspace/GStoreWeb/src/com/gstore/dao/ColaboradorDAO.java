package com.gstore.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Colaborador;

public class ColaboradorDAO {
	
	private final String QUERY_CREATE = "INSERT INTO colaboradores(nome, email, cargo, descricao) "
			+ "values (?, ?, ?, ?)";
	private final String QUERY_LIST = "SELECT * from colaboradores";
	private final String QUERY_UPDATE = "UPDATE colaboradores SET nome = ?, email = ?, cargo = ?, descricao = ?, ativo=? WHERE id = ?";
	private final String QUERY_DELETE = "DELETE from colaboradores WHERE id = ?";
	
	public void create(Colaborador colab) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, colab.getNome());
			ps.setString(2, colab.getEmail());
			ps.setString(3, colab.getCargo());
			ps.setString(4, colab.getDescricao());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar colaborador");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Colaborador> list() {
		List<Colaborador> lista = new ArrayList<Colaborador>();
		
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
				
				Colaborador colab = new Colaborador();
				
				colab.setAtivo(rs.getBoolean("ativo"));
				colab.setCodigo(rs.getInt("id"));
				
				colab.setNome(rs.getString("nome"));
				colab.setEmail(rs.getString("email"));
				colab.setCargo(rs.getString("cargo"));
				colab.setDescricao(rs.getString("descricao"));
				colab.setAtivo(rs.getBoolean("ativo"));
				
				lista.add(colab);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar colaboradores : " + e.getErrorCode() + " " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}

	public void update(Colaborador colab) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		System.err.println("Codigo colaborador: " + colab.getCodigo());
		
		try {
			ps = con.prepareStatement(QUERY_UPDATE);
			
			ps.setString(1, colab.getNome());
			ps.setString(2, colab.getEmail());
			ps.setString(3, colab.getCargo());
			ps.setString(4, colab.getDescricao());
			ps.setBoolean(5, colab.isAtivo());
			ps.setInt(6, colab.getCodigo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar alterar colaborador");
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
			System.err.println("Falha ao tentar remover colaborador");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
}
