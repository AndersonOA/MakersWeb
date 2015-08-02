package br.com.makersweb.maladireta.csv;

import br.com.makersweb.contato.Contatos;
import br.com.makersweb.maladireta.MalaDireta;

public class MalaDiretaCSV extends MalaDireta {

	private String nomeArquivo;
	
	public MalaDiretaCSV(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	@Override
	protected Contatos criarContato() {
		return new ContatosCSV(nomeArquivo);
	}

	
	
}
