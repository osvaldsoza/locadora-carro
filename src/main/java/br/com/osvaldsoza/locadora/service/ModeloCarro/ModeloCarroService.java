package br.com.osvaldsoza.locadora.service.ModeloCarro;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.osvaldsoza.locadora.dao.modeloCarro.ModeloCarroDAO;
import br.com.osvaldsoza.locadora.modelo.modeloCarro.ModeloCarro;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;

public class ModeloCarroService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	public void salvar(ModeloCarro modeloCarro) throws NegocioException{
		if(modeloCarro.getDescricao() == null || modeloCarro.getDescricao().equals("")) {
			throw new NegocioException("A descrição do Modelo do Carro é obrigatória!");
		}
		
		if(modeloCarro.getFabricante() == null) {
			throw new NegocioException("Selecione um Fabricante!");
		}
		
		this.modeloCarroDAO.salvar(modeloCarro);
	}
	
	public List<ModeloCarro> buscarTodos(){
		List<ModeloCarro> todosModelosCarros = modeloCarroDAO.buscarTodos();
		return todosModelosCarros;
	}
	
	public void excluir(ModeloCarro modeloCarro) throws NegocioException{
		try {
			this.modeloCarroDAO.excluir(modeloCarro);
		}catch (PersistenceException e) {
			throw new NegocioException("Este modelo não pode ser excluído!");
		}		
	}
}
