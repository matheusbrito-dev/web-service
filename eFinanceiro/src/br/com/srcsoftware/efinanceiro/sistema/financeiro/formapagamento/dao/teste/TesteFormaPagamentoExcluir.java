package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.teste;


import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoExcluir{

	@Test
	public void excutar() throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();
		try {

			/** Testando o Filtrar po ID */
			AbstractPO encontrado = hibernate.filtrarPorId( Long.valueOf( "1" ), FormaPagamentoPO.class );
			System.out.println( "################## " + encontrado );

			hibernate.iniciarTransacao();
			hibernate.excluir( encontrado );
			hibernate.commitTransacao();

		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		}

	}

}
