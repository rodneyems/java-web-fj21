package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcExemplo {

	public static void main(String[] args) throws SQLException {
		Connection	connection	=	new	ConnectionFactory().getConnection();
		System.out.println("Conex�o	aberta!");
//		String sql = "insert into contatos (nome, email, edereco, dataNascimento) values (A,B,C,D)";
		connection.close();
	}
}
