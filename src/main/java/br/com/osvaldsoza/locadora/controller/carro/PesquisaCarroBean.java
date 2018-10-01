package br.com.osvaldsoza.locadora.controller.carro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.osvaldsoza.locadora.modelo.carro.Carro;
import br.com.osvaldsoza.locadora.service.carro.CarroService;
import br.com.osvaldsoza.locadora.util.exception.NegocioException;
import br.com.osvaldsoza.locadora.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Carro> carros;
	
	private Carro carroSelecionado;
	
	@Inject
	CarroService carroService;

	public List<Carro> getCarros() {
		return carros;
	}
	
	@PostConstruct
	public void inicializar() {
		this.carros = this.carroService.buscarTodos();
	}
	
	public void excluir() {
		try {
			carroService.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage("Carro " + carroSelecionado.getModelo().getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}
	
}