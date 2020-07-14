package br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.jersey.teste;

import br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.jersey.FormaPagamentoJERSEY;
import br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.model.FormaPagamentoPO;

public class TesteFormaPagamentoJERSEY {

public static void main(String[] args) {
		
		FormaPagamentoPO po = new FormaPagamentoPO();
		
		/*po.setNome("TESTE INSERIR");
		po.setGerarQuitada(true);
		po.setCompensacao("asd");
		inserir(po);*/
		
		/*po.setIdToString("1");
		po.setNome("TESTE ALTERAR");
		po.setGerarQuitada(true);
		po.setCompensacao("3");
		alterar(po);*/
		
		/*po.setIdToString("1");
		filtrar(po);*/
		
		excluir("1");
		
	}

	private static void filtrar(FormaPagamentoPO po) {
		FormaPagamentoJERSEY jersey = new FormaPagamentoJERSEY();
		jersey.filtrar(po);
		
	}

	private static void excluir(String id) {

		FormaPagamentoJERSEY jersey = new FormaPagamentoJERSEY();
		FormaPagamentoPO po = jersey.filtrarPorId(id);
		jersey.excluir(po);
		
	}

	private static void alterar(FormaPagamentoPO po) {
		FormaPagamentoJERSEY jersey = new FormaPagamentoJERSEY();
		jersey.alterar(po);
		
	}

	private static void inserir(FormaPagamentoPO po) {
		
		FormaPagamentoJERSEY jersey = new FormaPagamentoJERSEY();
		jersey.inserir(po);
		
	}
	
}
