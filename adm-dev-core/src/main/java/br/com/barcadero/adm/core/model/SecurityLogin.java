package br.com.barcadero.adm.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SECURITY_LOGIN")
public class SecurityLogin extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1327068927241845075L;
	@Column(name="KEY", length=500, nullable=false)
	private String key;
	@Column(name="EMAIL", length=60, nullable=false)
	private String email;
	@Column(name="USER_ID", nullable=false)
	private long userId;
	@Column(name="VALIDATE", length=500, nullable=false)
	private boolean validate;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	
	
	

}
