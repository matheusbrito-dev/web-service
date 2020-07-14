package br.com.srcsoftware.ws.formapagamento;

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

import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.controller.FormaPagamentoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model.FormaPagamentoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

@Path("/formaPagamento")
public class FormaPagamentoWs {

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String inserir(String formaPagamentoJson) {
		FormaPagamentoPO formaPagamento = new FormaPagamentoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(formaPagamentoJson).getAsJsonObject();

			formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

			facade.inserir(formaPagamento);
			System.out.println(formaPagamento);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(formaPagamento);
	}

	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String alterar(String formaPagamentoJson) {
		FormaPagamentoPO formaPagamento = new FormaPagamentoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(formaPagamentoJson).getAsJsonObject();

			formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

			facade.alterar(formaPagamento);
			System.out.println(formaPagamento);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(formaPagamento);
	}

	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String excluir(String formaPagamentoJson) {
		FormaPagamentoPO formaPagamento = new FormaPagamentoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(formaPagamentoJson).getAsJsonObject();

			formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

			facade.excluir(formaPagamento);
			System.out.println(formaPagamento);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(formaPagamento);
	}

	@POST
	@Path("/filtrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String filtrar(String formaPagamentoJson) {
		List<FormaPagamentoPO> formaPagamentos = null;
		try {
			Gson gson = new Gson();
			FormaPagamentoPO formaPagamento = new FormaPagamentoPO();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(formaPagamentoJson).getAsJsonObject();

			formaPagamento = (gson.fromJson(object, FormaPagamentoPO.class));

			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

			formaPagamentos = facade.filtrar(formaPagamento);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(formaPagamentos);
	}

	@GET
	@Path("/filtrarPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public String filtrarPorId(@PathParam("id") String id) {
		FormaPagamentoPO formaPagamento = new FormaPagamentoPO();
		try {
			FormaPagamentoFACADE facade = new FormaPagamentoFACADE();

			formaPagamento = (FormaPagamentoPO) facade.filtrarPorId(id);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(formaPagamento);
	}
	
}
