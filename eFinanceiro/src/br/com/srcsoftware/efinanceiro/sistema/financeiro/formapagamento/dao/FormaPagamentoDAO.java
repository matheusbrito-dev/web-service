package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class FormaPagamentoDAO {

	public void inserir(HibernateConnection hibernate, FormaPagamentoPO po) throws BackendException {
		/**
		 * Invocando o método inserir do nosso componente de Conexão HibernateConnection
		 */

		FormaPagamentoPO poInserido = (FormaPagamentoPO) hibernate.inserir(po);

		/** Pegando o ID do FormaPagamento Recem inserida */
		po.setId(poInserido.getId());
	}

	public void alterar(HibernateConnection hibernate, FormaPagamentoPO po) throws BackendException {

		hibernate.alterar(po);
	}

	public void excluir(HibernateConnection hibernate, FormaPagamentoPO po) throws BackendException {

		hibernate.excluir(po);
	}

	public FormaPagamentoPO filtrarPorId(Long id) throws BackendException {
		return (FormaPagamentoPO) new HibernateConnection().filtrarPorId(id, FormaPagamentoPO.class);
	}

	public List<FormaPagamentoPO> filtrar(FormaPagamentoPO poFiltrar) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			// Fazer o que tem que fazer
			/** utilizando CriteriaBuilder para a confecção de nossas Queries */
			// Criando a Criteria com base na CriteriaBuilder
			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery(FormaPagamentoPO.class);

			// Definindo o FROM
			Root root = criteria.from(FormaPagamentoPO.class);

			// Deixando a Criteria preparada para a consulta
			criteria.select(root);

			// Definindo os Parametros(Predicados) para a consulta(WHERE)
			ArrayList<Predicate> predicados = new ArrayList<Predicate>();

			if (poFiltrar != null) {

				if (poFiltrar.getId() != null) {
					Predicate idParam = builder.equal(root.get("id"), poFiltrar.getId());
					predicados.add(idParam);
				} else {

					if (poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty()) {
						Predicate nomeParam = builder.like(root.get("nome"), poFiltrar.getNome().concat("%"));
						predicados.add(nomeParam);
					}
					if (poFiltrar.getCompensacao() != null && !poFiltrar.getCompensacao().isEmpty()) {
						Predicate compensacaoParam = builder.like(root.get("compensacao"), poFiltrar.getCompensacao().concat("%"));
						predicados.add(compensacaoParam);
					}
					if (poFiltrar.getGerarQuitada() != null) {
						Predicate gerarQuitadaParam = builder.equal(root.get("gerarQuitada"),
								poFiltrar.getGerarQuitada());
						predicados.add(gerarQuitadaParam);
					}
				}
			}

			// Adicionando o Predicado no WHERE
			criteria.where(predicados.toArray(new Predicate[predicados.size()]));

			List<FormaPagamentoPO> encontrados = hibernate.getCurrentSession().createQuery(criteria).getResultList();

			hibernate.commitTransacao();

			return encontrados;

		} catch (BackendException e) {
			hibernate.rollbackTransacao();
			throw e;
		} catch (Throwable e) {
			hibernate.rollbackTransacao();
			throw new BackendException("Erro ao filtrar", e);
		}

	}

}
