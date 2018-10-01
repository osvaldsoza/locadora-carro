package br.com.osvaldsoza.locadora.controller.fabricante;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.osvaldsoza.locadora.modelo.fabricante.Fabricante;
import br.com.osvaldsoza.locadora.service.fabricante.FabricanteService;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;
import br.com.osvaldsoza.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	FabricanteService fabricanteService;
	
	private List<Fabricante> fabricantes = new ArrayList<>();
	
	private Fabricante fabricanteSelecionado;
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void excluir() {
		try {
			fabricanteService.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteService.buscarTodos();
	}
}