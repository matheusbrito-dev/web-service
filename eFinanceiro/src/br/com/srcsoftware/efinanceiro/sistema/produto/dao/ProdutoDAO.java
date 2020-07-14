package br.com.srcsoftware.efinanceiro.sistema.produto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.efinanceiro.sistema.produto.model.ProdutoPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class ProdutoDAO {

	public void inserir( HibernateConnection hibernate, ProdutoPO po ) throws BackendException {
		/**
		 * Invocando o método inserir do nosso
		 * componente de Conexão HibernateConnection
		 */

		ProdutoPO poInserido = (ProdutoPO) hibernate.inserir( po );

		/** Pegando o ID do Produto Recem inserida */
		po.setId( poInserido.getId() );
	}

	public void alterar( HibernateConnection hibernate, ProdutoPO po ) throws BackendException {

		hibernate.alterar( po );
	}

	public void excluir( HibernateConnection hibernate, ProdutoPO po ) throws BackendException {

		hibernate.excluir( po );
	}

	public ProdutoPO filtrarPorId( Long id ) throws BackendException {
		return (ProdutoPO) new HibernateConnection().filtrarPorId( id, ProdutoPO.class );
	}

	public List< ProdutoPO > filtrar( ProdutoPO poFiltrar ) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			//Fazer o que tem que fazer
			/** utilizando CriteriaBuilder para a confecção de nossas Queries */
			//Criando a Criteria com base na CriteriaBuilder
			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( ProdutoPO.class );

			//Definindo o FROM
			Root root = criteria.from( ProdutoPO.class );

			//Deixando a Criteria preparada para a consulta
			criteria.select( root );

			//Definindo os Parametros(Predicados) para a consulta(WHERE)
			ArrayList< Predicate > predicados = new ArrayList< Predicate >();

			if ( poFiltrar != null ) {
				if ( poFiltrar.getNome() != null && poFiltrar.getNome().isEmpty() ) {
					Predicate nomeParam = builder.like( root.get( "nome" ), poFiltrar.getNome().concat( "%" ) );
					predicados.add( nomeParam );
				}
				if ( poFiltrar.getCodigo() != null && poFiltrar.getCodigo().isEmpty() ) {
					Predicate codigoParam = builder.like( root.get( "codigo" ), poFiltrar.getCodigo().concat( "%" ) );
					predicados.add( codigoParam );
				}
				if ( poFiltrar.getValor() != null) {
					Predicate valorParam = builder.equal(root.get("valor"), poFiltrar.getValor());
					predicados.add( valorParam );
				}
			}

			//Adicionando o Predicado no WHERE
			criteria.where( predicados.toArray( new Predicate[ predicados.size() ] ) );

			List< ProdutoPO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();

			hibernate.commitTransacao();

			return encontrados;

		} catch ( BackendException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Throwable e ) {
			hibernate.rollbackTransacao();
			throw new BackendException( "Erro ao filtrar", e );
		}

	}
	
}
