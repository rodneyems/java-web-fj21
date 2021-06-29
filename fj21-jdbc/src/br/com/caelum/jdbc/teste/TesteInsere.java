package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao dao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R.	Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		dao.adiciona(contato);
		System.out.println("Gravado!");
		
		Contato contato2 = new Contato();
		contato2.setNome("Rodney 2");
		contato2.setEmail("contato2@caelum.com.br");
		contato2.setEndereco("R.	Vergueiro 3185 cj57 DOIS");
		contato2.setDataNascimento(Calendar.getInstance());
		dao.adiciona(contato2);
		System.out.println("Gravado!");
	}

}
