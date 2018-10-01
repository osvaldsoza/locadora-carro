package br.com.osvaldsoza.locadora.controller.aluguel;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.osvaldsoza.locadora.modelo.aluguel.Aluguel;
import br.com.osvaldsoza.locadora.modelo.apolice.ApoliceSeguro;
import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.service.aluguel.AluguelService;
import br.com.osvaldsoza.locadora.service.carro.CarroService;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;
import br.com.osvaldsoza.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluguel aluguel;
	
	private List<Carro> carros;
	
	@Inject
	private AluguelService aluguelService;
	
	@Inject
	private CarroService carroService;
	
	public void salvar() {
		try {
			this.aluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.carros = this.carroService.buscarTodos();
	}
	
	public void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}

}