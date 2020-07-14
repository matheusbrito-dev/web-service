package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;



import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFacadeFiltrar{

	public static void main( String[ ] args ) throws BackendException {
		FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

		FormaPagamentoPO po = new FormaPagamentoPO();
		//po.setId( 1L );
		po.setNome( "Parcela" );
		po.setCompensacao( "3" );
		po.setGerarQuitada( true );
		List< FormaPagamentoPO > encontrados = facade.filtrar( po );
		System.out.println( "################## FILTRAR " + encontrados );

	}

}
