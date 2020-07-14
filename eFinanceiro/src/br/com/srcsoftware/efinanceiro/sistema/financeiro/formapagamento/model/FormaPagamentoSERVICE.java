package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model;

import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao.FormaPagamentoDAO;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.interfaces.Crud;

public class FormaPagamentoSERVICE implements Crud{
	
	private final FormaPagamentoDAO DAO;

	public FormaPagamentoSERVICE(){
		//Quando o FACEDE instanciar o SERVICE automaticamente ir� para o DAO
		DAO = new FormaPagamentoDAO();
	}

	@Override
	public void inserir( final AbstractPO PO ) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Inicio do bloco de Transa��o */
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendException( "Objeto nulo passado como parametro!" );
			}
			FormaPagamentoPO FormaPagamento = null;
			if ( PO instanceof FormaPagamentoPO ) {
				FormaPagamento = (FormaPagamentoPO) PO;
			} else {
				throw new BackendException( "O Objeto PO passado n�o condiz com o contexto!" );
			}
			

			DAO.inserir( hibernate, FormaPagamento );
			hibernate.commitTransacao();
			/** Fim do bloco de transa��o */

		} catch ( BackendException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendException( "Erro desconhecido ao inserir ", e );
		}

	}

	@Override
	public void alterar( final AbstractPO PO ) throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Inicio do bloco de Transa��o */
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendException( "Objeto nulo passado como parametro!" );
			}
			FormaPagamentoPO FormaPagamento = null;
			if ( PO instanceof FormaPagamentoPO ) {
				FormaPagamento = (FormaPagamentoPO) PO;
			} else {
				throw new BackendException( "O Objeto PO passado n�o condiz com o contexto!" );
			}

			DAO.alterar( hibernate, FormaPagamento );
			hibernate.commitTransacao();

		} catch ( BackendException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendException( "Erro desconhecido ao alterar ", e );
		}

	}

	@Override
	public void excluir( final AbstractPO PO ) throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Inicio do bloco de Transa��o */
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendException( "Objeto nulo passado como parametro!" );
			}
			FormaPagamentoPO FormaPagamento = null;
			if ( PO instanceof FormaPagamentoPO ) {
				FormaPagamento = (FormaPagamentoPO) PO;
			} else {
				throw new BackendException( "O Objeto PO passado n�o condiz com o contexto!" );
			}

			DAO.excluir( hibernate, FormaPagamento );
			hibernate.commitTransacao();

		} catch ( BackendException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendException( "Erro desconhecido ao excluir ", e );
		}

	}

	@Override
	public List filtrar( final AbstractPO PO ) throws BackendException {
		try {
			FormaPagamentoPO formaPagamento = null;

			if ( PO != null ) {

				if ( PO instanceof FormaPagamentoPO ) {
					formaPagamento = (FormaPagamentoPO) PO;
				} else {
					throw new BackendException( "O Objeto PO passado n�o condiz com o contexto!" );
				}
			}

			return DAO.filtrar( formaPagamento );
		} catch ( BackendException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendException( "Erro desconhecido ao excluir ", e );
		}
	}

	@Override
	public AbstractPO filtrarPorId( final String ID ) throws BackendException {
		try {

			if ( ID == null ) {
				throw new BackendException( "ID nulo passado como par�metro" );
			}

			System.out.println( "SERVICE: filtrando por id" );

			return DAO.filtrarPorId( Long.valueOf( ID ) );
		} catch ( BackendException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendException( "Erro desconhecido ao excluir ", e );
		}

	}

}
