package br.com.estoque.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFaut", messageName = "AutorizacaoFaut")
public class AutorizacaoException extends Exception {
	private static final long serialVersionUID = -4856585216924043772L;

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token invalido ", new Date());
	}

	
}
