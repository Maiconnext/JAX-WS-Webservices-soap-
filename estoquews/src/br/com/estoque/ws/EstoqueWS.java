package br.com.estoque.ws;

import java.util.ArrayList;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.estoque.modelo.item.Filtro;
import br.com.estoque.modelo.item.Filtros;
import br.com.estoque.modelo.item.Item;
import br.com.estoque.modelo.item.ItemDao;
import br.com.estoque.modelo.item.ItemValidador;
import br.com.estoque.modelo.usuario.AutorizacaoException;
import br.com.estoque.modelo.usuario.TokenDao;
import br.com.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL ,parameterStyle = ParameterStyle.BARE)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(action = "TodosOsItens", operationName = "TodosOsItens")
	@RequestWrapper(localName = "listaItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public ArrayList<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens() ");
		ArrayList<Filtro> lista = filtros.getLista();
		ArrayList<Item> result = dao.todosItens(lista);
		return result;
	}
	
	@WebMethod(action = "CadastrarItens", operationName = "CadastrarItem")
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
	
//	A anotação @Oneway faz com que o JAX-B saiba que o metodo não terá retorno
	@Oneway
	@WebMethod(action = "gerarRelatorio", operationName = "GerarRelatorio")
	public void gerarRelatorio() {
		
	}
}
