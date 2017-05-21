package com.heuristica.SA.SAMOCHILA;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.heuristica.AG.AGMOCHILA.Solucao;

@SuppressWarnings("serial")
public class CloneSA implements Cloneable, Serializable{

	Solucao solucao;
	
	public CloneSA clone(){
		try {
			return (CloneSA) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	public CloneSA deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (CloneSA) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}
	
}
