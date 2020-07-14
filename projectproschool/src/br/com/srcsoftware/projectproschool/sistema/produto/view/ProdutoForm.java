package br.com.srcsoftware.projectproschool.sistema.produto.view;



import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.projectproschool.sistema.produto.model.ProdutoPO;

public class ProdutoForm extends ActionForm{

	private String idSelecionar;
	private ProdutoPO produto;
	private ArrayList< ProdutoPO > produtos;

	/** SINGLETON */
	public ProdutoPO getProduto() {
		if ( produto == null ) {
			produto = new ProdutoPO();

		}
		return produto;
	}

	public void setProduto( ProdutoPO produto ) {
		this.produto = produto;
	}

	public ArrayList< ProdutoPO > getProdutos() {
		if ( produtos == null ) {
			produtos = new ArrayList< ProdutoPO >();

		}
		return produtos;
	}

	public void setProdutos( ArrayList< ProdutoPO > produtos ) {
		this.produtos = produtos;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}


	public void limparTela() {
		setIdSelecionar( null );
		setProduto( null );
		getProdutos().clear();
	}	
	
}
