package br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.view;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.model.FormaPagamentoPO;

public class FormaPagamentoForm extends ActionForm{

	private String idSelecionar;
	private FormaPagamentoPO formaPagamento;
	private ArrayList< FormaPagamentoPO > formaPagamentos;

	/** SINGLETON */
	public FormaPagamentoPO getFormaPagamento() {
		if ( formaPagamento == null ) {
			formaPagamento = new FormaPagamentoPO();

		}
		return formaPagamento;
	}

	public void setFormaPagamento( FormaPagamentoPO formaPagamento ) {
		this.formaPagamento = formaPagamento;
	}

	public ArrayList< FormaPagamentoPO > getFormaPagamentos() {
		if ( formaPagamentos == null ) {
			formaPagamentos = new ArrayList< FormaPagamentoPO >();

		}
		return formaPagamentos;
	}

	public void setFormaPagamentos( ArrayList< FormaPagamentoPO > formaPagamentos ) {
		this.formaPagamentos = formaPagamentos;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}

	public void limparTela() {
		setIdSelecionar( null );
		setFormaPagamento( null );
		getFormaPagamentos().clear();
	}
	
}

