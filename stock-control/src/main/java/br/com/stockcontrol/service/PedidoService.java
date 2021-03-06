package br.com.stockcontrol.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.stockcontrol.model.Parcela;
import br.com.stockcontrol.model.Pedido;
import br.com.stockcontrol.repository.Pedidos;
import br.com.stockcontrol.service.NegocioException;
import br.com.stockcontrol.util.jpa.Transactional;

public class PedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public Pedido salvar(Pedido pedido) {
		if (pedido.getItensDoPedido().isEmpty()) {
			throw new NegocioException("Adicione pelo menos um item ao pedido.");
		}
		
		if (pedido.getPagamento() == null || pedido.getPagamento().getFormaPagamento() == null) {
			throw new NegocioException("Você deve escolher uma forma de pagamento antes de salvar.");
		}
		
		completamenteRecebido(pedido);
		
		return pedidos.salvar(pedido);
	}

	private void completamenteRecebido(Pedido pedido) {
		boolean completamenteRecebido = false;
		for (Parcela parcela : pedido.getPagamento().getParcelas()) {
			if (!parcela.isRecebido()) {
				break;
			}
			completamenteRecebido = true;
		}
		pedido.getPagamento().setCompletamenteRecebido(completamenteRecebido);
	}

}
