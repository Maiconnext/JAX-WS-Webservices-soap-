package br.com.estoque.modelo.item;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filtros {

	@XmlElement(name = "filtro")
	private ArrayList<Filtro> filtros;

	public Filtros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}

	Filtros() {
	}
	
	public ArrayList<Filtro> getLista() {
		return filtros;
	}
	
}
