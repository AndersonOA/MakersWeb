package br.com.stockcontrol.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.stockcontrol.model.Vendedor;
import br.com.stockcontrol.repository.Vendedores;
import br.com.stockcontrol.util.jpa.Transactional;

public class VendedorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Vendedores vendedores;
	
	@Transactional
	public void salvar(Vendedor vendedor) {
		vendedor.setNome(vendedor.getNome().trim());
		
		this.vendedores.salvar(vendedor);
	}

}

