package com.gstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gstore.model.Cargo;

public class CargoDAO {
	private final String QUERY_CREATE = "INSERT INTO cargos(nome, descricao) "
			+ "values (?, ?)";
	private final String QUERY_LIST = "SELECT * from cargos";
	private final String QUERY_UPDATE = "UPDATE cargos SET nome = ?, descricao = ?, ativo = ? WHERE id = ?";
	private final String QUERY_DELETE = "DELETE from cargos WHERE id = ?";
	
	public void create(Cargo cargo) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(QUERY_CREATE);
			
			ps.setString(1, cargo.getNome());
			ps.setString(2, cargo.getDescricao());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar cadastrar cargo");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public List<Cargo> list() {
		List<Cargo> lista = new ArrayList<Cargo>();
		
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
				
				Cargo cargo = new Cargo();
				
				cargo.setAtivo(rs.getBoolean("ativo"));
				cargo.setCodigo(rs.getInt("id"));
				
				cargo.setNome(rs.getString("nome"));
				cargo.setDescricao(rs.getString("descricao"));
				
				lista.add(cargo);
			}
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar listar cargo : " + e.getErrorCode() + " " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		
		return lista;
	}

	public void update(Cargo cargo) {
		Connection con = ConnectionFactory.getConection();
		PreparedStatement ps = null;
		
		System.err.println("Codigo cargo: " + cargo.getCodigo());
		
		try {
			ps = con.prepareStatement(QUERY_UPDATE);
			
			ps.setString(1, cargo.getNome());
			ps.setString(2, cargo.getDescricao());
			ps.setBoolean(3, cargo.isAtivo());
			ps.setInt(4, cargo.getCodigo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Falha ao tentar alterar cargo");
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
			System.err.println("Falha ao tentar remover cargo");
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
}
