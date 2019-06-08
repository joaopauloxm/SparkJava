package com.joao_paulo.spark_rest.util;

import com.google.gson.JsonElement;

import lombok.*;

@Getter @Setter
public class Padrao {

	private Status status;
	private String mensagem;
	private JsonElement computador;
	
	public Padrao(Status status) {
		this.status = status;
	}
	
	public Padrao(Status status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public Padrao(Status status, JsonElement computador) {
		this.status = status;
		this.computador = computador;
	}

}
