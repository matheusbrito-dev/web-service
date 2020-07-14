package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;



import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFacadeExcluir{

	@Test
	public void executar() throws BackendException {
		FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

		try {

			AbstractPO encontrado = facade.filtrarPorId( "1" );
			System.out.println( "################## " + encontrado );
			facade.excluir( encontrado );

		} catch ( BackendException e ) {
			e.printStackTrace();
		}

	}

}
