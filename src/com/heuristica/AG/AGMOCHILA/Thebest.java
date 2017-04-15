package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;

public class Thebest {
	
	private Solucao melhor_so_global;
	private ArrayList<Integer> melhores_fo;
	
	public Thebest() throws NumberFormatException, IOException{
		this.melhor_so_global = new Solucao();
		this.melhores_fo = new ArrayList<>();
	}

	public Solucao getMelhor_so_global() {
		return melhor_so_global;
	}

	public void setMelhor_so_global(Solucao melhor_so_global) {
		this.melhor_so_global = melhor_so_global;
	}

	public ArrayList<Integer> getMelhores_fo() {
		return melhores_fo;
	}

	public void setMelhores_fo(int melhor_fo) {
		this.melhores_fo.add(melhor_fo);
	}

}
