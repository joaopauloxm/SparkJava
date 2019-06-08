package com.joao_paulo.spark_rest.services;

import java.util.Collection;
import java.util.HashMap;

import com.joao_paulo.spark_rest.model.Computador;

public class ComputadorServices {

	private int id = 0;
	
	private HashMap<String, Computador> computadorHashMap = new HashMap<>();

	private computador put;
	
	public Computador save(Computador computador) {
		computador.setId(getNextId());
		return computadorHashMap.put(String.valueOf(computador.getId()), computador);
	}
	
	public Computador update(Computador computador, int id) {
		Computador computadorToUpdate = findById(id);

		computadorToUpdate.setNome(computador.getDescricao());
		computadorToUpdate.setModelo(computador.getModelo());
		
		
		return computadorToUpdate;
	}
	
	public void remove(int id) {
		computadorHashMap.remove(String.valueOf(id));
	}

	private int getNextId() {
		
		return ++this.id;
	}
	
	public Computador findById(int id) {
		return computadorHashMap.get(String.valueOf(id));
	}
	
	public Collection<Computador> listAll(){
		return computadorHashMap.values();
	}
	
	
}
