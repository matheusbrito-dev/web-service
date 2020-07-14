package br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.jersey.teste;

import br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.jersey.ClienteJERSEY;
import br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.model.ClientePO;

public class TesteClienteJERSEY {
	public static void main(String[] args) {
		ClientePO po = new ClientePO();
		
		/*po.setTelefone("123123123");
		po.setStatus(true);
		po.setSexo("Masculino");
		po.setNome("Larissaaa");
		po.setEndereco("asdasd");
		po.setEmail("asdasdas");
		po.setCpf("123123");
		inserir(po);*/
		
	    /*po.setIdToString("1");
		po.setTelefone("123123123");
		po.setStatus(true);
		po.setSexo("Masculino");
		po.setEndereco("asdasd");
		po.setEmail("asdasdas");
		po.setCpf("123123");
		po.setNome("Gabriel ALTERADO");
		po.setCpf("123123");
		alterar(po);*/
		
		/*po.setIdToString("1");
		filtrar(po);*/

		/*excluir("1");*/

	}

	private static void filtrar(ClientePO po) {
		ClienteJERSEY jersey = new ClienteJERSEY();
		jersey.filtrar(po);

	}

	private static void excluir(String id) {

		ClienteJERSEY jersey = new ClienteJERSEY();
		ClientePO po = jersey.filtrarPorId(id);
		jersey.excluir(po);

	}

	private static void alterar(ClientePO po) {
		ClienteJERSEY jersey = new ClienteJERSEY();
		jersey.alterar(po);

	}

	private static void inserir(ClientePO po) {

		ClienteJERSEY jersey = new ClienteJERSEY();
		jersey.inserir(po);

	}
}
