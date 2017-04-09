package com.cesar.teste2;

import java.util.ArrayList;

public class GrupoItens {

	private ArrayList<Item> grupo;
	
	public GrupoItens(Item item){
		grupo = new ArrayList<>();
		grupo.add(item);
	}

	public ArrayList<Item> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<Item> grupo) {
		this.grupo = grupo;
	}
	public String toString(){
		return "";
	}
}
