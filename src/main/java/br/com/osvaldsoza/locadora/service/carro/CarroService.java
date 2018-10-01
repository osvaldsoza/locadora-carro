package br.com.osvaldsoza.locadora.service.carro;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.osvaldsoza.locadora.dao.carro.CarroDAO;
import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;

public class CarroService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDAO;
	
	public void salvar(Carro carro) throws NegocioException{
		validarCampos(carro);
		
		carroDAO.salvar(carro);
	}
	
	public List<Carro> buscarTodos(){
		return carroDAO.buscarTodos();
	}
	
	public void excluir(Carro carro) throws NegocioException{
		try {
			carroDAO.excluir(carro);
		}catch (PersistenceException e) {
			throw new NegocioException("Esse Carro não pode ser excluído!");
		}
	}

	private void validarCampos(Carro carro) throws NegocioException {
		if(carro.getPlaca() == null || carro.getPlaca().equals("")) {
			throw new NegocioException("A Placa  do Carro é obrigatória!");
		}
		
		if(carro.getCor() == null || carro.getCor().equals("")) {
			throw new NegocioException("A Cor  do Carro é obrigatória!");
		}
		
		if(carro.getChassi() == null || carro.getChassi().equals("")) {
			throw new NegocioException("O Chassi do Carro é obrigatório!");
		}
		
		if(carro.getValorDiaria() == null) {
			throw new NegocioException("O Valor da Diária é obrigatória!");
		}
		
		if(carro.getModelo() == null) {
			throw new NegocioException("O Modelo do Carro é obrigatório!");
		}
		
		if(carro.getAcessorios() == null) {
			throw new NegocioException("Acessórios são obrigatórios!");
		}
	}
}
