package br.com.barcadero.adm.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.barcadero.adm.core.enums.EnumDesenvolvedor;
import br.com.barcadero.adm.core.enums.EnumPrioridade;
import br.com.barcadero.adm.core.enums.EnumTipo;
import br.com.barcadero.adm.core.model.Tarefa;
import br.com.barcadero.adm.web.util.CallTarefaRest;

@ManagedBean
@ViewScoped
public class ConsultaTarefaBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5370813769131007394L;
	private List<Tarefa> tarefas;
	private List<Tarefa> tarefasFiltradas;
	private CallTarefaRest restTarefa;
		
	
	@PostConstruct
	public void init() {
		restTarefa= new CallTarefaRest();
		getTarefasBanco();
	}
	
	
		
	
	public List<Tarefa> getTarefasBanco() {
		try {
			
			tarefas= restTarefa.getListTarefas();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro inesperado:", "Favor entrar em contato com o admistrador do sistema!"));
			e.printStackTrace();
		}
		
		
		return tarefas;
	}




	public List<Tarefa> getTarefas() {
		return tarefas;
	}




	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}




	public CallTarefaRest getRestTarefa() {
		return restTarefa;
	}




	public List<Tarefa> getTarefasFiltradas() {
		return tarefasFiltradas;
	}




	public void setTarefasFiltradas(List<Tarefa> tarefasFiltradas) {
		this.tarefasFiltradas = tarefasFiltradas;
	}




	public void setRestTarefa(CallTarefaRest restTarefa) {
		this.restTarefa = restTarefa;
	}
	
	public EnumTipo[] getTipos(){
		return EnumTipo.values();
	}
	public EnumPrioridade[] getPrioridades(){
		return EnumPrioridade.values();
	}
	
	public EnumDesenvolvedor[] getCriadores(){
		return EnumDesenvolvedor.values();
	}
	
	public List<String> getCriadores2(){
		EnumDesenvolvedor[] enums= EnumDesenvolvedor.values();
		List<String> retorno = new ArrayList<String>();
		for(int i =0;enums.length>i;++i){
			retorno.add(enums[i].toString());
		}
		return retorno;
	}
	
	public List<Long> getIds(){
		List<Long> retorno = new ArrayList<Long>();
		retorno.add(1l);
		retorno.add(3l);
		retorno.add(2l);
		return retorno;
		
	}
		
}
