package br.com.barcadero.adm.core.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.adm.core.dao.SecurityLoginDAO;
import br.com.barcadero.adm.core.model.SecurityLogin;



@Service
@Transactional
public class SecurityLoginRole extends SuperClassRole<SecurityLogin> {

	
	@Autowired
	private SecurityLoginDAO dao;
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public SecurityLogin insert(SecurityLogin entidade) {
		// TODO Auto-generated method stub
		
//		String cryptKey = KeyNewUserValidateUtil.genarateKeyValue(entidade);
//		entidade.setKey(cryptKey);
//		entidade.setValidate(false);
//		return dao.insert(entidade);
		return null;
	}

	@Override
	public void delete(long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityLogin update(SecurityLogin entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityLogin find(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
