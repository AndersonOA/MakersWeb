package br.com.makersweb;

import javax.swing.JOptionPane;

import br.com.makersweb.maladireta.MalaDireta;

public class Principal {

	public static void main(String[] args) {
		MalaDireta malaDireta = new MalaDireta();
		String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem para o e-mail: ");
		
		boolean status = malaDireta.enviarEmail("contatos.xml", mensagem);
		System.out.println(status);
	}

}
