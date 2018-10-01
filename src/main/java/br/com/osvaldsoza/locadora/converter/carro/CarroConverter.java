package br.com.osvaldsoza.locadora.converter.carro;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.osvaldsoza.locadora.dao.carro.CarroDAO;
import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Carro.class)
public class CarroConverter implements Converter{
	private CarroDAO carroDAO;
	
	public CarroConverter() {
		this.carroDAO = CDIServiceLocator.getBean(CarroDAO.class);
	}
	

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro retorno = null;

		if (value != null) {
			retorno = this.carroDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Carro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
