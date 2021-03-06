package br.com.caelum.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		System.out.println(request.getAttribute("conexao"));
		Connection	connection	=	(Connection)	request.getAttribute("conexao");
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao(connection);
		dao.exclui(contato);
		
		System.out.println("Excluindo contato... ");
		
		return "mvc?logica=ListaContatosLogic";
	}

}