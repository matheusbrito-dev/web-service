package br.com.srcsoftware.efinanceiro.sistema.produto.model;

import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.produto.dao.ProdutoDAO;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.interfaces.Crud;
import br.com.srcsoftware.manager.utilidades.Utilidades;

public class ProdutoSERVICE implements Crud{
	
	private final ProdutoDAO DAO;

	public ProdutoSERVICE() {
		// Quando o FACEDE instanciar o SERVICE automaticamente irá para o DAO
		DAO = new ProdutoDAO();
	}

	@Override
	public void inserir(final AbstractPO PO) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Inicio do bloco de Transação */
			hibernate.iniciarTransacao();

			if (PO == null) {
				throw new BackendException("Objeto nulo passado como parametro!");
			}
			ProdutoPO produto = null;
			if (PO instanceof ProdutoPO) {
				produto = (ProdutoPO) PO;
			} else {
				throw new BackendException("O Objeto PO passado não condiz com o contexto!");
			}

			if (!produto.getNome().matches(Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACO)) {
				throw new BackendException("No nome não são permitidos caracteres numéricos!");
			}

			DAO.inserir(hibernate, produto);
			hibernate.commitTransacao();
			/** Fim do bloco de transação */

		} catch (BackendException e) {
			throw e;
		} catch (Exception e) {
			throw new BackendException("Erro desconhecido ao inserir ", e);
		}

	}

	@Override
	public void alterar(final AbstractPO PO) throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Inicio do bloco de Transação */
			hibernate.iniciarTransacao();

			if (PO == null) {
				throw new BackendException("Objeto nulo passado como parametro!");
			}
			ProdutoPO produto = null;
			if (PO instanceof ProdutoPO) {
				produto = (ProdutoPO) PO;
			} else {
				throw new BackendException("O Objeto PO passado não condiz com o contexto!");
			}

			if (!produto.getNome().matches(Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACO)) {
				throw new BackendException("No nome não são permitidos caracteres numéricos!");
			}

			DAO.alterar(hibernate, produto);
			hibernate.commitTransacao();

		} catch (BackendException e) {
			throw e;
		} catch (Exception e) {
			throw new BackendException("Erro desconhecido ao alterar ", e);
		}

	}

	@Override
	public void excluir(final AbstractPO PO) throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Inicio do bloco de Transação */
			hibernate.iniciarTransacao();

			if (PO == null) {
				throw new BackendException("Objeto nulo passado como parametro!");
			}
			ProdutoPO produto = null;
			if (PO instanceof ProdutoPO) {
				produto = (ProdutoPO) PO;
			} else {
				throw new BackendException("O Objeto PO passado não condiz com o contexto!");
			}

			DAO.excluir(hibernate, produto);
			hibernate.commitTransacao();

		} catch (BackendException e) {
			throw e;
		} catch (Exception e) {
			throw new BackendException("Erro desconhecido ao excluir ", e);
		}

	}

	@Override
	public List filtrar(final AbstractPO PO) throws BackendException {
		try {
			ProdutoPO produto = null;

			if (PO != null) {

				if (PO instanceof ProdutoPO) {
					produto = (ProdutoPO) PO;
				} else {
					throw new BackendException("O Objeto PO passado não condiz com o contexto!");
				}
			}

			return DAO.filtrar(produto);
		} catch (BackendException e) {
			throw e;
		} catch (Exception e) {
			throw new BackendException("Erro desconhecido ao excluir ", e);
		}
	}

	@Override
	public AbstractPO filtrarPorId(final String ID) throws BackendException {
		try {

			if (ID == null) {
				throw new BackendException("ID nulo passado como parâmetro");
			}

			System.out.println("SERVICE: filtrando por id");

			return DAO.filtrarPorId(Long.valueOf(ID));
		} catch (BackendException e) {
			throw e;
		} catch (Exception e) {
			throw new BackendException("Erro desconhecido ao excluir ", e);
		}

	}

}