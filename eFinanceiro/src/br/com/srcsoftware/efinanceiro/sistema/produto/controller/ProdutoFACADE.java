package br.com.srcsoftware.efinanceiro.sistema.produto.controller;

import java.util.List;

import br.com.srcsoftware.efinanceiro.sistema.produto.model.ProdutoSERVICE;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.exceptions.BackendException;
import br.com.srcsoftware.manager.interfaces.Crud;

public class ProdutoFACADE implements Crud{
	
	/** Garante a aplica��o da associa��o entre o CONTROLLER e o SERVICE */
	private final ProdutoSERVICE SERVICE;

	public ProdutoFACADE(){
		SERVICE = new ProdutoSERVICE();
	}

	@Override
	public void inserir( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: inserindo" );
		SERVICE.inserir( po );

	}

	@Override
	public void alterar( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: alterando" );
		SERVICE.alterar( po );

	}

	@Override
	public void excluir( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: excluindo" );
		SERVICE.excluir( po );

	}

	@Override
	public List filtrar( AbstractPO po ) throws BackendException {
		System.out.println( "FACADE: filtrando" );
		return SERVICE.filtrar( po );
	}

	@Override
	public AbstractPO filtrarPorId( String id ) throws BackendException {
		System.out.println( "FACADE: filtrando por id" );
		return SERVICE.filtrarPorId( id );
	}


}