package br.com.barcadero.adm.web.converters;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.stereotype.Component;

import br.com.barcadero.adm.core.exceptions.ExceptionErroCallRest;
import br.com.barcadero.adm.core.exceptions.ExceptionValidation;
import br.com.barcadero.adm.core.model.Usuario;
import br.com.barcadero.adm.web.util.RestUtilCall;

@Component("usuarioConverter")
public class UsuarioConverter implements Converter,Serializable {

	private static final long serialVersionUID = 7334507095421114093L;
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		
		Usuario usuario;
		try {
			usuario =   RestUtilCall.getEntity("usuario/"+value,Usuario.class);;
		} catch (NumberFormatException | ExceptionValidation |ExceptionErroCallRest e) {
			 throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid user."));
		}
		return usuario;
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
            return String.valueOf(((Usuario) value).getId());
        }
        else {
            return null;
        }

	}
	
}
