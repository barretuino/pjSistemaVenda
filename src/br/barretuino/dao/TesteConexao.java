package br.barretuino.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) {
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			System.out.println("Conexão realizada com sucesso!");
			conn.close();
		} catch (SQLException e) {
			System.err.println("Falha ao estabelecer uma conexão --> " + e);
		}
	}
}