package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class ClienteDAO {

	public void inserir( HibernateConnection hibernate, ClientePO po ) throws BackendException {
		/**
		 * Invocando o método inserir do nosso
		 * componente de Conexão HibernateConnection
		 */

		ClientePO poInserido = (ClientePO) hibernate.inserir( po );

		/** Pegando o ID do Cliente Recem inserida */
		po.setId( poInserido.getId() );
	}

	public void alterar( HibernateConnection hibernate, ClientePO po ) throws BackendException {

		hibernate.alterar( po );
	}

	public void excluir( HibernateConnection hibernate, ClientePO po ) throws BackendException {

		hibernate.excluir( po );
	}

	public ClientePO filtrarPorId( Long id ) throws BackendException {
		return (ClientePO) new HibernateConnection().filtrarPorId( id, ClientePO.class );
	}

	public List< ClientePO > filtrar( ClientePO poFiltrar ) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			//Fazer o que tem que fazer
			/** utilizando CriteriaBuilder para a confecção de nossas Queries */
			//Criando a Criteria com base na CriteriaBuilder
			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( ClientePO.class );

			//Definindo o FROM
			Root root = criteria.from( ClientePO.class );

			//Deixando a Criteria preparada para a consulta
			criteria.select( root );

			//Definindo os Parametros(Predicados) para a consulta(WHERE)
			ArrayList< Predicate > predicados = new ArrayList< Predicate >();

			if ( poFiltrar != null ) {
				
				if (poFiltrar.getId() != null) {
					Predicate idParam = builder.equal(root.get("id"), poFiltrar.getId());
					predicados.add(idParam);
				} else {

					if (poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty()) {
						Predicate nomeParam = builder.like(root.get("nome"), poFiltrar.getNome().concat("%"));
						predicados.add(nomeParam);
					}
					if (poFiltrar.getSexo() != null && !poFiltrar.getSexo().isEmpty()) {
						Predicate sexoParam = builder.like(root.get("sexo"), poFiltrar.getSexo().concat("%"));
						predicados.add(sexoParam);
					}
					if (poFiltrar.getCpf() != null && !poFiltrar.getCpf().isEmpty()) {
						Predicate cpfParam = builder.like(root.get("cpf"), poFiltrar.getCpf().concat("%"));
						predicados.add(cpfParam);
					}
					if (poFiltrar.getEmail() != null && !poFiltrar.getEmail().isEmpty()) {
						Predicate emailParam = builder.like(root.get("email"), poFiltrar.getEmail().concat("%"));
						predicados.add(emailParam);
					}
					if (poFiltrar.getEndereco() != null && !poFiltrar.getEndereco().isEmpty()) {
						Predicate enderecoParam = builder.like(root.get("endereco"), poFiltrar.getEndereco().concat("%"));
						predicados.add(enderecoParam);
					}
					if (poFiltrar.getStatus() != null) {
						Predicate statusParam = builder.equal(root.get("status"), poFiltrar.getStatus());
						predicados.add(statusParam);
					}
					if (poFiltrar.getTelefone() != null && !poFiltrar.getTelefone().isEmpty()) {
						Predicate telefoneParam = builder.like(root.get("telefone"), poFiltrar.getTelefone().concat("%"));
						predicados.add(telefoneParam);
					}
				}
				
			}

			//Adicionando o Predicado no WHERE
			criteria.where( predicados.toArray( new Predicate[ predicados.size() ] ) );

			List< ClientePO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();

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
