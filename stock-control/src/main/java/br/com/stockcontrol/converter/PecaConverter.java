package br.com.stockcontrol.converter;

import javax.faces.convert.FacesConverter;

import br.com.stockcontrol.converter.PecaConverterComum;
import br.com.stockcontrol.model.Peca;

@FacesConverter(forClass=Peca.class)
public class PecaConverter extends PecaConverterComum {
	
}
