package br.com.barcadero.adm.core.enums;

/**
 * Obtem os tipos possiveis de permissoes para o sistema.
 * @author Rafael Rocha
 *
 */
public enum EnumRoles {
	
	/*
	 * Por favor nao mudar a ordem 
	 */
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_CONV("ROLE_CONV"),
	ROLE_PRIVATE("ROLE_PRIVATE"),
	ROLE_PETSHOP("ROLE_PETSHOP"),
	ROLE_ONG("ROLE_ONG");
	
	private final String value;
	private EnumRoles(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
		
	

}
