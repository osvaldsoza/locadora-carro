package br.com.osvaldsoza.locadora.dao.carro;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.osvaldsoza.locadora.dao.LocadoraDAO;
import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.util.jpa.Transactional;

public class CarroDAO implements Serializable, LocadoraDAO<Carro>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(Carro carro) {
		entityManager.merge(carro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> buscarTodos() {
		return entityManager.createQuery("from Carro").getResultList();
	}

	@Transactional
	public void excluir(Carro carro) {
		carro = entityManager.find(Carro.class, carro.getCodigo());
		entityManager.remove(carro);
		entityManager.flush();
	}

	
	public Carro buscarPeloCodigo(Long codigo) {
		return entityManager.find(Carro.class, codigo);
	}

}
