package br.com.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault{

	@SuppressWarnings("unused")
	private Date dataErro;
	@SuppressWarnings("unused")
	private String mensagem;
	
	public InfoFault(String mensagem, Date dataErro) {
	
		this.dataErro = dataErro;
		this.mensagem = mensagem;
	}
	
	InfoFault(){
		
	}
}
