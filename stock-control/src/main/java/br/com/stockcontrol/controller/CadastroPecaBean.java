package br.com.stockcontrol.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.stockcontrol.model.Peca;
import br.com.stockcontrol.service.PecaService;
import br.com.stockcontrol.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPecaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Peca peca;
	
	@Inject
	private PecaService pecaService;
	
	@PostConstruct
	public void init() {
		this.limpar();
	}

	private void limpar() {
		this.peca = new Peca();
	}
	
	public void salvar() {
		this.peca = this.pecaService.salvar(peca);
		FacesUtil.addInfoMessage("Peça salva com sucesso com código: " + this.peca.getCodigo());
		this.limpar();
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
}
