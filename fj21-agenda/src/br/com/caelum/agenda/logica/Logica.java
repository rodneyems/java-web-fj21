package br.com.caelum.agenda.logica;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws SQLException;

}
