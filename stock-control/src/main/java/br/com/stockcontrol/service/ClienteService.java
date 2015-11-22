package br.com.stockcontrol.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.stockcontrol.model.Cliente;
import br.com.stockcontrol.repository.Clientes;
import br.com.stockcontrol.util.jpa.Transactional;

public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transactional
	public void salvar(Cliente cliente) {
		cliente.setNome(cliente.getNome().trim());
		
		this.clientes.salvar(cliente);
	}

}
