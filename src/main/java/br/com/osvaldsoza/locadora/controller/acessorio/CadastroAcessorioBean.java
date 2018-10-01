package br.com.osvaldsoza.locadora.controller.acessorio;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.osvaldsoza.locadora.modelo.acessorio.Acessorio;
import br.com.osvaldsoza.locadora.service.acessorio.AcessorioService;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;
import br.com.osvaldsoza.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Acessorio acessorio;
	
	@Inject
	private AcessorioService cadastroAcessorioService;
	
	public CadastroAcessorioBean() {
		this.limpar();
	}
	
	public void salvar() {
		try {
			this.cadastroAcessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}
	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
}