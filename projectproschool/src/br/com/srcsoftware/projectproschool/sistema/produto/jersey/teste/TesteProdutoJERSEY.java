package br.com.srcsoftware.projectproschool.sistema.produto.jersey.teste;

import br.com.srcsoftware.projectproschool.sistema.produto.jersey.ProdutoJERSEY;
import br.com.srcsoftware.projectproschool.sistema.produto.model.ProdutoPO;

public class TesteProdutoJERSEY {
	
	public static void main(String[] args) {
		
		ProdutoPO po = new ProdutoPO();
		
		/*po.setValorToString("0000");
		po.setNome("TESTE INSERIR");
		po.setCodigo("123");
		
		inserir(po);*/
		
		/*po.setIdToString("2");
		po.setValorToString("410");
		po.setNome("TESTE ALTERAR");
		po.setCodigo("321");
		alterar(po);*/
		
		po.setNome("TESTE INSERIR");
		filtrar(po);
		
		/*excluir("2");*/
		
	}

	private static void filtrar(ProdutoPO po) {
		ProdutoJERSEY jersey = new ProdutoJERSEY();
		jersey.filtrar(po);
		
	}

	private static void excluir(String id) {

		ProdutoJERSEY jersey = new ProdutoJERSEY();
		ProdutoPO po = jersey.filtrarPorId(id);
		jersey.excluir(po);
		
	}

	private static void alterar(ProdutoPO po) {
		ProdutoJERSEY jersey = new ProdutoJERSEY();
		jersey.alterar(po);
		
	}

	private static void inserir(ProdutoPO po) {
		
		ProdutoJERSEY jersey = new ProdutoJERSEY();
		jersey.inserir(po);
		
	}
	

}
