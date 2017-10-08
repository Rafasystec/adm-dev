package br.com.barcadero.adm.core.util;

import javax.ws.rs.core.Response;

import br.com.barcadero.adm.core.enums.EnumErrosSistema;
import br.com.barcadero.adm.core.exceptions.ExceptionValidation;


public class RestUtil {

	public static Response getResponseValidationErro(ExceptionValidation ex){
		//ex.printStackTrace();
		return getResponseValidationErro(ex.getMessage(),ex.getCampoErro());
	}
	
	public static Response getResponseValidationErro(String mensagem,String campo){
		MapErroRetornoRest mapErroRetornoRest=new MapErroRetornoRest(EnumErrosSistema.ERRO_VALIDACAO, mensagem);
		String [] field= {campo};
		mapErroRetornoRest.setField(field);
		return Response.status(Response.Status.BAD_REQUEST).entity(mapErroRetornoRest).build();// VER O TAMANHO DO PROBLEMA EM TROCAR BAD_REQUEST POR OK
	} 
	
	public static Response getResponseValidationErro(String mensagem){
		MapErroRetornoRest mapErroRetornoRest=new MapErroRetornoRest(EnumErrosSistema.ERRO_VALIDACAO, mensagem);
	
		return Response.status(Response.Status.BAD_REQUEST).entity(mapErroRetornoRest).build();
	} 
	
	
	public static Response getResponseErroInesperado(Throwable ex){
		ex.printStackTrace();
		return getResponseErroInesperado(ex.getMessage()); 
	}
	
	public static Response getResponseErroInesperado(String mensagem){
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new MapErroRetornoRest(EnumErrosSistema.ERRO_INESPERADO,mensagem)).build();
	}

	  
}
