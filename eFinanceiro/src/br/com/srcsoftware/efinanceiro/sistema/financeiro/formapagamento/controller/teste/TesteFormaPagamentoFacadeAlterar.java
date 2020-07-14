package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;



import java.util.List;

import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFacadeAlterar{

	@Test
	public void executar() throws BackendException {
		FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

		try {

			FormaPagamentoPO poFiltrar = new FormaPagamentoPO();
			poFiltrar.setNome( "Dinheiro" );

			FormaPagamentoPO encontrado = (FormaPagamentoPO) facade.filtrar( poFiltrar ).get( 0 );
			encontrado.setNome( "Cheque" );

			facade.alterar( encontrado );

			List< FormaPagamentoPO > encontrados = facade.filtrar( null );
			System.out.println( "################## FILTRAR " + encontrados );

		} catch ( BackendException e ) {
			e.printStackTrace();
		}

	}

}
