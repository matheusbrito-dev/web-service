package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.controller.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.controller.ClienteFACADE;
import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TestaClienteFACADE {

	public static void main(String[] args) {
		try {

			ClienteFACADE facade = new ClienteFACADE();
			/** Criar uma Cliente */
			ClientePO po = new ClientePO();
			po.setId( 1L );
			po.setNome("Pedrinho");
			po.setCpf("123123");
			po.setEmail("askdhaoisdu");
			po.setEndereco("asjkldhaoisudh");
			po.setSexo("M");
			po.setTelefone("12123123");
			po.setStatus(true);
			
			/** inserir */
			facade.inserir( po );

			/** Filtrando todos para ver se inseriu */
			List encontrados = facade.filtrar( null );// Lista e para varias
			System.out.println( encontrados );// igual a encontrados.toString

			/** Filtrando por ID para alterar */
			ClientePO encotrado = (ClientePO) facade.filtrarPorId( "1" );

			/** Alterar o Cliente encontrada */
			encotrado.setNome( "José" );
			facade.alterar( encotrado );

			/** Filtrando por ID para alterar para varificar a alteração e excluir */
			encotrado = (ClientePO) facade.filtrarPorId( "1" );

			/** Excluindo */
			facade.excluir( encotrado );

			/** Filtrando todos para ver se excluir */
			encontrados = facade.filtrar( null );// Lista e para varias
			System.out.println( encontrados );// igual a encontrados.toString

		} catch ( BackendException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}
	}
	
}
