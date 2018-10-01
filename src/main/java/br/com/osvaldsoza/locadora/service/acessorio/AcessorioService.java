package br.com.osvaldsoza.locadora.service.acessorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.osvaldsoza.locadora.dao.acessorio.AcessorioDAO;
import br.com.osvaldsoza.locadora.modelo.acessorio.Acessorio;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;

public class AcessorioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	public void salvar(Acessorio acessorio) throws NegocioException{
		if(acessorio.getDescricao() == null || acessorio.getDescricao().equals("")) {
			throw new NegocioException("Descrição é obrigatória!");
		}
		acessorioDAO.salvar(acessorio);
	}
	
	public List<Acessorio> buscarTodos(){
		return acessorioDAO.buscarTodos();
	}
	
	public void excluir(Acessorio acessorio) throws NegocioException{
		acessorioDAO.excluir(acessorio);
	}
}
