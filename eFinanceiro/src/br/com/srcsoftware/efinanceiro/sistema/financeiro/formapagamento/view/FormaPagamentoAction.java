package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.utilidades.Messages;

public class FormaPagamentoAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		//Aplicando Especialização de ActionForm para FormaPagamento Form
		FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para FormaPagamento Form
			FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

			List< FormaPagamentoPO > encontrados;

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			encontrados = facade.filtrar( meuForm.getFormaPagamento() );

			meuForm.getFormaPagamentos().clear();
			meuForm.getFormaPagamentos().addAll( encontrados );

		} catch ( BackendException e ) {
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "formaPagamentoView" );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para FormaPagamento Form
			FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			facade.inserir( meuForm.getFormaPagamento() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para FormaPagamento Form
			FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			facade.alterar( meuForm.getFormaPagamento() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para FormaPagamento Form
			FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			facade.excluir( meuForm.getFormaPagamento() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( BackendException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para FormaPagamento Form
			FormaPagamentoForm meuForm = (FormaPagamentoForm) form;

			FormaPagamentoPO encontrado;

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();
			encontrado = (FormaPagamentoPO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setFormaPagamento( encontrado );

		} catch ( BackendException e ) {
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "formaPagamentoView" );
	}
	
}
