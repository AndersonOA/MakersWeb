package br.com.makersweb.maladireta.xml;

import br.com.makersweb.contato.Contatos;
import br.com.makersweb.maladireta.MalaDireta;

public class MalaDiretaXML extends MalaDireta {
	
	private String nomeArquivo;
	
	public MalaDiretaXML(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	protected Contatos criarContato() {
		return new ContatosXML(nomeArquivo);
	}

}
