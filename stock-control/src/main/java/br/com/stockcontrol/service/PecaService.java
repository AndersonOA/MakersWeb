package br.com.stockcontrol.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.stockcontrol.model.Peca;
import br.com.stockcontrol.repository.Pecas;
import br.com.stockcontrol.util.jpa.Transactional;

public class PecaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pecas pecas;
	
	@Transactional
	public Peca salvar(Peca peca) {
		return pecas.salvar(peca);
	}
	
}