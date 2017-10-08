package br.com.barcadero.adm.core.dao;

import org.springframework.stereotype.Repository;

import br.com.barcadero.adm.core.model.SecurityLogin;



@Repository
public class SecurityLoginDAO extends SuperClassDAO<SecurityLogin> {

	public SecurityLoginDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public SecurityLogin find(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
