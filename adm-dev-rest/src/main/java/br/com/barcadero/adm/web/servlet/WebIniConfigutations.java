package br.com.barcadero.adm.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.barcadero.adm.core.role.AcessoRole;


@WebServlet(value="/webIniConfigutations", loadOnStartup=2)
public class WebIniConfigutations extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6522392989960698269L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Iniciando o Servlet para verificar as configurações iniciais básicas do Servidor");
		super.init(config);
		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		insertAuthorities(context);
		
	}

	private void insertAuthorities(ApplicationContext context) {
		AcessoRole acesso = context.getBean(AcessoRole.class);
		acesso.load();
		System.out.println("Acessos carregados...........OK");
	}
	
	
}
