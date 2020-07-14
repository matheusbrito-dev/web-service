package br.com.srcsoftware.ws.cliente;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.controller.ClienteFACADE;
import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;
import br.com.srcsoftware.manager.exceptions.BackendException;

@Path("/cliente")
public class ClienteWs {

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String inserir(String clienteJson) {
		ClientePO cliente = new ClientePO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(clienteJson).getAsJsonObject();

			cliente = (gson.fromJson(object, ClientePO.class));

			ClienteFACADE facade = new ClienteFACADE();

			facade.inserir(cliente);
			System.out.println(cliente);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(cliente);
	}

	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String alterar(String clienteJson) {
		ClientePO cliente = new ClientePO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(clienteJson).getAsJsonObject();

			cliente = (gson.fromJson(object, ClientePO.class));

			ClienteFACADE facade = new ClienteFACADE();

			facade.alterar(cliente);
			System.out.println(cliente);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(cliente);
	}

	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String excluir(String clienteJson) {
		ClientePO cliente = new ClientePO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(clienteJson).getAsJsonObject();

			cliente = (gson.fromJson(object, ClientePO.class));

			ClienteFACADE facade = new ClienteFACADE();

			facade.excluir(cliente);
			System.out.println(cliente);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(cliente);
	}

	@POST
	@Path("/filtrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String filtrar(String clienteJson) {
		List<ClientePO> clientes = null;
		try {
			Gson gson = new Gson();
			ClientePO cliente = new ClientePO();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(clienteJson).getAsJsonObject();

			cliente = (gson.fromJson(object, ClientePO.class));

			ClienteFACADE facade = new ClienteFACADE();

			clientes = facade.filtrar(cliente);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(clientes);
	}

	@GET
	@Path("/filtrarPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public String filtrarPorId(@PathParam("id") String id) {
		ClientePO cliente = new ClientePO();
		try {
			ClienteFACADE facade = new ClienteFACADE();

			cliente = (ClientePO) facade.filtrarPorId(id);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(cliente);
	}

}
