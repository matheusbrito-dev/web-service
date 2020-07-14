package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.teste;


import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.FormaPagamentoDAO;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TesteFromaPagamento{

	public static void main( String[ ] args ) throws BackendException {
		FormaPagamentoDAO dao = new FormaPagamentoDAO();

		FormaPagamentoPO po = new FormaPagamentoPO();
		po.setId( 1L );
		po.setNome( "Parcela" );
		po.setCompensacao( "3" );
		po.setGerarQuitada( true );
		List< FormaPagamentoPO > encontrados = dao.filtrar( po );
		System.out.println( "################## FILTRAR " + encontrados );

	}

}
