package br.com.barcadero.adm.core.exceptions;

public class ExceptionValidation extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6524741300778460580L;
	
	private String campoErro="";// preencher sempre em camelCase exatamente igual o da entidade
	public ExceptionValidation(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	public ExceptionValidation(String message,String campoErro) {
		// TODO Auto-generated constructor stub
		super(message);
		this.campoErro=campoErro;
	}
	public String getCampoErro() {
		return campoErro;
	}
	
}
 