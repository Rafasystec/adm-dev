package br.com.barcadero.adm.web.beans;

import javax.faces.bean.ManagedProperty;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.com.barcadero.adm.core.exceptions.ExceptionErroCallRest;
import br.com.barcadero.adm.core.exceptions.ExceptionValidation;
import br.com.barcadero.adm.core.model.Entidade;
import br.com.barcadero.adm.core.model.Usuario;
import br.com.barcadero.adm.core.util.FileApplicationUtil;
import br.com.barcadero.adm.web.security.AuthenticationService;
import br.com.barcadero.adm.web.util.MessagesBeanUtil;
import br.com.barcadero.adm.web.util.RestUtilCall;


public class SuperBean <T>{
	
	protected static ResteasyClient client;
	protected static ResteasyWebTarget target;
	public static final String URL_BASE = FileApplicationUtil.getUrlBaseREST();
	
	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;
	
	static{
		client = new ResteasyClientBuilder().build();
		
	}
	
	protected Response post(String url, Entidade entidade) {
		target = client.target(URL_BASE+url);
		Response response = target.request().post(Entity.entity(entidade, MediaType.APPLICATION_JSON));
		return response;
	}
	
	protected static <T> T postEntity(Entidade entidade, String url,Class<T> type) throws ExceptionErroCallRest,ExceptionValidation {
		return RestUtilCall.postEntity(entidade, url, type);
	}

	public Usuario getUsuarioLogado(){
		return AuthenticationService.getUsuarioLogado();
	}

	public static ResteasyClient getClient() {
		return client;
	}

	public static void setClient(ResteasyClient client) {
		SuperBean.client = client;
	}

	public static ResteasyWebTarget getTarget() {
		return target;
	}

	public static void setTarget(ResteasyWebTarget target) {
		SuperBean.target = target;
	}
	
	protected void exibirInforMessage(String message) {
		MessagesBeanUtil.infor(message);
	}
	
	protected void exibirErroMessage(String erroMessage) {
		MessagesBeanUtil.erroMessage(erroMessage);
	}
	
	protected void exibirAlertaMessage(String message) {
		MessagesBeanUtil.alert(message);
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

}
