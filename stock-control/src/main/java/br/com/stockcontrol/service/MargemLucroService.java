package br.com.stockcontrol.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Inject;

import br.com.stockcontrol.model.MargemLucro;
import br.com.stockcontrol.repository.MargensLucro;
import br.com.stockcontrol.service.NegocioException;
import br.com.stockcontrol.util.format.Formatador;

public class MargemLucroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Formatador formatador;
	
	@Inject
	private MargensLucro margensLucro;

	public void salvar(MargemLucro margemLucro) {
		BigDecimal custoInicial = margemLucro.getCustoInicial();
		BigDecimal custoFinal = margemLucro.getCustoFinal();
		
		if (custoInicialMaiorOuIgualAoCustoFinal(custoInicial, custoFinal)) {
			throw new NegocioException("O custo inicial deve ser maior que o custo final.");
		}
		
		if (margensLucro.existeCustoNoIntervalo(custoInicial)) {
			throw new NegocioException("Custo inicial " + formatador.moeda(custoInicial) + " já cadastrado no intervalo");
		}
		
		if (margensLucro.existeCustoNoIntervalo(custoFinal)) {
			throw new NegocioException("Custo final " + custoFinal + " já cadastrado no intervalo");
		}
		
		this.margensLucro.salvar(margemLucro);
	}

	private boolean custoInicialMaiorOuIgualAoCustoFinal(
			BigDecimal custoInicial, BigDecimal custoFinal) {
		return custoInicial.compareTo(custoFinal) >= 0;
	}
	
}
