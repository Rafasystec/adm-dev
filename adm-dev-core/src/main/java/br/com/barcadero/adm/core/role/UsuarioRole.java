package br.com.barcadero.adm.core.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.adm.core.dao.UsuarioDAO;
import br.com.barcadero.adm.core.exceptions.ExceptionValidation;
import br.com.barcadero.adm.core.model.Usuario;

/**
 * 
 * @author antoniorafael
 *
 */
@Service
@Transactional
public class UsuarioRole extends SuperClassRole<Usuario> {

	@Autowired
	private UsuarioDAO usuarioDAO ;

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW,isolation=Isolation.DEFAULT)
	public Usuario insertPreCadastro(Usuario usuario) throws ExceptionValidation{
		validarUsuario(usuario);
		
		return insertUser(usuario);
	}

	private void validarUsuario(Usuario usuario) throws ExceptionValidation{
//		if(!ValidationUtil.isCampoComValor(usuario.getNome())){
//			throw new ExceptionValidation("O campo de nome não foi informado!");
//		}
//		if(!ValidationUtil.isCampoComValor(usuario.getPassword())){
//			throw new ExceptionValidation("O campo de senha não foi informado!");
//		}
//		if(!ValidationUtil.isCampoComValor(usuario.getEmail())){
//			throw new ExceptionValidation("O campo de e-mail não foi informado!");
//		}
//		if(usuario.getFlTpEstabelecimento().equals(EnumFlTpEstabelecimento.PETSHOP)){
//			if(!ValidationUtil.isCampoComValor(usuario.getCnpjCpf())){
//				throw new ExceptionValidation("O campo de CNPJ não foi informado!");
//			}
//		}
//		if(!ValidationUtil.isCampoComValor(usuario.getNmLogin())){
//			throw new ExceptionValidation("O campo de nome de login não foi informado!");
//		}
//		List<Usuario> usuarios=consultaPorNmLogin(usuario.getNmLogin());
//		if(usuarios !=null && usuarios.size()>0){
//			throw new ExceptionValidation("Nome de usuário já existe favor informar um diferente!");
//		}
//
//		if(usuario.getNmLogin().equalsIgnoreCase(Usuario.ANONYMOUS_USER)){
//			throw new ExceptionValidation("Nome de login " + usuario.getNmLogin() + " é uma palavra reservada, portanto não pode ser usada.");
//		}
	}
	
	public Usuario insert(Usuario entidade){
		return insertUser(entidade);
	}
	
	private Usuario insertUser(Usuario user) {
		return (Usuario) this.usuarioDAO.insert(user);
	}
	
	public void delete(long codigo) {
	
		 this.usuarioDAO.delete(codigo);
	}

	
	public Usuario update(Usuario entidade){

		return (Usuario) this.usuarioDAO.update(entidade);
	}

	public Usuario findFacebook(long codigo) throws ExceptionValidation {
		
		return this.usuarioDAO.findFacebook(codigo);
	}
	
	public Usuario find(long codigo) {
	
		return this.usuarioDAO.find(codigo);
	}

	public Usuario consultaPorNomeLogin(String nmLogin) {
		return this.usuarioDAO.consultaPorNomeLogin(nmLogin);
	}
	
	public List<Usuario> consultaPorNomeOuAnimal(String nome)  {
		return this.usuarioDAO.consultaPorNomeOuAnimal(nome);
	}
	/**
	 * Retorna o Usuario logado
	 * @return
	 */
	public static  Usuario  getUsuarioLogado(){
		
		try{
			return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Usuario>  consultaPorNmLogin(String nmLogin)  throws ExceptionValidation{
		return this.usuarioDAO.consultaPorNmLogin(nmLogin);
	}

	public List<Usuario> listaClientes(long id)  throws  ExceptionValidation{
	
		return this.usuarioDAO.listaClientes(id);
	}
	public List<Usuario> listaClientesAutoComplete(long id,String parteNome)  throws  ExceptionValidation{
		
		return this.usuarioDAO.listaClientesAutoComplete(id,parteNome);
	}
	
//	public void sendEmail(Usuario usuario, SecurityLogin securityLogin) {
//		Thread runEmail = new Thread(new ThreadSendMail(usuario.getEmail(),EmailConstants.senderContato, getEmailContet(usuario,securityLogin), getSubjectNewUser()));
//		runEmail.start();
//	}
	
//	private String getEmailContet(Usuario usuario, SecurityLogin securityLogin) {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Olá ").append(usuario.getNome()).append(", tudo bem?").append("\n\n")
//			.append("Você está recebendo este e-mail porque se cadatrou na plataforma Petshow").append("\n")
//			.append("Para você realmente efetivar seu cadastro, clique no link abaixo:").append("\n")
//			.append(genarateSecuryteLink(securityLogin)).append("\n");
//		builder.append("Muito obrigado e aproveite o sistema.");
//		return builder.toString();
//	}
//	
//	private String getSubjectNewUser () {
//		return "NOVO USUÁRIO - Solicitação PETSHOW";
//	}
	/**
	 * 
	 * @param securityLogin
	 * @return
	 */
//	private String genarateSecuryteLink(SecurityLogin securityLogin) {
//		String emailCrypt = HandleEncrypt.encrypt(securityLogin.getEmail());
//		String erro = "";
//		try {
//			return "http://petmooby.com.br/pet/PageValidateNewUser.xhtml?seckey="+URLEncoder.encode(securityLogin.getKey(), "UTF-8") +"&lg="+URLEncoder.encode(emailCrypt,"UTF-8") ;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			erro = e.getMessage();
//		}
//		return "Não foi possível gerar o link pois : ".concat(erro); 
//	}
	
//	public SecurityLogin genarateSecurityLogin(Usuario usuario) {
//		SecurityLogin securityLogin = new SecurityLogin();
//		securityLogin.setEmail(usuario.getEmail());
//		securityLogin.setUserId(usuario.getId());
//		securityLogin.setValidate(false);
//		return securityLogin;
//	}
	
	public List<Usuario> getAllDev() {
		return usuarioDAO.getAllDev();
	}
	
}
