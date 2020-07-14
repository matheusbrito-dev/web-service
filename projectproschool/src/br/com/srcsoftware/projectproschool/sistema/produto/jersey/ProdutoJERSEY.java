package br.com.srcsoftware.projectproschool.sistema.produto.jersey;

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

import br.com.srcsoftware.projectproschool.sistema.produto.model.ProdutoPO;

public class ProdutoJERSEY {

	ClientConfig config = new DefaultClientConfig();
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	Client client = Client.create(config);
	WebResource webResource = client.resource("http://localhost:8080/eFinanceiro/ws/");

	public ProdutoPO inserir(ProdutoPO po) {

		String produtoJson = gson.toJson(po);
		String response = webResource.path("produto").path("inserir").type(MediaType.APPLICATION_JSON)
				.post(String.class, produtoJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		ProdutoPO produto = (gson.fromJson(object, ProdutoPO.class));

		System.out.println(response);
		return produto;

	}

	public ProdutoPO alterar(ProdutoPO po) {

		String produtoJson = gson.toJson(po);
		String response = webResource.path("produto").path("alterar").type(MediaType.APPLICATION_JSON)
				.post(String.class, produtoJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		ProdutoPO produto = (gson.fromJson(object, ProdutoPO.class));

		System.out.println(response);
		return produto;

	}

	public void excluir(ProdutoPO po) {

		String produtoJson = gson.toJson(po);
		String response = webResource.path("produto").path("excluir").type(MediaType.APPLICATION_JSON).post(String.class, produtoJson);

		System.out.println(response);
	}

	public ArrayList<ProdutoPO> filtrar(ProdutoPO po) {

		String produtoJson = gson.toJson(po);
		String response = webResource.path("produto").path("filtrar").type(MediaType.APPLICATION_JSON).post(String.class, produtoJson);

		ArrayList<ProdutoPO> produtos = new ArrayList<ProdutoPO>();
		JsonArray array = parser.parse(response).getAsJsonArray();
		
		for (int i = 0; i< array.size(); i++) {
			produtos.add(gson.fromJson(array.get(i), ProdutoPO.class));
		}
		System.out.println(response);
		return produtos;

	}

	public ProdutoPO filtrarPorId(String id) {
		String response = webResource.path("produto").path("filtrarPorId").path(id).type(MediaType.TEXT_PLAIN)
				.get(String.class);
		JsonObject object = parser.parse(response).getAsJsonObject();
		ProdutoPO produto = (gson.fromJson(object, ProdutoPO.class));
		System.out.println(response);
		return produto;
	}
}
