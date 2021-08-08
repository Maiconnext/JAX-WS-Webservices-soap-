package br.com.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.estoque.exception.AutorizacaoException;
import br.com.estoque.modelo.item.Filtro;
import br.com.estoque.modelo.item.Filtros;
import br.com.estoque.modelo.item.Item;
import br.com.estoque.modelo.item.ItemDao;
import br.com.estoque.modelo.item.ItemValidador;
import br.com.estoque.modelo.usuario.TokenDao;
import br.com.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName = "TodosOsItens")
	@RequestWrapper(localName = "listaItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens() ");
		List<Filtro> lista = filtros.getLista();
		List<Item> result = dao.todosItens(lista);
		return result;
	}
	
	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(
			@WebParam(name = "tokenUsuario", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		System.out.println("Cadastrando " + item + "," + tokenUsuario);
		
		if(!new TokenDao().ehValido(tokenUsuario)) {
			throw new AutorizacaoException("Autorização falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		return item;
	}
}
