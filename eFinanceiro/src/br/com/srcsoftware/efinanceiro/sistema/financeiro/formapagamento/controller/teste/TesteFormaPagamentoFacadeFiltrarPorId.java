package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;



import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFacadeFiltrarPorId{

	public static void main( String[ ] args ) throws BackendException {
		FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

		AbstractPO encontrado = facade.filtrarPorId( "1" );
		System.out.println( "################## " + encontrado );

	}

}
