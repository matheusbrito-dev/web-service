package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public final class TesteFormaPagamentoFACADE{

	public static void main( String[ ] args ) {

		try {

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			/** Criar uma FormaPagamento */
			FormaPagamentoPO po = new FormaPagamentoPO();
			po.setId( 1L );
			po.setNome( "Parcela" );
			po.setCompensacao( "3" );
			po.setGerarQuitadaToString( "true" );

			/** inserir */
			facade.inserir( po );

			/** Filtrando todos para ver se inseriu */
			List encontrados = facade.filtrar( null );// Lista e para varias
			System.out.println( encontrados );// igual a encontrados.toString

			/** Filtrando por ID para alterar */
			FormaPagamentoPO encotrado = (FormaPagamentoPO) facade.filtrarPorId( "1" );

			/** Alterar o FormaPagamento encontrada */
			encotrado.setNome( "Vista" );
			facade.alterar( encotrado );

			/** Filtrando por ID para alterar para varificar a alteração e excluir */
			encotrado = (FormaPagamentoPO) facade.filtrarPorId( "1" );

			/** Excluindo */
			facade.excluir( encotrado );

			/** Filtrando todos para ver se excluir */
			encontrados = facade.filtrar( null );// Lista e para varias
			System.out.println( encontrados );// igual a encontrados.toString

		} catch ( BackendException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}

	}

}
