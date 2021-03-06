package br.com.caelum.agenda.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTxt = request.getParameter("data");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		
		Calendar dataNascimento = Calendar.getInstance();
		
		Connection	connection	=	(Connection)	request.getAttribute("conexao");

//		String > Date > Calendar
		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt);
			
			System.out.println(data);
			
			dataNascimento.setTime(data);
			contato.setDataNascimento(dataNascimento);
			System.out.println(contato.getDataNascimento());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
	
		return "/contato-adicionado.jsp";
	}

}
