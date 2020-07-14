package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;



import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFacadeInserir{

	public static void main( String[ ] args ) throws BackendException {

		FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
		/** Criar uma FormaPagamento */
		FormaPagamentoPO po = new FormaPagamentoPO();
		po.setNome( "Dinheiro" );
		po.setCompensacao( "1" );
		po.setGerarQuitada( true );
		facade.inserir( po );

		List< FormaPagamentoPO > encontrados = facade.filtrar( po );
		System.out.println( "################## FILTRAR " + encontrados );

	}

}
