package br.com.barcadero.adm.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.adm.core.model.Tarefa;


@Repository
public class TarefaDAO extends SuperClassDAO<Tarefa> {

	public TarefaDAO() {
	
	}

	

	public Tarefa find(long codigo){
		// TODO Auto-generated method stub
		return manager.find(Tarefa.class, codigo);
	}
	
	
	public List<Tarefa> consultaTarefas()  {

		return manager.createNamedQuery(Tarefa.TODAS).getResultList();
	}
}
