package br.com.makersweb.maladireta;

import java.util.List;

import br.com.makersweb.contato.Contato;
import br.com.makersweb.contato.Contatos;

public abstract class MalaDireta {
	
	protected abstract Contatos criarContato();
	
	public boolean enviarMensagem(String mensagem) {
		List<Contato> contatos = criarContato().todos();
		
		System.out.println("Conectando no servidor SMTP...");
		System.out.println("Mensagem a ser enviada: " + mensagem);
		System.out.println();
		
		for (Contato contato : contatos) {
			System.out.println("From: <contato@makersweb.com.br>");
			System.out.printf("To: [%s] <%s>\n", contato.getNome(), contato.getEmail());
			System.out.println(mensagem);
			System.out.println();
		}
		
		return true;
	}

}
