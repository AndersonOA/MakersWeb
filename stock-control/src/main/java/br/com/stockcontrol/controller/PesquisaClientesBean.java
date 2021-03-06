package br.com.stockcontrol.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.stockcontrol.model.Cliente;
import br.com.stockcontrol.repository.Clientes;
import br.com.stockcontrol.repository.filter.ClienteFilter;
import br.com.stockcontrol.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;
	
	private Cliente clienteSelecionado;
	
	@Inject
	private Clientes clientes;
	
	public PesquisaClientesBean() {
		this.filtro = new ClienteFilter();
	}
	
	public void pesquisar() {
		this.clientesFiltrados = this.clientes.filtrados(filtro);
	}
	
	public void excluir() {
		this.clientes.remover(clienteSelecionado);
		this.clientesFiltrados.remove(this.clienteSelecionado);
		
		FacesUtil.addInfoMessage("Cliente \"" + clienteSelecionado.getNome() + "\" removido com sucesso.");
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
}
