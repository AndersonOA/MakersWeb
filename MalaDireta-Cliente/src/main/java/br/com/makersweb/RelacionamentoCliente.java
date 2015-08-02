package br.com.makersweb;

import javax.swing.JOptionPane;

import br.com.makersweb.maladireta.MalaDireta;
import br.com.makersweb.maladireta.xml.MalaDiretaXML;

public class RelacionamentoCliente {

	public static void main(String[] args) {
		MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
		String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem do e-mail:");
		
		boolean status = malaDireta.enviarMensagem(mensagem);
		
		JOptionPane.showConfirmDialog(null, "E-mails enviados " + status);
	}
}
