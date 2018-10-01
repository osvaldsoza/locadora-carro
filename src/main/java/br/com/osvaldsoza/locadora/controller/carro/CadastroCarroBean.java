package br.com.osvaldsoza.locadora.controller.carro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.osvaldsoza.locadora.modelo.acessorio.Acessorio;
import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.modelo.modeloCarro.ModeloCarro;
import br.com.osvaldsoza.locadora.service.ModeloCarro.ModeloCarroService;
import br.com.osvaldsoza.locadora.service.acessorio.AcessorioService;
import br.com.osvaldsoza.locadora.service.carro.CarroService;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;
import br.com.osvaldsoza.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro carro;

	private List<ModeloCarro> modelosCarros;
	
	private List<Acessorio> acessorios;
	
	@Inject
	private CarroService carroService;
	
	@Inject
	private AcessorioService acessorioService;
	
	@Inject
	private ModeloCarroService modeloCarroService;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.acessorios = acessorioService.buscarTodos();
		this.modelosCarros = this.modeloCarroService.buscarTodos();
	}
	
	public void salvar() {
		try {
			this.carroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador");
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.carro = new Carro();
		this.carro.setAcessorios(new ArrayList<Acessorio>());
	}

	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

}