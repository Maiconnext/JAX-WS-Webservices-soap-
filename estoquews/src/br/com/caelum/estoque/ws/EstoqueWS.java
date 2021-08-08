package br.com.caelum.estoque.ws;

import java.util.ArrayList;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	public ArrayList<Item> getItens(){
		
		System.out.println("Chamando getItens() ");
		ArrayList<Item> list = dao.todosItens();
		return list;
	}
}
