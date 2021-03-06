package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mysql.jdbc.Connection;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest	request, ServletResponse	response,	FilterChain	chain)

			throws IOException, ServletException {
		try	{
			Connection	connection	=	(Connection) new	ConnectionFactory().getConnection();
			//	pendurando	a	connection	na	requisição
			request.setAttribute("conexao",	connection);
			chain.doFilter(request,	response);
			System.out.println("FECHANDO CONEAO");
			connection.close();
		}	catch	(SQLException	e)	{
			throw new	ServletException(e);
		}
	}
}