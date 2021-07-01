package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesteRodney
 */
@WebServlet(urlPatterns = "/TesteRodney")
public class TesteRodney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter	out	=	resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>RODNEY</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>RODNEY!</h1>");
		out.println("</body>");
		out.println("</html>");

	}

}
