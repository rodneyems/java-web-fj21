package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteLista {

	public static void main(String[] args) throws SQLException {
		new ContatoDao();
		// TODO Auto-generated method stub
		List<Contato> contatos = ContatoDao.getLista();

		for (Contato contato : contatos) {
			System.out.println(contato);
		}
	}

}
