package com.heuristica.AG.AGMOCHILA;

import java.io.IOException;
import java.util.ArrayList;

public class Thebest {
	
	private Solucao melhor_so_global;
	private ArrayList<Integer> melhores_fo;
	private ArrayList<Integer> melhores_fo_pop;
	
	public Thebest(Inicializa ini) throws NumberFormatException, IOException{
		this.melhor_so_global = new Solucao(ini);
		this.melhores_fo = new ArrayList<>();
		this.melhores_fo_pop = new ArrayList<>();
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

	public ArrayList<Integer> getMelhores_fo_pop() {
		return melhores_fo_pop;
	}

	public void setMelhores_fo_pop(int melhor_fo_pop) {
		this.melhores_fo_pop.add(melhor_fo_pop);
	}

}
