package br.com.barcadero.adm.core.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.adm.core.dao.AcessoDAO;
import br.com.barcadero.adm.core.enums.EnumRoles;
import br.com.barcadero.adm.core.model.Acesso;


@Service
@Transactional
public class AcessoRole extends SuperClassRole<Acesso> {

	@Autowired
	private AcessoDAO acessoDAO;
	
	@Override
	public Acesso insert(Acesso entidade) {
		
		return acessoDAO.insert(entidade);
	}

	@Override
	public void delete(long codigo)  {
		acessoDAO.delete(codigo);
	}

	@Override
	public Acesso update(Acesso entidade){
		return acessoDAO.update(entidade);
	}

	@Override
	public Acesso find(long codigo) {
		return null;
	}
	
	public List<Acesso> findAll() {
		return acessoDAO.findAll();
	}
	
	public Acesso findAcesso(EnumRoles roles) {
		return acessoDAO.findAcesso(roles);
	}

	public AcessoDAO getAcessoDAO() {
		return acessoDAO;
	}

	public void setAcessoDAO(AcessoDAO acessoDAO) {
		this.acessoDAO = acessoDAO;
	}
	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.REQUIRED)
	public void load() {
		System.out.println("Carregando as Roles para o Spring Security");
		List<Acesso> list = acessoDAO.findAll();
		if(list != null && list.size() == 0){
			for (EnumRoles role : EnumRoles.values()) {
				acessoDAO.insert(new Acesso(role.getValue()));
			}
		}
	}

}
