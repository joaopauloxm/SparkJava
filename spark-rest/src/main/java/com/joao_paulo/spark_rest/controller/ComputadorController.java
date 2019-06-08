package com.joao_paulo.spark_rest.controller;

import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.server.Response;

import com.google.gson.Gson;
import com.joao_paulo.spark_rest.model.Computador;
import com.joao_paulo.spark_rest.services.ComputadorServices;
import com.joao_paulo.spark_rest.util.Padrao;
import com.joao_paulo.spark_rest.util.Status;

import static spark.Spark.*;

public class ComputadorController {

	
	public static void main(String[] args) {

		List<Computador> lista = new ArrayList<Computador>();

		ComputadorServices computadorServices = new ComputadorServices();
		final String CONTENT_TYPE = "application/json";
		
		post("/computador", (request, response) -> {
			response.type(CONTENT_TYPE);
			
			Computador computador = new Gson().fromJson(request.body(), Computador.class);
			computador = ComputadorServices.save(computador);
			
			
			return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(computador)));
			
		});
		
		get("/computador", (request, response) -> {
			response.type(CONTENT_TYPE);

			final String mensagem = "Metodo GET";
			LOGGER.info(mensagem);
			response.status(200);
			return new Gson().toJson(lista);
		});

		put("/computadores/:id", (request, response) -> {

			Computador computador = new Gson().fromJson(request.body(), Computador.class);

			lista.removeIf(u -> u.getId().equals(user.getId()));
			lista.add(computador);

			final String mensagem = "Metodo PUT";
			LOGGER.info(mensagem);
			response.status(201);
			return new Gson().toJson(user);


//			response.type(CONTENT_TYPE);
//			int id = Integer.parseInt(request.params(":id"));
//
//			Computador computador = new Gson().fromJson(request.body(), Computador.class);
//			Computador computadorPut = ComputadorServices.update(computador, id);
//
//			if(computadorPut != null) {
//				return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(computadorPut)));
//			}
//			return new Gson().toJson(new Padrao(Status.ERROR,"Computador null"));
		});
	
		delete("/computadores/:id", (request, response) -> {

			Computador computador = new Computador();
			computador.setId(Integer.parseInt(request.params(":id")));


			lista.removeIf(u -> u.getId().equals(user.getId()));

			final String mensagem = "Acesso ao método DELETE. Registro deletado.";
			LOGGER.info(mensagem);
			response.status(204);
			return mensagem;

//			response.type(CONTENT_TYPE);
//			int id = Integer.parseInt(request.params(":id"));
//
//			computadorServices.remove(id);
//
//			return new Gson().toJson(new Padrao(Status.SUCCESS,"Computador excluido"));
		});
	}
	
}
