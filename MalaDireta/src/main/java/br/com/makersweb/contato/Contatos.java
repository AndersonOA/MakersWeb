package br.com.makersweb.contato;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import au.com.bytecode.opencsv.CSVReader;

public class Contatos {

	public List<Contato> recuperarContatosCSV(String nomeArquivo) {
		List<Contato> contatos = new ArrayList<>();
		CSVReader csvReader = null;
		
		try {
			URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
			File arquivoCsv = new File(uri);
			FileReader fileReader = new FileReader(arquivoCsv);
			csvReader = new CSVReader(fileReader);
			String [] nextline;
			
			while ((nextline = csvReader.readNext()) != null) {
				contatos.add(new Contato(nextline[0].trim(), nextline[1].trim()));
				
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ss lendo arquivo csv", e);
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {}
		}
		
		
		return contatos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> recuperarContatosXML(String nomeArquivo) {
		XStream xstream = new XStream();
		xstream.alias("contatos", List.class);
		xstream.alias("contato", Contato.class);
		
		URL arquivo = this.getClass().getResource("/" + nomeArquivo);
		return (List<Contato>) xstream.fromXML(arquivo);
	}

}

























