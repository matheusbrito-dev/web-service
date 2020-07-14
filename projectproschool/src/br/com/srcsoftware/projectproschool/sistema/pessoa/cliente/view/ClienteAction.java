package br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.manager.utilidades.Messages;
import br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.jersey.ClienteJERSEY;
import br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.model.ClientePO;

public class ClienteAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		//Aplicando Especialização de ActionForm para Cliente Form
		ClienteForm meuForm = (ClienteForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Cliente Form
			ClienteForm meuForm = (ClienteForm) form;

			List< ClientePO > encontrados;

			ClienteJERSEY facade = new ClienteJERSEY();
			encontrados = facade.filtrar( meuForm.getCliente() );

			meuForm.getClientes().clear();
			meuForm.getClientes().addAll( encontrados );

		}catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "clienteView" );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Cliente Form
			ClienteForm meuForm = (ClienteForm) form;

			ClienteJERSEY facade = new ClienteJERSEY();
			facade.inserir( meuForm.getCliente() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		}catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Cliente Form
			ClienteForm meuForm = (ClienteForm) form;

			ClienteJERSEY facade = new ClienteJERSEY();
			facade.alterar( meuForm.getCliente() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		}catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Cliente Form
			ClienteForm meuForm = (ClienteForm) form;

			ClienteJERSEY facade = new ClienteJERSEY();
			facade.excluir( meuForm.getCliente() );

			meuForm.limparTela();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", "Erro desconhecido, " + e.getMessage() ) );
		}
		return filtrar( mapping, form, request, response );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		try {
			//Aplicando Especialização de ActionForm para Cliente Form
			ClienteForm meuForm = (ClienteForm) form;

			ClientePO encontrado;

			ClienteJERSEY facade = new ClienteJERSEY();
			encontrado = (ClientePO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setCliente( encontrado );

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return mapping.findForward( "clienteView" );
	}
	
}
