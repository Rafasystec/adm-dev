package br.com.barcadero.adm.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.barcadero.adm.core.enums.EnumUF;


@Embeddable
public class Endereco {
	
	@Column(name="UF")
	@Enumerated(EnumType.STRING)
	private EnumUF uf = null;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CIDADE_CODIGO",referencedColumnName="COD_CIDADE")
	private Cidade cidade ;
	@Column(name="BAIRRO")	
	private String bairro = "";
	@Column(name="NUMERO")
	private String numero = "";
	@Column(name="COMPLEMENTO")
	private String complemento = "";
	@Column(name="PAIS")
	private String pais;
	@Column(name="RUA")
	private String rua;
	
	public EnumUF getUf() {
		return uf;
	}
	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

}
