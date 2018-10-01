package br.com.osvaldsoza.locadora.service.aluguel;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.osvaldsoza.locadora.dao.aluguel.AluguelDAO;
import br.com.osvaldsoza.locadora.modelo.aluguel.Aluguel;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;

public class AluguelService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AluguelDAO aluguelDAO;
	
	public void salvar(Aluguel aluguel) throws NegocioException{
		aluguelDAO.salvar(aluguel);
	}

}
