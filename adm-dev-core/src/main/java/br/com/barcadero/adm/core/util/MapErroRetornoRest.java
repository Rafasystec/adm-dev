package br.com.barcadero.adm.core.util;

import br.com.barcadero.adm.core.enums.EnumErrosSistema;



public class MapErroRetornoRest {
	
	/*TYPE:
	 * 1:Erro de validação na regra de negocio
	 * 2:Erro Inesperado na aplicacao
	 */
	
		private EnumErrosSistema type;
		private String message;
		private String rootCause;
		private String rootMessage;
		private String[] fields;
		
		
		
		 
		public String[] getFields() {
			return fields;
		}
		public void setField(String[] fields) {
			this.fields = fields;
		}
		public EnumErrosSistema getType() {
			return type;
		}
		public void setType(EnumErrosSistema type) {
			this.type = type;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getRootCause() {
			return rootCause;
		}
		public void setRootCause(String rootCause) {
			this.rootCause = rootCause;
		}
		public String getRootMessage() {
			return rootMessage;
		}
		public void setRootMessage(String rootMessage) {
			this.rootMessage = rootMessage;
		}
		
		public MapErroRetornoRest(){
			
		}
		public MapErroRetornoRest(EnumErrosSistema type, String message, String rootCause, String rootMessage) {
			this.type = type;
			this.message = message;
			this.rootCause = rootCause;
			this.rootMessage = rootMessage;
		}
		public MapErroRetornoRest(EnumErrosSistema type, String message) {
			super();
			this.type = type;
			this.message = message;
		}
		
		public MapErroRetornoRest(EnumErrosSistema type, String message,String [] fields) {
			super();
			this.type = type;
			this.message = message;
			this.fields=fields;
		}
		
	
}
