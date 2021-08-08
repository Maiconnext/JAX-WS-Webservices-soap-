package br.com.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebservice {

	public static void main(String[] args) {

		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("Service Rodando: " + url);
		
		Endpoint.publish(url, service);	
	}

}
