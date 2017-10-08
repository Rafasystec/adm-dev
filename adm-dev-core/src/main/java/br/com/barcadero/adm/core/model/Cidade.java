package br.com.barcadero.adm.core.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.adm.core.enums.EnumUF;



@NamedQueries({ @NamedQuery(name = Cidade.CIDADE_POR_ESTADO_POR_ID	, query = "FROM Cidade" ),
			 	@NamedQuery(name = Cidade.FIND_ALL_BY_UF			, query = "FROM Cidade WHERE uf = :uf" )
})
@Entity
@Table(name = "CIDADE")
public class Cidade  extends Entidade {

	private static final long serialVersionUID = -2906194527919052578L;
	public static final String CIDADE_POR_ESTADO_POR_ID = "cidadePorEstadoID";
	public static final String CIDADE_POR_ESTADO_POR_UF = "cidadePorEstadoUF";
	public static final String FIND_ALL_BY_UF		    = "br.com.petshow.model.Cidade.findAllByUF";
	
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="COD_IBGE")
	private long codIbge = 0;
	
	@Column(name="COD_CIDADE")
	private long codCidade = 0;
	
	@Column(name="UF",length=3)
	@Enumerated(EnumType.STRING)
	private EnumUF uf = EnumUF.CE;
	
	
	@Column(name="NOME")
	private String nome = "";

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(long codIbge) {
		this.codIbge = codIbge;
	}

	public long getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(long codCidade) {
		this.codCidade = codCidade;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	
}
