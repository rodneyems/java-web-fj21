package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExemplo {

	public static void main(String[] args) throws SQLException {

		Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
		System.out.println("CONECTADO!");
		conexao.close();
	}

}
