package br.com.barcadero.adm.web.util;

import java.util.List;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import br.com.barcadero.adm.core.enums.EnumErrosSistema;
import br.com.barcadero.adm.core.exceptions.ExceptionErroCallRest;
import br.com.barcadero.adm.core.exceptions.ExceptionValidation;
import br.com.barcadero.adm.core.model.Tarefa;
import br.com.barcadero.adm.core.util.MapErroRetornoRest;





public class CallTarefaRest  extends RestUtilCall<Tarefa> {

	public  List<Tarefa> getListTarefas() throws ExceptionErroCallRest, ExceptionValidation {

		client = new ResteasyClientBuilder().build();
		
		target= client.target(URL_BASE+"tarefa/todas");
		
		
		Object entidades = null;
		try{
			entidades =  target.request().get(new javax.ws.rs.core.GenericType<List<Tarefa>>() {});
			
		}catch(Exception ex){
 
			throw new ExceptionErroCallRest("Failed: HTTP error code:"+ex.getMessage());
			
		}
		if(entidades instanceof MapErroRetornoRest){// caso seja um objeto do tipo MapErroRetornoRest ocorreu um erro/validacao previsto no REST
			MapErroRetornoRest erro=(MapErroRetornoRest) entidades;
			if(erro.getType()==EnumErrosSistema.ERRO_VALIDACAO){
				throw new ExceptionValidation(erro.getMessage());
			}else{
				throw new ExceptionErroCallRest("Failed: HTTP error code:"+erro.getMessage());
			}
		}
		
		
		
		return (List<Tarefa>)entidades;
	
	}
	
	
}
