package br.com.barcadero.adm.core.role;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;


/*
 * --------------------------------------------------------------------------
 * Spring recommends that you only annotate concrete classes (and methods of concrete classes) 
 * with the @Transactional annotation, as opposed to annotating interfaces. You certainly can 
 * place the @Transactional annotation on an interface (or an interface method), but this works 
 * only as you would expect it to if you are using interface-based proxies.
 * --------------------------------------------------------------------------
 * 
 * @Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.SUPPORTS)
 * propagation : Este atributo definir o nível de propagação de determinada transação, que pode ser:

    PROPAGATION_REQUIRED: Este definir que obrigatoriamente aquele bloco de código deve ser executado dentro de uma transação. Se uma transação já existir então ele usará esta existente, caso contrário ele criará uma nova. Este é o padrão quando não definido nenhum nível de propagação explicitamente.
    PROPAGATION_SUPPORTS: Se uma transação já existir então ela será utilizada caso contrário nenhuma será criada.
    PROPAGATION_MANDATORY: Caso exista uma transação ela será utilizada, caso contrário uma exceção será lançada, TransactionRequiredException, pois este tipo de propagação requer que uma transação já esteja criada previamente.
    PROPAGATION_REQUIRED_NEW: Sempre cria uma nova transação. Se nenhuma transação existir então ela será criada, porém se uma já existir ela será suspensa e uma nova será criada. Quando esta transação é finalizada então a transação original é recuperada.
    PROPAGATION_NOT_SUPPORTED: Uma transação não será necessária no bloco de código anotado com este atributo. Se alguma transação existir então ela será suspensa até o fim do bloco e só depois será retomada.
    PROPAGATION_NEVER: Muito semelhante ao PROPAGATION_NOT_SUPPORTED, não permitindo o uso de transações no bloco de código, com a única diferença que caso uma transação exista uma exceção será lançada.
    PROPAGATION_NESTED: O bloco de código será executado em uma transação aninhada se uma outra transação já existir, caso contrário será criada uma nova transação.
 */

/**
 * Classe para servir de modelo para os facades que presisao persistir dados
 * @author Rafel Rocha
 * @since version 1.0 Beta
 */
@Transactional
public abstract class SuperClassRole<T>{


	public abstract T insert(T entidade)   ;
	public abstract void delete(long codigo)  ;
	public abstract T update(T entidade)  ;
	public abstract T find(long codigo)  ;
	
	public SuperClassRole() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SuperClassRole(EntityManager manager) {
		
	}
	
	
}
