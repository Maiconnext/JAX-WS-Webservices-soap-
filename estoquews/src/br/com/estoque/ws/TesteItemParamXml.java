package br.com.estoque.ws;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



import br.com.estoque.modelo.item.Item;

public class TesteItemParamXml {

//	Leitura de um xml com o Marshaller
	public static void main(String[] args) throws JAXBException {
		Item item = new Item.Builder()
				.comCodigo("MEA")
				.comNome("MEAN")
				.comQuantidade(4)
				.comTipo("Livro")
				.build();
		
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller =context.createMarshaller();
//		cria o arquivo xml na pasta do arquivo
		marshaller.marshal(item, new File("item.xml"));
				
	}
}
