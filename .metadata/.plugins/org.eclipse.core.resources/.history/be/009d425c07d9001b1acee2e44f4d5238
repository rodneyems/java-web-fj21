package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.caelum.jdbc.modelo.Contato;

public class JdbcExemplo {

	public static void main(String[] args) throws SQLException {
		Contato rodney = new Contato();
		rodney.setNome("Rodney");
		rodney.setEmail("rodney.martins@live.com");
		rodney.setEndereco("Rua Cortegaça");
		rodney.setDataNascimento(Calendar.getInstance());
		
		Connection	conexao	=	new	ConnectionFactory().getConnection();
		System.out.println("Conexão	aberta!");
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, rodney.getNome());
		stmt.setString(2, rodney.getEmail());
		stmt.setString(3, rodney.getEndereco());
		stmt.setDate(4,	new java.sql.Date(rodney.getDataNascimento().getTimeInMillis()));
		stmt.execute();
		stmt.close();
//		connection.close();
	}
}
