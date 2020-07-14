package br.com.srcsoftware.ws.produto;

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

import br.com.srcsoftware.efinanceiro.sistema.produto.controller.ProdutoFACADE;
import br.com.srcsoftware.efinanceiro.sistema.produto.model.ProdutoPO;
import br.com.srcsoftware.manager.exceptions.BackendException;

@Path("/produto")
public class ProdutoWs {

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String inserir(String produtoJson) {
		ProdutoPO produto = new ProdutoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(produtoJson).getAsJsonObject();

			produto = (gson.fromJson(object, ProdutoPO.class));

			ProdutoFACADE facade = new ProdutoFACADE();

			facade.inserir(produto);
			System.out.println(produto);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(produto);
	}

	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String alterar(String produtoJson) {
		ProdutoPO produto = new ProdutoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(produtoJson).getAsJsonObject();

			produto = (gson.fromJson(object, ProdutoPO.class));

			ProdutoFACADE facade = new ProdutoFACADE();

			facade.alterar(produto);
			System.out.println(produto);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(produto);
	}

	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String excluir(String produtoJson) {
		ProdutoPO produto = new ProdutoPO();
		try {
			Gson gson = new Gson();

			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(produtoJson).getAsJsonObject();

			produto = (gson.fromJson(object, ProdutoPO.class));

			ProdutoFACADE facade = new ProdutoFACADE();

			facade.excluir(produto);
			System.out.println(produto);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(produto);
	}

	@POST
	@Path("/filtrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String filtrar(String produtoJson) {
		List<ProdutoPO> produtos = null;
		try {
			Gson gson = new Gson();
			ProdutoPO produto = new ProdutoPO();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse(produtoJson).getAsJsonObject();

			produto = (gson.fromJson(object, ProdutoPO.class));

			ProdutoFACADE facade = new ProdutoFACADE();

			produtos = facade.filtrar(produto);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(produtos);
	}

	@GET
	@Path("/filtrarPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public String filtrarPorId(@PathParam("id") String id) {
		ProdutoPO produto = new ProdutoPO();
		try {
			ProdutoFACADE facade = new ProdutoFACADE();

			produto = (ProdutoPO) facade.filtrarPorId(id);

		} catch (BackendException e) {
			e.printStackTrace();
		}

		return new Gson().toJson(produto);
	}

}
