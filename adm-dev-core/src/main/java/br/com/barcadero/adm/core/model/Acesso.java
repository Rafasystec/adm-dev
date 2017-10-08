package br.com.barcadero.adm.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQueries(
	value={ @NamedQuery(name=Acesso.FIND_ACESSO,query="FROM Acesso WHERE nmAcesso=:nmAcesso"),
			@NamedQuery(name=Acesso.FIND_ALL,query="FROM Acesso ")
			
})

@Entity
@Table(name="ACESSO")
public class Acesso extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1605062018857041116L;
	public static final String FIND_ACESSO 		= "Acesso.findAcesso";
	public static final String FIND_ALL 		= "Acesso.findAll";
	public static final String PARAM_NM_ACESSO 	= "nmAcesso";
	
	public Acesso() {
		// TODO Auto-generated constructor stub
	}
	
	public Acesso(final String nmAcesso) {
		// TODO Auto-generated constructor stub
		this.setNmAcesso(nmAcesso);
	}
	
	
	@Column(name = "NM_ACESSO",nullable=false)
	private String nmAcesso;

	public String getNmAcesso() {
		return nmAcesso;
	}

	public void setNmAcesso(String nmAcesso) {
		this.nmAcesso = nmAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nmAcesso == null) ? 0 : nmAcesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		if (nmAcesso == null) {
			if (other.nmAcesso != null)
				return false;
		} else if (!nmAcesso.equals(other.nmAcesso))
			return false;
		return true;
	}

}
