package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.teste;



import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoAlterar{

	@Test
	public void excutar() throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();
		try {
			hibernate.iniciarTransacao();

			FormaPagamentoPO po = new FormaPagamentoPO();
			po.setGerarQuitadaToString( "false" );
			hibernate.alterar( po );
			System.out.println( po );
			hibernate.commitTransacao();

		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		}

	}

}
