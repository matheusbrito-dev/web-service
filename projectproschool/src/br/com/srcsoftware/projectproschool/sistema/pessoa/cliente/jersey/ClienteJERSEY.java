package br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.jersey;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.srcsoftware.projectproschool.sistema.pessoa.cliente.model.ClientePO;

public class ClienteJERSEY {

	ClientConfig config = new DefaultClientConfig();
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	Client client = Client.create(config);
	WebResource webResource = client.resource("http://localhost:8080/eFinanceiro/ws/");

	public ClientePO inserir(ClientePO po) {

		String clienteJson = gson.toJson(po);
		String response = webResource.path("cliente").path("inserir").type(MediaType.APPLICATION_JSON)
				.post(String.class, clienteJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		ClientePO cliente = (gson.fromJson(object, ClientePO.class));

		System.out.println(response);
		return cliente;

	}

	public ClientePO alterar(ClientePO po) {

		String clienteJson = gson.toJson(po);
		String response = webResource.path("cliente").path("alterar").type(MediaType.APPLICATION_JSON)
				.post(String.class, clienteJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		ClientePO cliente = (gson.fromJson(object, ClientePO.class));

		System.out.println(response);
		return cliente;

	}

	public void excluir(ClientePO po) {

		String clienteJson = gson.toJson(po);
		String response = webResource.path("cliente").path("excluir").type(MediaType.APPLICATION_JSON).post(String.class, clienteJson);

		System.out.println(response);
	}

	public ArrayList<ClientePO> filtrar(ClientePO po) {

		String clienteJson = gson.toJson(po);
		String response = webResource.path("cliente").path("filtrar").type(MediaType.APPLICATION_JSON).post(String.class, clienteJson);

		ArrayList<ClientePO> clientes = new ArrayList<ClientePO>();
		JsonArray array = parser.parse(response).getAsJsonArray();
		
		for (int i = 0; i< array.size(); i++) {
			clientes.add(gson.fromJson(array.get(i), ClientePO.class));
		}
		System.out.println(response);
		return clientes;

	}

	public ClientePO filtrarPorId(String id) {
		String response = webResource.path("cliente").path("filtrarPorId").path(id).type(MediaType.TEXT_PLAIN)
				.get(String.class);
		JsonObject object = parser.parse(response).getAsJsonObject();
		ClientePO cliente = (gson.fromJson(object, ClientePO.class));
		System.out.println(response);
		return cliente;
	}
	
}
