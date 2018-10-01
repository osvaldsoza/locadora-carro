package br.com.osvaldsoza.locadora.dao.modeloCarro;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.osvaldsoza.locadora.dao.LocadoraDAO;
import br.com.osvaldsoza.locadora.modelo.modeloCarro.ModeloCarro;
import br.com.osvaldsoza.locadora.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable, LocadoraDAO<ModeloCarro> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) {
		entityManager.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return entityManager.createQuery("from ModeloCarro").getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) {
		modeloCarro = entityManager.find(ModeloCarro.class, modeloCarro.getCodigo());
		entityManager.remove(modeloCarro);
		entityManager.flush();
	}

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return entityManager.find(ModeloCarro.class, codigo);
	}

}
