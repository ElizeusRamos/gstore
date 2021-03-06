package com.gstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/bancodedados";
	
	public static Connection getConection() {
		try {
			//procura o driver de conexão ao banco de dados
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Falha ao tentar estabelecer conexão ao banco de dados");
		}
		return null;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Conexão não pode ser fechada");
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps) {
		closeConnection(con);
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				System.err.println("Conexão não pode ser fechada");
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		closeConnection(con, ps);
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Conexão não pode ser fechada");
			}
		}
	}
}
