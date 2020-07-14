package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.teste;

import java.util.List;

import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.FormaPagamentoDAO;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFormaPagamentoFiltrar{

	@Test
	public void excutar() throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();
		try {
			FormaPagamentoDAO dao = new FormaPagamentoDAO();

			/** Testando o Filtrar */
			FormaPagamentoPO poFiltrar = new FormaPagamentoPO();
			poFiltrar.setNome( "Parcela" );
			poFiltrar.setCompensacao( "3" );
			poFiltrar.setGerarQuitada( true );
			List< FormaPagamentoPO > encontrados = dao.filtrar( poFiltrar );
			System.out.println( "################## FILTRAR " + encontrados );

		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		}

	}

}
