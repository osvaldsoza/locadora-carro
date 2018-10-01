package br.com.osvaldsoza.locadora.service.fabricante;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.osvaldsoza.locadora.dao.fabricante.FabricanteDAO;
import br.com.osvaldsoza.locadora.modelo.fabricante.Fabricante;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDAO fabricanteDAO;

	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O Nome do Fabricante é obrigatório!");
		}

		this.fabricanteDAO.salvar(fabricante);
	}
	
	public void excluir(Fabricante fabricante) throws NegocioException{
		this.fabricanteDAO.excluir(fabricante);
	}
	
	public List<Fabricante> buscarTodos(){
		List<Fabricante> fabricantes = fabricanteDAO.buscarTodos();
		return fabricantes;
	}
}
