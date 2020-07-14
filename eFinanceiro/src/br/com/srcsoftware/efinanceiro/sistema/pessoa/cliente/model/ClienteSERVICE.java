package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model;

import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.dao.ClienteDAO;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.interfaces.Crud;
import br.com.srcsoftware.manager.utilidades.Utilidades;

public class ClienteSERVICE implements Crud {
	
	private final ClienteDAO DAO;

	public ClienteSERVICE() {
		// Quando o FACEDE instanciar o SERVICE automaticamente irá para o DAO
		DAO = new ClienteDAO();
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
			ClientePO cliente = null;
			if (PO instanceof ClientePO) {
				cliente = (ClientePO) PO;
			} else {
				throw new BackendException("O Objeto PO passado não condiz com o contexto!");
			}

			if (!cliente.getNome().matches(Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACO)) {
				throw new BackendException("No nome não são permitidos caracteres numéricos!");
			}
			if (!cliente.getSexo().matches(Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACO)) {
				throw new BackendException("No nome não são permitidos caracteres numéricos!");
			}

			DAO.inserir(hibernate, cliente);
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

			if ( PO == null ) {
				throw new BackendException( "Objeto nulo passado como parametro!" );
			}
			ClientePO Cliente = null;
			if ( PO instanceof ClientePO ) {
				Cliente = (ClientePO) PO;
			} else {
				throw new BackendException( "O Objeto PO passado não condiz com o contexto!" );
			}

			DAO.alterar( hibernate, Cliente );
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
			ClientePO cliente = null;
			if (PO instanceof ClientePO) {
				cliente = (ClientePO) PO;
			} else {
				throw new BackendException("O Objeto PO passado não condiz com o contexto!");
			}

			DAO.excluir(hibernate, cliente);
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
			ClientePO cliente = null;

			if (PO != null) {

				if (PO instanceof ClientePO) {
					cliente = (ClientePO) PO;
				} else {
					throw new BackendException("O Objeto PO passado não condiz com o contexto!");
				}
			}

			return DAO.filtrar(cliente);
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
