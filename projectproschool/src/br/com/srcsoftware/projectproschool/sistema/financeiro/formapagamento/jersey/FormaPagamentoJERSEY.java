package br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.jersey;

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

import br.com.srcsoftware.projectproschool.sistema.financeiro.formapagamento.model.FormaPagamentoPO;

public class FormaPagamentoJERSEY {

	ClientConfig config = new DefaultClientConfig();
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	Client client = Client.create(config);
	WebResource webResource = client.resource("http://localhost:8080/eFinanceiro/ws/");

	public FormaPagamentoPO inserir(FormaPagamentoPO po) {

		String formaPagamentoJson = gson.toJson(po);
		String response = webResource.path("formaPagamento").path("inserir").type(MediaType.APPLICATION_JSON)
				.post(String.class, formaPagamentoJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		FormaPagamentoPO formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

		System.out.println(response);
		return formaPagamento;

	}

	public FormaPagamentoPO alterar(FormaPagamentoPO po) {

		String formaPagamentoJson = gson.toJson(po);
		String response = webResource.path("formaPagamento").path("alterar").type(MediaType.APPLICATION_JSON)
				.post(String.class, formaPagamentoJson);

		JsonObject object = parser.parse(response).getAsJsonObject();
		FormaPagamentoPO formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

		System.out.println(response);
		return formaPagamento;

	}

	public void excluir(FormaPagamentoPO po) {

		String formaPagamentoJson = gson.toJson(po);
		String response = webResource.path("formaPagamento").path("excluir").type(MediaType.APPLICATION_JSON).post(String.class, formaPagamentoJson);

		System.out.println(response);
	}

	public ArrayList<FormaPagamentoPO> filtrar(FormaPagamentoPO po) {

		String formaPagamentoJson = gson.toJson(po);
		String response = webResource.path("formaPagamento").path("filtrar").type(MediaType.APPLICATION_JSON).post(String.class, formaPagamentoJson);

		ArrayList<FormaPagamentoPO> formaPagamentos = new ArrayList<FormaPagamentoPO>();
		JsonArray array = parser.parse(response).getAsJsonArray();
		
		for (int i = 0; i< array.size(); i++) {
			formaPagamentos.add(gson.fromJson(array.get(i), FormaPagamentoPO.class));
		}
		System.out.println(response);
		return formaPagamentos;

	}

	public FormaPagamentoPO filtrarPorId(String id) {
		String response = webResource.path("formaPagamento").path("filtrarPorId").path(id).type(MediaType.TEXT_PLAIN)
				.get(String.class);
		JsonObject object = parser.parse(response).getAsJsonObject();
		FormaPagamentoPO formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));
		System.out.println(response);
		return formaPagamento;
	}
	
}
