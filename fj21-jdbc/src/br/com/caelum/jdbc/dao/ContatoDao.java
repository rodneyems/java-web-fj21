package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private static Connection connection;

	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert	into	contatos	" + "(nome,email,endereco,dataNascimento)" + "	values	(?,?,?,?)";
		try {
			// prepared statement para inser??o
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public static List<Contato> getLista() throws SQLException {
		// TODO Auto-generated method stub
		try {
			List<Contato>	contatos	=	new	ArrayList<Contato>();
			PreparedStatement	stmt	=	(PreparedStatement) connection.prepareStatement("select	* from contatos");
			ResultSet	rs	=	stmt.executeQuery();
			while (rs.next()) {
				Contato obj = new Contato();
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setEmail(rs.getString("email"));
				obj.setEndereco(rs.getString("endereco"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataNascimento"));
				obj.setDataNascimento(cal);
				contatos.add(obj);
			}
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
