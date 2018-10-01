package br.com.osvaldsoza.locadora.dao.acessorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.osvaldsoza.locadora.dao.LocadoraDAO;
import br.com.osvaldsoza.locadora.modelo.acessorio.Acessorio;
import br.com.osvaldsoza.locadora.util.jpa.Transactional;

public class AcessorioDAO implements Serializable, LocadoraDAO<Acessorio>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@Transactional
	public void salvar(Acessorio acessorio) {
		entityManager.merge(acessorio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Acessorio> buscarTodos() {
		return entityManager.createQuery("from Acessorio").getResultList();
	}

	@Transactional
	public void excluir(Acessorio acessorio) {
	  acessorio = entityManager.find(Acessorio.class, acessorio.getCodigo());
	  entityManager.remove(acessorio);
	  entityManager.flush();
	}

	@Override
	public Acessorio buscarPeloCodigo(Long codigo) { 
		return entityManager.find(Acessorio.class, codigo);
	}

}
