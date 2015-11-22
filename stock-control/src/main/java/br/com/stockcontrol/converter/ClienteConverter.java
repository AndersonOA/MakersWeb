package br.com.stockcontrol.converter;

import javax.faces.convert.FacesConverter;

import br.com.stockcontrol.converter.ClienteConverterComum;
import br.com.stockcontrol.model.Cliente;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter extends ClienteConverterComum {

}
