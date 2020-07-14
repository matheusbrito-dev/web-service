package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.view;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;

public class ClienteForm extends ActionForm{

	private String idSelecionar;
	private ClientePO cliente;
	private ArrayList< ClientePO > clientes;

	/** SINGLETON */
	public ClientePO getCliente() {
		if ( cliente == null ) {
			cliente = new ClientePO();

		}
		return cliente;
	}

	public void setCliente( ClientePO cliente ) {
		this.cliente = cliente;
	}

	public ArrayList< ClientePO > getClientes() {
		if ( clientes == null ) {
			clientes = new ArrayList< ClientePO >();

		}
		return clientes;
	}

	public void setClientes( ArrayList< ClientePO > clientes ) {
		this.clientes = clientes;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}


	public void limparTela() {
		setIdSelecionar( null );
		setCliente( null );
		getClientes().clear();
	}	
	
}
