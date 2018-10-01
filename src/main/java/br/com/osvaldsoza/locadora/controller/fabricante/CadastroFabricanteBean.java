package br.com.osvaldsoza.locadora.controller.fabricante;

import java.io.Serializable;

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
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService cadastroFabricanteService;

	private Fabricante fabricante;

	@PostConstruct
	public void init() {
		limpar();
	}

	public void limpar() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
			limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}	
}
