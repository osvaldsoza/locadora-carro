package br.com.osvaldsoza.locadora.dao.fabricante;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.osvaldsoza.locadora.dao.LocadoraDAO;
import br.com.osvaldsoza.locadora.modelo.fabricante.Fabricante;
import br.com.osvaldsoza.locadora.util.jpa.Transactional;

public class FabricanteDAO implements Serializable, LocadoraDAO<Fabricante>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Fabricante fabricante) {
		entityManager.merge(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return entityManager.createQuery("from Fabricante").getResultList();
	}
	
	@Transactional
	public void excluir(Fabricante fabricante) {
		fabricante = entityManager.find(Fabricante.class, fabricante.getCodigo());
		entityManager.remove(fabricante);
		entityManager.flush();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return entityManager.find(Fabricante.class,codigo);
	}
}
