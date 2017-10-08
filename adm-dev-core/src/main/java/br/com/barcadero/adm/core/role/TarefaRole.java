package br.com.barcadero.adm.core.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.adm.core.dao.TarefaDAO;
import br.com.barcadero.adm.core.enums.EnumStatus;
import br.com.barcadero.adm.core.model.Tarefa;


@Service
public class TarefaRole  extends SuperClassRole<Tarefa> {

			@Autowired
			private TarefaDAO tarefaDAO;
			
			public Tarefa insert(Tarefa entidade) {
			
				entidade.setStatus(EnumStatus.ABERTA);
				return (Tarefa) this.tarefaDAO.insert(entidade);
			}

			@Override
			public void delete(long codigo) {
			
				 this.tarefaDAO.delete(codigo);
			}

			
			public Tarefa update(Tarefa entidade) {
			
				return (Tarefa) this.tarefaDAO.update(entidade);
			}

			
			public Tarefa find(long codigo) {
			
				return this.tarefaDAO.find(codigo);
			}
			
			public Tarefa alterarStatus(Tarefa entidade) {
				Tarefa tarefa = find(entidade.getId());
				
				if(entidade.getObservacao()==null){
					entidade.setObservacao(new ArrayList<String>());
				}
				entidade.getObservacao().add("Status da tarefa alterado de "+tarefa.getStatus().toString()+" para "+entidade.getStatus().toString());
								
				
				return (Tarefa) this.tarefaDAO.update(entidade);
			}
			
			public List<Tarefa> consultaTarefas()  {
			
				return this.tarefaDAO.consultaTarefas();
			}
		
			
}
