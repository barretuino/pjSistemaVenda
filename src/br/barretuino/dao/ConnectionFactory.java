package br.barretuino.dao;
/**
 * ConnectionFactory - Fábrica de Conexões com o Banco
 * @autor Paulo C. Barreto
 * @date 19/01/2019
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/pjCurso","root","admin");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}