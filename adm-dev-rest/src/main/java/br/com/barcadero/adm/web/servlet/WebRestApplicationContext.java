package br.com.barcadero.adm.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.barcadero.adm.rest.SuperRestClass;


/**
 * Servlet implementation class WebRestApplicationContext
 */
@WebServlet(value="/webRestApplicationContext", loadOnStartup=3)
public class WebRestApplicationContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Iniciando o Servlet para carregar o SpringContext");
		super.init(config);
		SuperRestClass.setContext(WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()));
		
	}
	
	
}
