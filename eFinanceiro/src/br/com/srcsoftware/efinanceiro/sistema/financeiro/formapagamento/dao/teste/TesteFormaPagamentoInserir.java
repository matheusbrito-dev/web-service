package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.teste;

import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoInserir{

	@Test
	public void excutar() throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();
		try {
			hibernate.iniciarTransacao();

			FormaPagamentoPO po = new FormaPagamentoPO();
			po.setNome( "Parcela" );
			po.setCompensacao( "3" );
			po.setGerarQuitadaToString( "true" );

			po = (FormaPagamentoPO) hibernate.inserir( po );
			System.out.println( po );
			hibernate.commitTransacao();

		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		}

	}

}
