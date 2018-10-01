package br.com.osvaldsoza.locadora.dao.aluguel;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.osvaldsoza.locadora.dao.LocadoraDAO;
import br.com.osvaldsoza.locadora.modelo.aluguel.Aluguel;
import br.com.osvaldsoza.locadora.util.jpa.Transactional;

public class AluguelDAO implements Serializable, LocadoraDAO<Aluguel>  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(Aluguel aluguel){
		entityManager.merge(aluguel);
	}

	@Override
	public List<Aluguel> buscarTodos() {
		return null;
	}

	@Override
	public void excluir(Aluguel aluguel) {
	
	}

	@Override
	public Aluguel buscarPeloCodigo(Long codigo) {
		return null;
	}

}
