package br.com.barcadero.adm.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:12
 */
@NamedQueries({ @NamedQuery(name = Usuario.FIND_POR_NOME_LOGIN, query = "FROM Usuario usu WHERE usu.nmLogin = :nmLogin"), 
	@NamedQuery(name = Usuario.FIND_POR_NM_ANIMAL	, query = "FROM Usuario usu WHERE usu.nome like '%:nome%' "), 
	@NamedQuery(name = Usuario.IDX_POR_FACEBOOK		, query = "FROM Usuario usu WHERE usu.idFacebook = :idFacebook "),
	@NamedQuery(name = Usuario.FIND_ALL_DEV			, query = "FROM Usuario ")

})

@Entity
@Table(name="USUARIO",indexes = { @Index(name = Usuario.IDX_POR_FACEBOOK, columnList = "ID_FACEBOOK") })
public class Usuario extends Entidade  implements UserDetails// comentar implementacao
{

	private static final long serialVersionUID = 8937600656781400155L;
	public static final String ANONYMOUS_USER = "anonymousUser";

	public Usuario() {
	}
	public static final String FIND_POR_NOME_LOGIN 	= "Usuario.porNomeLogin";
	public static final String FIND_POR_NM_ANIMAL 	= "Usuario.porNMouAnimal";
	public static final String IDX_POR_FACEBOOK 	= "UsuarioFacebook";
	public static final String FIND_ALL_DEV 		= "br.com.barcadero.adm.core.model.Usuario.findAllDev";

	@Column(name = "ID_FACEBOOK" )
	private Long idFacebook;

	@Column(name="FL_PRE_CADASTRO")
	private boolean flPreCadastro;

	@Column(name="FOTO_PERFIL" , length=10485760)
	private String foto = "";

	@Column(name="CIDADE")
	private String cidade;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="NR_ENDERECO")
	private int nrEndereco;

	@Column(name="NR_CEP")
	private int nrCep;

	@Column(name="CNPJ_CPF")
	private String cnpjCpf;

	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name="TF_USUARIO")
	private int telefone;

	@Column(name="DDD_USUARIO")
	private int ddd;


	@Column(name="TF_USUARIO2")
	private int telefone2;

	@Column(name="DDD_USUARIO2")
	private int ddd2;



	@Column(name="EMAIL",nullable=false)
	private String email;

	@Column(name="SENHA",nullable=false)
	private String password;

	@Column(name="NM_USUARIO")
	private String nome;




	@Column(name="NM_LOGIN",nullable=false)
	private String nmLogin;

	//	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Acesso> acessos;


	@Column(name="URL_FACEBOOK")
	private String URLFacebook;
	@Column(name="FL_VALIDATED",nullable=false)
	private boolean validated = false;


	@Column(nullable=false,name="DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCadastro = new Date();

	@Embedded
	private Endereco endereco = new Endereco();

	public String getURLFacebook() {
		return URLFacebook;
	}

	public void setURLFacebook(String uRLFacebook) {
		URLFacebook = uRLFacebook;
	}


	public boolean isFlPreCadastro() {
		return flPreCadastro;
	}

	public void setFlPreCadastro(boolean flPreCadastro) {
		this.flPreCadastro = flPreCadastro;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public int getDdd2() {
		return ddd2;
	}

	public void setDdd2(int ddd2) {
		this.ddd2 = ddd2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getPassword() {
		return password;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNrEndereco() {
		return nrEndereco;
	}
	public void setNrEndereco(int nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public int getNrCep() {
		return nrCep;
	}
	public void setNrCep(int nrCep) {
		this.nrCep = nrCep;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}
	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//comentar daqui
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();
		if(acessos != null){
			for (Acesso acesso : acessos) {
				result.add(new SimpleGrantedAuthority(acesso.getNmAcesso()));
			}
		}
		return result;
	} 

	@JsonIgnore
	public String getUsername() {
		return getNmLogin();
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	// ate aqui
	//	@JsonIgnore
	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}
	public Long getIdFacebook() {
		return this.idFacebook;
	}

	public void setIdFacebook(Long idFacebook) {
		this.idFacebook = idFacebook;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



}
