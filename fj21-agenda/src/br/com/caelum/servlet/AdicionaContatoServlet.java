package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		PrintWriter out = resp.getWriter();
    		
    		String nome = req.getParameter("nome");
    		String email = req.getParameter("email");
    		String endereco = req.getParameter("endereco");
    		String dataTxt = req.getParameter("data");
    		System.out.println(dataTxt);
    		
    		Contato contato = new Contato();
    		contato.setNome(nome);
    		contato.setEmail(email);
    		contato.setEndereco(endereco);
    		
    		Calendar dataNascimento = Calendar.getInstance();
    		
			try {
				System.out.println("ENTRANDO kakakkakkakak");
				Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataTxt);
				
				System.out.println(data);
				
				dataNascimento.setTime(data);
				contato.setDataNascimento(dataNascimento);
				System.out.println(contato.getDataNascimento());
				
			} catch (ParseException e) {
				out.println("<h1> ERRO NA CONVERS?O </h1>");
				return;
			}
    		
    		ContatoDao dao = new ContatoDao();
    		dao.adiciona(contato);
    		RequestDispatcher dispatcher = req.getRequestDispatcher("/contato-adicionado.jsp");
    		
    		dispatcher.forward(req, resp);
    	}

}
