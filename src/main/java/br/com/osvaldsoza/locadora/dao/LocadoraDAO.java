package br.com.osvaldsoza.locadora.dao;

import java.util.List;

public interface LocadoraDAO<T> {

	public void salvar(T entity) ;
	public List<T> buscarTodos();
	public void excluir(T entity);
	public T buscarPeloCodigo(Long codigo);
}
